package com.example.SpringBootLearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	@GetMapping("/square/{number}")
	public String getSquare(@PathVariable int number) {
		int result = number * number;
		return "Square of " + number + " is " + result;
	}
}
