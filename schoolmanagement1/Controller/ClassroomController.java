package com.example.schoolmanagement1.Controller;


import java.util.List;

import javax.validation.Valid;

import com.example.schoolmanagement1.DTO.API;
import com.example.schoolmanagement1.Service.ClassroomService;
import com.example.schoolmanagement1.model.Classroom;
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
public class ClassroomController {

    private final ClassroomService classroomService;

    @GetMapping("/classroom")
    public ResponseEntity<List<Classroom>> getClassRooms(){
        List<Classroom> clss=classroomService.getClassRooms();
        return ResponseEntity.status(HttpStatus.OK).body(clss);
    }
    @PostMapping("/add")
    public ResponseEntity<API> addClassRoom(@RequestBody @Valid Classroom myclass) throws IllegalAccessException{
        classroomService.addClassRoom(myclass);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("New Classroom added !",201));
    }

    @GetMapping("/classroom/{id}")
    public ResponseEntity<String> checkClassroomIsValid(@PathVariable Integer id){
        Integer classStatus=0;
        Classroom myclass=  classroomService.checkClassRoom(id);

        if(myclass==null){
            classStatus= -1;
        }
        else
            classStatus=1;


        switch (classStatus){
            case -1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid id");
            case 1:
                return ResponseEntity.status(HttpStatus.OK).body("Show  ClassRoom :"+myclass);
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SERVER ERROR");

        }
    }
}
