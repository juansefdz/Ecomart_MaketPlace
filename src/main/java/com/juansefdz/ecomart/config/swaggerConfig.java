package com.juansefdz.ecomart.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(
    info =@Info(
        title = "Ecomart API",
        version = "1.0",
        description = "Ecomart API Documentation",
        termsOfService = "https://www.juansefdz.dev",
        contact = @Contact(
            name = "JuanseFdz",
            url = "https://www.juansefdz.dev",
            email = "juanse.fermon@gmail.com"
        ),
        license = @License(
            name = "JUANSEFDZ.DEV"
        )
    )
)

public class swaggerConfig {
    
}
