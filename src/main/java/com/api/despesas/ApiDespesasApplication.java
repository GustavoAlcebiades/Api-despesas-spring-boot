package com.api.despesas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.api.despesas.repository")
public class ApiDespesasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDespesasApplication.class, args);
	}

}
