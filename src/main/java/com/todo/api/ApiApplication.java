package com.todo.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "TODO API",
				description = "Todo api for CC20 Frontend Exam",
				version = "1.0.0",
				contact = @Contact(
						name = "CC20 TA team"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0"
				)
		)
)
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@PostConstruct
	public void checkEnv() {
		System.out.println("🔍 ENV CHECK:");
		System.out.println("MYSQL_HOST = " + System.getenv("MYSQL_HOST"));
		System.out.println("MYSQL_PORT = " + System.getenv("MYSQL_PORT"));
		System.out.println("MYSQL_DATABASE = " + System.getenv("MYSQL_DATABASE"));
		System.out.println("MYSQL_USERNAME = " + System.getenv("MYSQL_USERNAME"));
		System.out.println("MYSQL_PASSWORD = " + System.getenv("MYSQL_PASSWORD"));
	}

}
