package mx.albo.service

import mx.albo.model.entity.Collaborator
import java.util.*

interface CollaboratorService {
    fun findOpById(id: String): Optional<Collaborator>
    fun findOneById(id: String): Collaborator
    fun save(collaborator: Collaborator)
    fun findAll(): List<Collaborator>
}