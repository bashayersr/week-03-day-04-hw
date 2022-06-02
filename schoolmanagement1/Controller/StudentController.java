package com.example.schoolmanagement1.Controller;


import java.util.List;

import javax.validation.Valid;

import com.example.schoolmanagement1.DTO.API;
import com.example.schoolmanagement1.Service.StudentService;
import com.example.schoolmanagement1.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("api/v1/school")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> stud=studentService.getStudents();
        return ResponseEntity.status(HttpStatus.OK).body(stud);
    }

    @PostMapping("/add")
    public ResponseEntity<API> addStudent(@RequestBody @Valid Student mystud) throws IllegalAccessException{
        studentService.addStudent(mystud);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("New Student added !",201));
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<String> checkClassroomIsValid(@PathVariable Integer id){
        Integer studStatus=0;
        Student mystudent=  studentService.checkStudent(id);

        if(mystudent==null){
            studStatus= -1;
        }
        else
            studStatus=1;
        switch (studStatus){
            case -1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid id");
            case 1:
                return ResponseEntity.status(HttpStatus.OK).body("Show Student :"+mystudent);
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SERVER ERROR");

        }
    }
}