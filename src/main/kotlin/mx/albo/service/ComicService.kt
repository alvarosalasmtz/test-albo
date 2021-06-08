package mx.albo.service

import mx.albo.model.dto.ComicDataWrapperResponse

interface ComicService {
    fun getComics(): ComicDataWrapperResponse?
    fun update()
}