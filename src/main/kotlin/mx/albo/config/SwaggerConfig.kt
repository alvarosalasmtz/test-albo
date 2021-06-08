package mx.albo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*


@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun apiDocket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("mx.albo.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo)
    }

    private val apiInfo: ApiInfo
        private get() = ApiInfo(
            "Test Albo Marvel API",
            "Examen Albo API Marvel",
            "1.0.0",
            "http://test.albo.com",
            Contact("Alvaro Salas", "https://github.com/alvarosalasmtz", "alvarosalasmtz@gmail.com"),
            "LICENSE",
            "LICENSE URL",
            Collections.emptyList()
        )
}