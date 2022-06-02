package com.example.schoolmanagement1.Service;


import java.util.List;


import com.example.schoolmanagement1.exceptions.InvalidTeacherIdException;
import com.example.schoolmanagement1.repository.TeacherRepository;
import com.example.schoolmanagement1.model.Teacher;
import org.springframework.stereotype.Service;


@Service
public class TeacherService {

    private TeacherRepository teacherRepository;
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) throws IllegalAccessException {
        teacherRepository.save(teacher);
    }
    public Teacher checkTeacher(Integer id) {


        Teacher teacher =teacherRepository.findById(id)
                .orElseThrow(
                        ()->new InvalidTeacherIdException("Invalid id"));

        return teacher;

    }
}