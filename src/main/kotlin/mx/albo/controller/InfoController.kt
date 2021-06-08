package mx.albo.controller

import mx.albo.model.dto.InfoResponse
import mx.albo.service.CollaboratorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class InfoController(private val collaboratorService: CollaboratorService) {

    @GetMapping
    fun info(): ResponseEntity<InfoResponse> {
        return ResponseEntity(
            InfoResponse("TestAlbo", "Alvaro Salas", "alvarosalasmtz@gmail.com"),
            HttpStatus.OK
        )
    }
}