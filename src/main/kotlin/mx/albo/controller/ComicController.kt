package mx.albo.controller

import mx.albo.model.dto.ComicDataWrapperResponse
import mx.albo.service.ComicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/comics")
@RestController
class ComicController(private val comicService: ComicService) {

    @GetMapping
    fun info(): ResponseEntity<ComicDataWrapperResponse> {
        return ResponseEntity(
            comicService.getComics(),
            HttpStatus.OK
        )
    }

    @PatchMapping
    fun updateAsync(): ResponseEntity<ComicDataWrapperResponse> {
        comicService.update()
        return ResponseEntity(HttpStatus.OK)
    }
}