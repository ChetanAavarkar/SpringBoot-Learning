package com.example.SpringBootLearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootLearning.model.Student;

@RestController
public class StudentController {
	
	@GetMapping("/student")
	public Student getStudent() {
		return new Student(101, "Chetan", "Surat");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student(101, "Chetan", "Surat"));
		students.add(new Student(102, "Rahul", "Ahmedabad"));
		students.add(new Student(103, "Amit", "Vadodara"));
		return students;
	}
}
