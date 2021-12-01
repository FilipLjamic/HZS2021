package prvi.projekat.pokusaj1.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("prvi.projekat.pokusaj1.app.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndpointsInfo());
    }

    private ApiInfo apiEndpointsInfo() {
        return new ApiInfoBuilder()
                .title("Restoran")
                .contact(new Contact("Tim Brkopalja", "https://github.com/FilipLjamic/HZS2021/tree/master", "milospanjevac@yahoo.com"))
                .version("3.7.1")
                .build();
    }

}
