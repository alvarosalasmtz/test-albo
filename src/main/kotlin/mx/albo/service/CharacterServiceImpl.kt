package mx.albo.service

import mx.albo.exception.CharacterException
import mx.albo.model.entity.Character
import mx.albo.repository.CharacterRepository
import mx.albo.utils.MD5Util
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class CharacterServiceImpl(private val characterRepository: CharacterRepository) : CharacterService {

    override fun findOpById(id: String): Optional<Character> {
        return characterRepository.findById(MD5Util.generate(id))
    }

    override fun findOneById(id: String): Character {
        val op: Optional<Character> = findOpById(id)
        if (!op.isPresent) throw CharacterException("Character not found.")
        return op.get()
    }

    override fun save(character: Character) {
        character.lastSync = LocalDateTime.now()
        characterRepository.save(character)
    }

    override fun findAll(): List<Character> {
        return characterRepository.findAll()
    }
}