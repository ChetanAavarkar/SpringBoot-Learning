package com.example.SpringBootLearning.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.SpringBootLearning.model.Student;

@Service
public class HomeService {
	
	public final List<Student> students = Arrays.asList(
				new Student(1, "Alice", "Ahmedabad"),
				new Student(2, "Bob", "Baroda"),
				new Student(3, "Charlie", "Chennai")
		);
		
	public Student getStudentById(int id) {
		return students.stream()
				.filter(s -> s.getId() ==id)
				.findFirst()
				.orElse(null);
	}
	
	public List<Student> getStudentsByCity(String city) {
		return students.stream()
				.filter(s -> s.getCity().equalsIgnoreCase(city))
				.collect(Collectors.toList());
	}
}
