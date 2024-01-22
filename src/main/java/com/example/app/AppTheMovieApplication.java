package com.example.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.app.repository")
public class AppTheMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppTheMovieApplication.class, args);
	}

}
