package mx.albo.service

import mx.albo.exception.CollaboratorException
import mx.albo.model.entity.Collaborator
import mx.albo.repository.CollaboratorRepository
import mx.albo.utils.MD5Util
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class CollaboratorServiceImpl(private val collaboratorRepository: CollaboratorRepository) : CollaboratorService {

    override fun findOpById(id: String): Optional<Collaborator> {
        return collaboratorRepository.findById(MD5Util.generate(id))
    }

    override fun findOneById(id: String): Collaborator {
        val op: Optional<Collaborator> = findOpById(id)
        if (!op.isPresent) throw CollaboratorException("Collaborator not found.")
        return op.get()
    }

    override fun save(collaborator: Collaborator) {
        collaborator.lastSync = LocalDateTime.now()
        collaboratorRepository.save(collaborator)
    }

    override fun findAll(): List<Collaborator> {
        return collaboratorRepository.findAll()
    }
}