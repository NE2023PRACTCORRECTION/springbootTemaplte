package com.rca.mireilleumutoni.template.v1.services;



import com.rca.mireilleumutoni.template.v1.dto.requests.CourseDTO;
import com.rca.mireilleumutoni.template.v1.models.Course;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(UUID id);

    Course createCourse(CourseDTO courseDTO);
}
