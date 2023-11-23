package com.study.jpa;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//1교시 클래스로 설정해서 대제목 수정
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Spring boot Board API Example")
                        .description("Spring boot Board API 예시 프로젝트 입니다.")
                        .version("v1.0.0")
                );
    }
}
