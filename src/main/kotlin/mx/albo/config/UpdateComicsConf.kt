package mx.albo.config

import mx.albo.service.ComicService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.CompletableFuture


@Configuration
class UpdateComicsConf(private val comicService: ComicService) {

    @Bean
    fun update() {
        CompletableFuture.supplyAsync {
            comicService.update()
        }
    }
}
