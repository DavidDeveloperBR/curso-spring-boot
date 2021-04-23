package io.github.davidrodrigues.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SawaggerConfig {

    @Bean
    public Docket docket(){

        return new Docket(DocumentationType.SWAGGER_2).
                useDefaultResponseMessages(false).
                select().
                    apis(RequestHandlerSelectors.basePackage("io.github.dougllasfps.rest.controller"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .apiInfo(apiInfo());

    }

    public ApiInfo apiInfo(){

        return new ApiInfoBuilder().
                title("Aprendizado Spring Boot - Vendas API").
                description("API do projeto de vendas, curso online de Spring Boot").
                version("1.0").
                contact(contact()).
                build();
    }

    private Contact contact(){

        return new Contact("David Rodrigues",
                "https://github.com/DavidDeveloperBR",
                "david152012@hotmail.com");

    }

    public ApiKey apiKey(){

        return new ApiKey("JWT", "Authorization","header");

    }

    private SecurityContext securityContext(){

        return SecurityContext.builder().securityReferences(defaultAuth())
                .forPaths(PathSelectors.any()).build();
    }


    private List<SecurityReference> defaultAuth(){

        AuthorizationScope authorizationScope = new AuthorizationScope(
            "global", "accessEverything"
        );

        AuthorizationScope[] scope = new AuthorizationScope[1];

        scope[0] =authorizationScope;

        SecurityReference reference = new SecurityReference("JWT", scope);

        List<SecurityReference> auths = new ArrayList<>();

        auths.add(reference);

        return auths;




    }
}
