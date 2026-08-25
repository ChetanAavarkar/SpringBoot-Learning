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
	
	@GetMapping
	public Page<Student> getStudents(
			@PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
		return homeService.getStudents(pageable);
	}

	//use it to get all data at once
	@GetMapping
	public List<StudentDTO> getAllStudents() {
		log.info("Fetching all students");
		return homeService.getAllStudents();
	}
	
	@Operation(summary = "Get student by ID", description = "Retrieves a student using their ID")
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		log.info("Student request received for ID: {}", id);
		
		log.debug("Searching student with id={}", id);
		
		try {
			Student student = homeService.getStudentById(id);
			
			log.info("Student found successfully: {}", student.getName());
			return student;
		} catch (Exception e) {
			log.warn("Request student ID may not exist: {}", id);
			
			log.error("Database operation failed while fetching studnet with ID: {}", id, e);
			
			throw e;
		}
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
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		log.info("Deleting student with ID: {}", id);
		homeService.deleteStudent(id);
		return ResponseEntity.ok("Student with ID " + id + " deleted successfully");
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
	public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
		log.info("Updating student with ID: {}", id);
	    return homeService.updateStudent(id, updatedStudent.getName(), updatedStudent.getCity());
	}
	
	@PostMapping("/students")
	public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO requestDTO) {
		log.info("Creating new student: {}", requestDTO.getName());
		StudentResponseDTO response = homeService.createStudent(requestDTO);
		return ResponseEntity.ok(response);
	}
}
