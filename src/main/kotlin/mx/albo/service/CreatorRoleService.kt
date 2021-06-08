package mx.albo.service

import mx.albo.model.dto.CreatorSummary
import mx.albo.model.entity.Collaborator

interface CreatorRoleService {
    fun assignCreatorByRole(collaborator: Collaborator, creatorSummary: CreatorSummary)
}