package com.example.schoolmanagement1.Service;


import java.util.List;

import com.example.schoolmanagement1.exceptions.InvalidClassroomIdException;
import com.example.schoolmanagement1.repository.ClassroomRepository;
import com.example.schoolmanagement1.model.Classroom;
import org.springframework.stereotype.Service;


@Service
public class ClassroomService {

    private  ClassroomRepository classroomRepository;
    public List<Classroom> getClassRooms() {
        return classroomRepository.findAll();
    }

    public void addClassRoom(Classroom myclass) throws IllegalAccessException {
        classroomRepository.save(myclass);
    }
    public Classroom checkClassRoom(Integer id) {

        Classroom mysclass=classroomRepository.findById(id)
                .orElseThrow(
                        ()->new InvalidClassroomIdException("Invalid id"));


        return mysclass;

    }
}
