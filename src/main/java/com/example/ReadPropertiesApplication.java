package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.common.ReadProperties;

@SpringBootApplication
public class ReadPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadPropertiesApplication.class, args);
		ReadProperties readProperties = new ReadProperties();
		readProperties.read();
	}
}
