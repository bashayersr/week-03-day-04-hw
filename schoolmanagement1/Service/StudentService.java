package com.example.schoolmanagement1.Service;

import java.util.List;

import com.example.schoolmanagement1.exceptions.InvalidStudentIdException;
import com.example.schoolmanagement1.repository.StudentRepository;
import com.example.schoolmanagement1.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student mystud) throws IllegalAccessException {
        studentRepository.save(mystud);
    }
    public Student checkStudent(Integer id) {

        Student mystud=studentRepository.findById(id)
                .orElseThrow(
                        ()->new InvalidStudentIdException("Invalid id"));

        return mystud;

    }
}