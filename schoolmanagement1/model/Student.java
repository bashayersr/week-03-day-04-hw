package com.example.schoolmanagement1.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {

    @Id
    @NotEmpty(message = "Id is required")
    private Integer Id;
    @NotEmpty(message = "name is required")
    private String name;
    @NotEmpty(message = "age is required")
    private int age;
    @NotEmpty(message = "majar is required")
    private String major;

    @ManyToMany
    private Set<Classroom> classrooms;

}
