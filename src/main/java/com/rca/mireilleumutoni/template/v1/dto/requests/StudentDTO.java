package com.rca.mireilleumutoni.template.v1.dto.requests;


import com.rca.mireilleumutoni.template.v1.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class StudentDTO {
    private  String firstName;
    private  String lastName;
    private  String email;
    private EGender gender;

}
