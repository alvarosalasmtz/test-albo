package mx.albo.repository

import mx.albo.model.entity.Character
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CharacterRepository : MongoRepository<Character, String>