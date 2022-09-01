package com.example.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ExamApplication{

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);

	}

}
