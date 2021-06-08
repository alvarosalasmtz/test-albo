package mx.albo.controller

import mx.albo.model.entity.Character
import mx.albo.service.CharacterService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/characters")
@RestController
class CharacterController(private val characterService: CharacterService) {

    @GetMapping("/{character}")
    fun findOneByHero(@PathVariable character: String): ResponseEntity<Character> {
        return ResponseEntity(characterService.findOneById(character), HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody character: Character): ResponseEntity<String> {
        characterService.save(character)
        return ResponseEntity("SUCCESS", HttpStatus.OK)
    }
}