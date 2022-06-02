package com.example.schoolmanagement1.model;

import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    @ManyToMany(mappedBy = "classrooms",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Student> studentClasses;


    @ManyToOne
    @JsonIgnore
    private Teacher teacher;


}

