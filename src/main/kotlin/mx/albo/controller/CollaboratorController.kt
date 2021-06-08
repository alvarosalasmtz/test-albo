package mx.albo.controller

import mx.albo.model.entity.Collaborator
import mx.albo.service.CollaboratorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/collaborators")
@RestController
class CollaboratorController(private val collaboratorService: CollaboratorService) {

    @GetMapping("/{character}")
    fun findOneByHero(@PathVariable character: String): ResponseEntity<Collaborator> {
        return ResponseEntity(collaboratorService.findOneById(character), HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody collaborator: Collaborator): ResponseEntity<String> {
        collaboratorService.save(collaborator)
        return ResponseEntity("SUCCESS", HttpStatus.OK)
    }
}