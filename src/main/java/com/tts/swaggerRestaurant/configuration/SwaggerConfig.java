package com.tts.swaggerRestaurant.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
Enabling Swagger UI is straightforward. The implementation for Swagger in
Java is provided by a framework called Springfox.
1. Add two dependencies to the pom.xml file: springfox-swagger2 and
springfox-swagger-ui
2. Add a configuration class to the project: SwaggerConfig Class and
the api() method below
3. navigate to this page after running:
http://localhost:8080/swagger-ui/index.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*
    By changing the line below that says .any()
    Starting with the SwaggerConfig class, we can change the request
    handler selectors to only select controllers we have created. This
    will make Swagger ignore the built-in Spring Boot error handler
    controllers that get pulled in by default.
     */
    @Bean
    public Docket apiV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Version 1")
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.tts.swaggerRestaurant"))
//                .paths(PathSelectors.any())
                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .apiInfo(buildApiInfoV1());
    }

    /*
    We can also add information about the API that will display at the top
    of the generated Swagger page.
    This can include various pieces of information including the API title,
    description, license, and contact info.
    To do this, we create a new ApiInfo object using the ApiInfoBuilder.
    Builder methods are special constructor methods that allow for optional
    constructor arguments to be passed in in any order. For clarity, the
    ApiInfo object is built in a separate method.
    Add this line in the above api() method: .apiInfo(buildApiInfo());
     */
    private ApiInfo buildApiInfoV1() {
        return new ApiInfoBuilder()
                .title("Menu Items API")
                .description("REST API for interacting with menu items")
                .version("1.0.0")
                .contact(new Contact("Developer: Renee's Inc", "renee.works", "sreneewatkins@renee.works"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

    @Bean
    public Docket apiV2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Version 2")
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.tts.swaggerRestaurant"))
//                .paths(PathSelectors.any())
                .paths(PathSelectors.ant("/v2/**"))
                .build()
                .apiInfo(buildApiInfoV2());
    }

    private ApiInfo buildApiInfoV2() {
        return new ApiInfoBuilder()
                .title("Menu Items API")
                .description("REST API for interacting with menu items")
                .version("2.0.0")
                .contact(new Contact("Developer: Renee's Inc", "renee.works", "sreneewatkins@renee.works"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

    /*
    There is also the ability to customize various display options by
    adding another bean to the configuration class. A common option is
    to have all the endpoints appear automatically expanded, instead of
    having to manually click on each one. This is accomplished with the
    following code. There are, of course, lots of ther options that can
    be specified here. See the documentation for details.
     */
    @Bean
    UiConfiguration buildUiConfig() {
        return UiConfigurationBuilder.builder()
                .docExpansion(DocExpansion.FULL)
                .build();
    }

}//end SwaggerConfig class
