package com.rca.mireilleumutoni.template.v1.controllers;


import com.rca.mireilleumutoni.template.v1.dto.requests.MarksDTO;
import com.rca.mireilleumutoni.template.v1.payload.ApiResponse;
import com.rca.mireilleumutoni.template.v1.serviceImpls.MarksServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/marks")
@RequiredArgsConstructor
public class MarksController {
    private  final MarksServiceImpl marksService;

    @PostMapping("/create")
    ResponseEntity<ApiResponse> create (@RequestBody MarksDTO marksDTO) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The marks created successfully", this.marksService.createMarks(marksDTO)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/all")
    ResponseEntity<ApiResponse> getAllMarks() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "All marks retrieved successfully", this.marksService.getAllMarks()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("/{id}")
    ResponseEntity<ApiResponse> getMarksById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The marks retrieved successfully", this.marksService.getMarksById(id)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
