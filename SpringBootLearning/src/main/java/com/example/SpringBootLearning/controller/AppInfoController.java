package com.example.SpringBootLearning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppInfoController {
	
	@Value("${spring.application.environment}")
	private String environment;
	
	@GetMapping("/app-info")
	public String getAppInfo() {
		return environment;
	}

}
