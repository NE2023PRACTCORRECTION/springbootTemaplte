package com.rca.mireilleumutoni.template.v1.dto.requests;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component

public class CourseDTO {

    private  String courseName;
    private  String courseCode;
    private  String courseDescription;



}





