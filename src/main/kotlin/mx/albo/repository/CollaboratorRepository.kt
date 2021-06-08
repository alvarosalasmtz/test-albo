package mx.albo.repository

import mx.albo.model.entity.Collaborator
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CollaboratorRepository : MongoRepository<Collaborator, String>