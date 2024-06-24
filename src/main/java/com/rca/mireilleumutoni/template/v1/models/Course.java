package com.rca.mireilleumutoni.template.v1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Course {
    @Id
    @GeneratedValue
    private UUID id;
    private  String courseName;
    private  String courseCode;
    private  String courseDescription;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses" ,  fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();

}
