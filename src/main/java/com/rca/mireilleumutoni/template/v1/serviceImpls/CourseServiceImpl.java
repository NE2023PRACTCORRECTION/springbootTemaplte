package com.rca.mireilleumutoni.template.v1.serviceImpls;


import com.rca.mireilleumutoni.template.v1.dto.requests.CourseDTO;
import com.rca.mireilleumutoni.template.v1.exceptions.NotFoundException;
import com.rca.mireilleumutoni.template.v1.models.Course;
import com.rca.mireilleumutoni.template.v1.repositories.CourseRepository;
import com.rca.mireilleumutoni.template.v1.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private  final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {

        try {
            return courseRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Course getCourseById(UUID id) {
        try {
            return courseRepository.findById(id).orElseThrow(() -> new NotFoundException("The purchase with the given id was not found"));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Course createCourse(CourseDTO courseDTO) {
       try{
              Course course = new Course();
              course.setCourseName(courseDTO.getCourseName());
              course.setCourseCode(courseDTO.getCourseCode());
              course.setCourseDescription(courseDTO.getCourseDescription());
              return courseRepository.save(course);
       }catch (Exception e) {
           e.printStackTrace();
       }
       return null;

    }
}
