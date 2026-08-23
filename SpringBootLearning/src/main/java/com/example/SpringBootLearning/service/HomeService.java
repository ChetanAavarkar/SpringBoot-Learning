package com.example.SpringBootLearning.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.SpringBootLearning.dto.StudentDTO;
import com.example.SpringBootLearning.dto.StudentRequestDTO;
import com.example.SpringBootLearning.dto.StudentResponseDTO;
import com.example.SpringBootLearning.exception.StudentNotFoundException;
import com.example.SpringBootLearning.model.Student;
import com.example.SpringBootLearning.repository.StudentRepository;

@Service
public class HomeService {
	
	private final StudentRepository studentRepository;
	
	public HomeService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public StudentResponseDTO createStudent(StudentRequestDTO requestDTO) {
		Student student = new Student();
		student.setName(requestDTO.getName());
		student.setCity(requestDTO.getCity());
		
		Student savedStudent = studentRepository.save(student);
		
		return new StudentResponseDTO(
				savedStudent.getId(),
				savedStudent.getName(),
				savedStudent.getCity()
		);
	}
	
	public String createTestStudent() {
        Student student = new Student();
        student.setName("Test Student");
        student.setCity("Delhi");
        Student savedStudent = studentRepository.save(student);
        return "Student saved successfully with ID: " + savedStudent.getId();
    }
	
	public Student getStudentById(int id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
	}
	
	public List<Student> getStudentsByCity(String city) {
		return studentRepository.findByCityIgnoreCase(city);
	}
	
	public List<Student> getStudentsByName(String name) {
		return studentRepository.findByName(name);
	}
	
	public List<Student> searchStudentsByName(String keyword) {
		return studentRepository.findByNameContaining(keyword);
	}
	
	public List<StudentDTO> getAllStudents() {
		return studentRepository.findAll()
				.stream()
				.map(student -> new StudentDTO(student.getName(), student.getCity()))
				.toList();
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
	
	public Student updateStudent(int id, String name, String city) {
		Student student = studentRepository.findById(id)
				.orElse(null);
		
		if (student == null) {
			return null;
		}
		
		student.setName(name);
		student.setCity(city);
		
		return studentRepository.save(student);
	}
}
