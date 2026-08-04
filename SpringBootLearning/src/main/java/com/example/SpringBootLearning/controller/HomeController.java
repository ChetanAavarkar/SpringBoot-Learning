package com.example.SpringBootLearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootLearning.service.HomeService;

@RestController
public class HomeController {
	
	private final HomeService homeService;
	
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}
	
	@GetMapping("/")
	public String home() {
		return homeService.getHomeMessage();
	}
	
	@GetMapping("/about")
	public String about() {
		return homeService.getAboutMessage();
	}
	
	@GetMapping("/name")
	public String name() {
		return homeService.getNameMessage();
	}
	
	@GetMapping("/hello-user/{name}")
	public String hello(@PathVariable String name) {
		return homeService.getHelloMessage(name);
	}
}
