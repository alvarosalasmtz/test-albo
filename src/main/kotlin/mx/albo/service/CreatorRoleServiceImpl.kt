package mx.albo.service

import mx.albo.model.dto.CreatorRole
import mx.albo.model.dto.CreatorSummary
import mx.albo.model.entity.Collaborator
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class CreatorRoleServiceImpl : CreatorRoleService {

    private var map: Map<String, (CreatorRole) -> Boolean> = HashMap()

    @PostConstruct
    private fun init() {
        map = mapOf(
            "editor" to assignCreatorEditor,
            "writer" to assignCreatorWriter,
            "colorist" to assignCreatorColorist
        )
    }

    override fun assignCreatorByRole(collaborator: Collaborator, creatorSummary: CreatorSummary) {
        map[creatorSummary.role]?.invoke(CreatorRole(collaborator, creatorSummary.name))
    }

    private val assignCreatorEditor: (CreatorRole) -> Boolean = fun(creatorRole: CreatorRole): Boolean {
        return creatorRole.collaborator.editors.add(creatorRole.name)
    }

    private val assignCreatorWriter: (CreatorRole) -> Boolean = fun(creatorRole: CreatorRole): Boolean {
        return creatorRole.collaborator.writers.add(creatorRole.name)
    }

    private val assignCreatorColorist: (CreatorRole) -> Boolean = fun(creatorRole: CreatorRole): Boolean {
        return creatorRole.collaborator.colorists.add(creatorRole.name)
    }
}