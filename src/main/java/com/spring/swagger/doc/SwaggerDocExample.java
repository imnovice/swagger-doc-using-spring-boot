package com.spring.swagger.doc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class SwaggerDocExample {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerDocExample.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
			@Value("${application-version}") String appVersion, @Value("${document-title}") String docTitle) {
		return new OpenAPI().info(new Info().title(docTitle).version(appVersion).description(appDesciption));
	}
}
