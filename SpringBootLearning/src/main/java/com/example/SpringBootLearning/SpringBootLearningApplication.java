package com.example.SpringBootLearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLearningApplication implements CommandLineRunner {
	
	@Autowired
	private AppInfo appInfo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearningApplication.class, args);
	}

	@Override
	public void run(String...args) {
		appInfo.printAppName();
	}
}
