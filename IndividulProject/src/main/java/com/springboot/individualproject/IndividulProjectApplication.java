package com.springboot.individualproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IndividulProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndividulProjectApplication.class, args);
	}

}


