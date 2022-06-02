package com.example.schoolmanagement1.repository;

import com.example.schoolmanagement1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Integer> {

}
