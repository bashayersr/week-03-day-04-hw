package com.example.schoolmanagement1.repository;

import org.springframework.stereotype.Repository;

import com.example.schoolmanagement1.model.Classroom;

import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,Integer> {


}
