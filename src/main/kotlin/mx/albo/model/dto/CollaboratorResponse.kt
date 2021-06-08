package mx.albo.model.dto

import java.io.Serializable

class CollaboratorResponse : Serializable {
    val lastSync: String? = null
    val editors: List<String>? = null
    val writers: List<String>? = null
    val colorists: List<String>? = null
}