package com.rca.mireilleumutoni.template.v1.controllers;

import com.rca.mireilleumutoni.template.v1.dto.requests.CourseDTO;
import com.rca.mireilleumutoni.template.v1.dto.requests.StudentDTO;
import com.rca.mireilleumutoni.template.v1.models.Course;
import com.rca.mireilleumutoni.template.v1.payload.ApiResponse;
import com.rca.mireilleumutoni.template.v1.serviceImpls.CourseServiceImpl;
import com.rca.mireilleumutoni.template.v1.serviceImpls.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private  final CourseServiceImpl courseService;

    @PostMapping("/create")
    ResponseEntity<ApiResponse> create(@RequestBody CourseDTO courseDTO){
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The student created successfully", this.courseService.createCourse(courseDTO)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    @GetMapping("/all")
    ResponseEntity<ApiResponse>
    getAllCourses() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "All students retrieved successfully", this.courseService.getAllCourses()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("/{id}")
    ResponseEntity<ApiResponse> getCourseById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The student retrieved successfully", this.courseService.getCourseById(id)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
