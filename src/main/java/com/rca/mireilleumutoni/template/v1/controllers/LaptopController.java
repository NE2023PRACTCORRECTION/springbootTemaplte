package com.rca.mireilleumutoni.template.v1.controllers;

import com.rca.mireilleumutoni.template.v1.dto.requests.LaptopDTO;
import com.rca.mireilleumutoni.template.v1.dto.requests.StudentDTO;
import com.rca.mireilleumutoni.template.v1.payload.ApiResponse;
import com.rca.mireilleumutoni.template.v1.serviceImpls.LaptopServiceImpl;
import com.rca.mireilleumutoni.template.v1.serviceImpls.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/laptops")
@RequiredArgsConstructor
public class LaptopController {
    private final LaptopServiceImpl laptopService;
    private final StudentServiceImpl studentService;

    @PostMapping("/create")
    ResponseEntity<ApiResponse> create(@RequestBody LaptopDTO laptopDTO) {

        try {
            return ResponseEntity.ok(new ApiResponse(true, "The student created successfully", this.laptopService.createLaptop(laptopDTO)));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/all")
    ResponseEntity<ApiResponse> getAllLaptops() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "All laptops retrieved successfully", this.laptopService.getAllLaptops()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse> getLaptopById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The laptop retrieved successfully", this.laptopService.getLaptopById(id)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
