package com.example.SpringBootLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringBootLearning.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
