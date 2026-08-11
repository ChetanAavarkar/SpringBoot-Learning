package com.example.SpringBootLearning.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.SpringBootLearning.model.Student;
import com.example.SpringBootLearning.repository.StudentRepository;

@Service
public class HomeService {
	
	private final StudentRepository studentRepository;
	
	public HomeService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public String createTestStudent() {
		Student student = new Student();
		student.setName("Test Student");
		student.setCity("Delhi");
		
		Student savedStudent = studentRepository.save(student);
		
		return "Student saved successfully with ID: " + savedStudent.getId();
	}
	
	public Student getStudentById(int id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public List<Student> getStudentsByCity(String city) {
		return studentRepository.findAll()
				.stream()
				.filter(s -> s.getCity().equalsIgnoreCase(city))
				.collect(Collectors.toList());
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public String deleteStudentById(int id) {
		if (!studentRepository.existsById(id)) {
			return "Student with ID " + id + " not found";
		}
		
		studentRepository.deleteById(id);
		return "Student with ID " + id + " deleted successfully";
	}
	
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}
}
