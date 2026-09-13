package com.example.SpringBootLearning.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hibernate.query.SortDirection;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootLearning.dto.StudentDTO;
import com.example.SpringBootLearning.dto.StudentRequestDTO;
import com.example.SpringBootLearning.dto.StudentResponseDTO;
import com.example.SpringBootLearning.model.Student;
import com.example.SpringBootLearning.service.HomeService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(StudentController.class);
	private final HomeService homeService;
	
	public StudentController(HomeService homeService) {
		this.homeService = homeService;
	}
	
	@GetMapping("/page")
	public Page<Student> getStudents(
			@PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
		return homeService.getStudents(pageable);
	}
	
	@GetMapping
	public ResponseEntity<List<StudentDTO>> getAllStudents() {
		log.info("Fetching all students");
		List<StudentDTO> students = homeService.getAllStudents();
		return ResponseEntity.ok(students);
	}
	
	@Operation(summary = "Get student by ID", description = "Retrieves a student using their ID")
	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id) {
		log.info("Fetching student with ID: {}", id);
		
		StudentDTO student = homeService.getStudentById(id);
		return ResponseEntity.ok(student);
	}
	
	@GetMapping("/city/{city}")
	public List<Student> getSByCity(@PathVariable String city) {
		log.info("Fetching students from city: {}", city);
		return homeService.getStudentsByCity(city);
	}
	
	@GetMapping("/test-student")
	public String testStudent() {
		return homeService.createTestStudent();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
		log.info("Deleting student with ID: {}", id);
		homeService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/name/{name}")
	public List<Student> getStudentsByName(@PathVariable String name) {
		return homeService.getStudentsByName(name);
	}
	
	@GetMapping("/search/{keyword}")
	public List<Student> searchStudents(@PathVariable String keyword) {
		return homeService.searchStudentsByName(keyword);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentDTO> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
		log.info("Updating student with ID: {}", id);
		
		StudentDTO updated = homeService.updateStudent(id, updatedStudent.getName(), updatedStudent.getCity());
	    return ResponseEntity.ok(updated);
	}
	
	@PostMapping
	public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO requestDTO) {
		log.info("Creating new student: {}", requestDTO.getName());
		StudentResponseDTO response = homeService.createStudent(requestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
