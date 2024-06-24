package com.rca.mireilleumutoni.template.v1.services;



import com.rca.mireilleumutoni.template.v1.dto.requests.StudentDTO;
import com.rca.mireilleumutoni.template.v1.models.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(UUID id);
    Student createStudent(StudentDTO student);
     Student assingCourseToStudent(UUID studentId, UUID courseId);
}
