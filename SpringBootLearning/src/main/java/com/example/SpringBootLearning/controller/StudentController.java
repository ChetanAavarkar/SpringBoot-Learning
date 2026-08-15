package com.example.SpringBootLearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootLearning.dto.StudentDTO;
import com.example.SpringBootLearning.model.Student;
import com.example.SpringBootLearning.service.HomeService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private final HomeService homeService;
	
	public StudentController(HomeService homeService) {
		this.homeService = homeService;
	}
	
	@GetMapping
	public List<StudentDTO> getAllStudents() {
		return homeService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		return homeService.getStudentById(id);
	}
	
	@GetMapping("/city/{city}")
	public List<Student> getStudentsByCity(@PathVariable String city) {
		return homeService.getStudentsByCity(city);
	}
	
	@GetMapping("/test-student")
	public String testStudent() {
		return homeService.createTestStudent();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		homeService.deleteStudent(id);
		return ResponseEntity.ok("Student with ID " + id + " deleted successfully");
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
	    return homeService.updateStudent(id, updatedStudent.getName(), updatedStudent.getCity());
	}
}
