package com.rca.mireilleumutoni.template.v1.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class LaptopDTO {
    private UUID studentId;
    private  String serialNumber;
    private  String brand;

}
