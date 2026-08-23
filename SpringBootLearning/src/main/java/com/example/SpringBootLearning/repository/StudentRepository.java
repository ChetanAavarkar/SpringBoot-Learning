package com.example.SpringBootLearning.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringBootLearning.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByCity(String city);
	List<Student> findByName(String name);
	List<Student> findByNameContaining(String name);
	List<Student> findByCityIgnoreCase(String city);
}
