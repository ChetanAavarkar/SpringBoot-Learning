package com.example.SpringBootLearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "Welcome to Spring Boot!";
	}
	
	@GetMapping("/about")
	public String about() {
		return "This is my first Spring Boot project .";
	}
	
	@GetMapping("/name")
	public String name() {
		return "Chetan Aavarkar";
	}
}
