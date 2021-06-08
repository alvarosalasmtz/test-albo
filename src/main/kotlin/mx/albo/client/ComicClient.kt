package mx.albo.client

import mx.albo.model.dto.ComicDataWrapperResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam


@FeignClient(value = "comics", url = "\${marvel.comic.api.url}")
interface ComicClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["/v1/public/comics"])
    fun getComics(
        @RequestParam limit: Int,
        @RequestParam offset: Int,
        @RequestParam format: String,
        @RequestParam noVariants: Boolean,
        @RequestParam formatType: String
    ): ComicDataWrapperResponse?
}