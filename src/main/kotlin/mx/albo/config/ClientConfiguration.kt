package mx.albo.config

import feign.Logger
import feign.RequestInterceptor
import feign.RequestTemplate
import feign.codec.ErrorDecoder
import mx.albo.utils.MD5Util
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.sql.Timestamp
import java.time.LocalDateTime


@Configuration
class ClientConfiguration {

    @Value("\${marvel.comic.api.keys.private}")
    lateinit var privateKey: String

    @Value("\${marvel.comic.api.keys.public}")
    lateinit var publicKey: String

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }

    @Bean
    fun errorDecoder(): ErrorDecoder {
        return ErrorDecoder.Default()
    }

    @Bean
    fun requestInterceptor(): RequestInterceptor {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            val now = LocalDateTime.now()
            val timestamp: Timestamp = Timestamp.valueOf(now)
            requestTemplate.query("ts", "${timestamp.time}")
            requestTemplate.query("apikey", publicKey)
            requestTemplate.query("hash", MD5Util.generate("${timestamp.time}${privateKey}${publicKey}"))
        }
    }
}
