package br.com.docket.teste.cartorio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("br.com.docket.teste.cartorio.controller"))
                    .paths(PathSelectors.any())
                    .build();
        }

    private ApiInfoBuilder informacoesApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Api-Cartorio");
        apiInfoBuilder.description("Api desenvolida somente teste em umas das etapas na Empresa Docket.");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Deve ser usada para estudos.");
        apiInfoBuilder.license("Licença - Open Source");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;

    }
    private Contact contato() {

        return new Contact(
                "Luiz Rodrigo Alves Da silva",
        "https://www.linkedin.com/in/luiz-rodrigo-alves-da-silva-9815b3100/",
        "luizrodrigo7988@gmail.com");
    }
}
