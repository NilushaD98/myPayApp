package com.example.myPayApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MyPayAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPayAppApplication.class, args);
	}

}
