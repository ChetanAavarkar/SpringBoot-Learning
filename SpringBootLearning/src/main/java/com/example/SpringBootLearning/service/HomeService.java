package com.example.SpringBootLearning.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {
	
	public String getHomeMessage() { 
		return "Welcome to Spring Boot!";
	}
	
	public String getAboutMessage() { 
		return "This is my first Spring Boot project.";
	}
	
	public String getNameMessage() { 
		return "Chetan Aavarkar";
	}
	
	public String getHelloMessage(String name) {
		return "Hello, " + name + "!";
	}
}