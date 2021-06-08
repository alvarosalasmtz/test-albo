package mx.albo.service

import mx.albo.client.ComicClient
import mx.albo.model.dto.CharacterSummary
import mx.albo.model.dto.ComicDataWrapperResponse
import mx.albo.model.dto.CreatorSummary
import mx.albo.model.entity.Character
import mx.albo.model.entity.CharacterComic
import mx.albo.model.entity.Collaborator
import mx.albo.utils.MD5Util
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class ComicServiceImpl(
    private val comicClient: ComicClient,
    private val collaboratorService: CollaboratorService,
    private val creatorRoleService: CreatorRoleService,
    private val characterService: CharacterService
) : ComicService {

    override fun getComics(): ComicDataWrapperResponse? {
        return comicClient.getComics(LIMIT, 0, Companion.COMIC, true, Companion.COMIC)
    }

    @Async
    @Scheduled(cron = "* * 0 * * * ")
    override fun update() {
        updateProcessor(0)
    }

    fun updateProcessor(offset: Int): Boolean {
        val response = comicClient.getComics(LIMIT, offset, Companion.COMIC, true, Companion.COMIC)
        if (response?.code != 200) return false
        if (response.data?.total!! < offset) return false
        response.data.results?.parallelStream()?.forEach { comic ->
            val creators = comic.creators?.items
            val characters = comic.characters?.items
            characters?.forEach { item ->
                processCollaborator(item, creators!!)
                processCharacter(characters, item, comic?.title!!)
            }
        }
        updateProcessor(offset + LIMIT)
        return true
    }

    private fun processCollaborator(item: CharacterSummary, creators: List<CreatorSummary>) {
        val id = MD5Util.generate(item.name)
        val op = collaboratorService.findOpById(id)
        var collaborator = Collaborator()
        if (!op.isPresent) {
            collaborator.id = id
            collaborator.character = item.name
        } else {
            collaborator = op.get()
        }
        creators.forEach { creator ->
            creatorRoleService.assignCreatorByRole(collaborator, creator)
        }
        collaboratorService.save(collaborator)
    }

    private fun processCharacter(characters: List<CharacterSummary>, item: CharacterSummary, comicName: String) {
        val charactersClone = HashSet(characters)
        charactersClone.remove(item)
        val id = MD5Util.generate(item.name)
        val op = characterService.findOpById(id)
        var character = Character()
        if (op.isPresent) {
            character = op.get()
        } else {
            character.id = id
            character.character = item.name
        }
        charactersClone.forEach {
            var characterComic = CharacterComic()
            characterComic.character = it.name
            characterComic.comics.add(comicName)
            character.characters.add(characterComic)
        }
        characterService.save(character)
    }

    companion object {
        private const val COMIC = "comic"
        private const val LIMIT = 100
    }
}