package com.example.SpringBootLearning;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppInfo {

	@Value("${spring.application.name}")
	private String appName;
	
	public void printAppName() {
		System.out.println("Application name: " + appName);
	}
}
