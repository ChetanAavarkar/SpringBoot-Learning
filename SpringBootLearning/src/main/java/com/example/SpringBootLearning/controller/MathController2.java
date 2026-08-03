package com.example.SpringBootLearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController2 {
	
	@GetMapping("/add")
	public String addNumbers(@RequestParam int a, @RequestParam int b) {
		int sum = a + b;
		return "Addition = " + sum;
	}
}
