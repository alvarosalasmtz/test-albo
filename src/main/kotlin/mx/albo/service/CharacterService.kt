package mx.albo.service

import mx.albo.model.entity.Character
import java.util.*

interface CharacterService {
    fun findOpById(id: String): Optional<Character>
    fun findOneById(id: String): Character
    fun save(character: Character)
    fun findAll(): List<Character>
}