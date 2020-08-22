package com.abhishek.springbootApp.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication initializes spring (component scan) and Spring Boot(Auto configuration).
public class SpringBootFirstWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstWebApplication.class, args);
		// SpringApplication.run() launches a spring boot application.

	}
}
//devtool monitors all packages,classes and updates on the server accordingly.