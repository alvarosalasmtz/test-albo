package mx.albo.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
class Collaborator {
    @Id
    var id: String? = null
    var character: String? = null
    var editors: MutableSet<String> = HashSet()
    var writers: MutableSet<String> = HashSet()
    var colorists: MutableSet<String> = HashSet()
    var lastSync: LocalDateTime = LocalDateTime.now()
}