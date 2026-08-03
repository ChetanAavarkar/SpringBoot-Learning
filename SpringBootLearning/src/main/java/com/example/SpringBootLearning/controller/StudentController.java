package com.example.SpringBootLearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping("/student")
	public String getStudentInfp(@RequestParam int id, @RequestParam String name) {
		return "Student ID: " + id + "\nStudent Name: " + name;
	}
}
