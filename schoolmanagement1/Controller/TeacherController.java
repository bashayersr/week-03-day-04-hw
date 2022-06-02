package com.example.schoolmanagement1.Controller;


import java.util.List;

import javax.validation.Valid;

import com.example.schoolmanagement1.DTO.API;
import com.example.schoolmanagement1.Service.TeacherService;
import com.example.schoolmanagement1.model.Teacher;
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
public class TeacherController {

    private TeacherService techService;

    @GetMapping("/teacher")
    public ResponseEntity<List<Teacher>> getTeachers(){
        List<Teacher> tech=techService.getTeachers();
        return ResponseEntity.status(HttpStatus.OK).body(tech);
    }
    @PostMapping("/add")
    public ResponseEntity<API> addTeacher(@RequestBody @Valid Teacher mytech) throws IllegalAccessException{
        techService.addTeacher(mytech);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("New Teacher added !",201));
    }
    @GetMapping("/teacher/{id}")
    public ResponseEntity<String> checkClassroomIsValid(@PathVariable Integer id){

        Integer techStatus=0;
        Teacher mytech=  techService.checkTeacher(id);

        if(mytech==null){
            techStatus= -1;
        }
        else
            techStatus=1;

        switch (techStatus){
            case -1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid id");
            case 1:
                return ResponseEntity.status(HttpStatus.OK).body("Show teacher :"+mytech);
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SERVER ERROR");

        }
    }
}
