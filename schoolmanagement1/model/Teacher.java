package com.example.schoolmanagement1.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Teacher {

    @Id
    @NotEmpty(message = "Techid is required")
    private Integer id;

    @NotEmpty(message = "Techname is required")
    private String name;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Classroom> classrooms;

}
