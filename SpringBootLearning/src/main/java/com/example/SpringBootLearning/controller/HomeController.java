package com.example.SpringBootLearning.controller;

import org.springframework.ui.Model;
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
	public String home(Model model) {
		model.addAttribute("students", homeService.students);
		return "home";
	}
}
