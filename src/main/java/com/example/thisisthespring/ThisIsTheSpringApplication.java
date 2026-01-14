package com.example.thisisthespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA 리스너를 사용하기위해 추가
public class ThisIsTheSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThisIsTheSpringApplication.class, args);
	}

}
