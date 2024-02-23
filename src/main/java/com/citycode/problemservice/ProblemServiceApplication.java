package com.citycode.problemservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProblemServiceApplication {

	public static void main(String[] args) {
	//	Dotenv dotenv = Dotenv.load();
	//	String dbUsername = dotenv.get("DB_USERNAME");
	//	String dbPassword = dotenv.get("DB_PASSWORD");

	//	System.setProperty("DB_USERNAME", dbUsername);
	//	System.setProperty("DB_PASSWORD", dbPassword);
		SpringApplication.run(ProblemServiceApplication.class, args);
	}

}
