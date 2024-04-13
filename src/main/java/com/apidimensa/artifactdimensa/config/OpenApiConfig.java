package com.apidimensa.artifactdimensa.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "João Bomfim Povinha",
                        email = "joao.b.p@hotmail.com",
                        url = "https://www.linkedin.com/in/joao-bomfim-povinha/"
                ),
                description = "Documentação OpenAPI (Swagger) para API RESTful desenvolvida exclusivamente para o desafio técnico - Dimensa",
                title = "API RESTful - Desafio Dimensa - João Bomfim Povinha"
        )
)
public class OpenApiConfig {
}
