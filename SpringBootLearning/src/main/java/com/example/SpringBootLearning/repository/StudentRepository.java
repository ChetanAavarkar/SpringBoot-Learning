package com.example.SpringBootLearning.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringBootLearning.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("Select s from Student s where s.city = :city")
	List<Student> findByCity(@Param("city") String city);
	List<Student> findByName(String name);
	List<Student> findByNameContaining(String name);
	List<Student> findByCityIgnoreCase(String city);
	Page<Student> findAll(Pageable pageable);
}
