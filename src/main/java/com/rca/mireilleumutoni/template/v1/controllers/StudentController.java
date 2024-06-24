package com.rca.mireilleumutoni.template.v1.controllers;

import com.rca.mireilleumutoni.template.v1.dto.requests.StudentDTO;
import com.rca.mireilleumutoni.template.v1.payload.ApiResponse;
import com.rca.mireilleumutoni.template.v1.serviceImpls.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentService;

    @PostMapping("/create")
    ResponseEntity<ApiResponse> create(@RequestBody StudentDTO studentDTO) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The student created successfully", this.studentService.createStudent(studentDTO)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/all")
    ResponseEntity<ApiResponse>
    getAllStudents() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "All students retrieved successfully", this.studentService.getAllStudents()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse> getStudentById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The student retrieved successfully", this.studentService.getStudentById(id)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}