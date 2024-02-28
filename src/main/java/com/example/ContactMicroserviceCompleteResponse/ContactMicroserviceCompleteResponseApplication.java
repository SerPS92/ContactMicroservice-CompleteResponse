package com.example.ContactMicroserviceCompleteResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class ContactMicroserviceCompleteResponseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactMicroserviceCompleteResponseApplication.class, args);
		System.out.println(SpringVersion.getVersion());
	}

}
