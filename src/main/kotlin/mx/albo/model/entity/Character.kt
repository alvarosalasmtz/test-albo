package mx.albo.model.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
class Character {
    @Id
    var id: String? = null
    var character: String? = null
    var characters: MutableSet<CharacterComic> = HashSet()
    var lastSync: LocalDateTime = LocalDateTime.now()
}