package com.example.SpringBootLearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootLearning.model.Student;
import com.example.SpringBootLearning.service.HomeService;

@RestController
public class StudentController {
	
	private final HomeService homeService;
	
	public StudentController(HomeService homeService) {
		this.homeService = homeService;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return homeService.getStudentById(id);
	}
	
	@GetMapping("/students/city/{city}")
	public List<Student> getStudentsByCity(@PathVariable String city) {
		return homeService.getStudentsByCity(city);
	}
}
