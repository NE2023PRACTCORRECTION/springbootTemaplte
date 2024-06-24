package com.rca.mireilleumutoni.template.v1.serviceImpls;


import com.rca.mireilleumutoni.template.v1.dto.requests.StudentDTO;
import com.rca.mireilleumutoni.template.v1.exceptions.NotFoundException;
import com.rca.mireilleumutoni.template.v1.models.Course;
import com.rca.mireilleumutoni.template.v1.models.Student;
import com.rca.mireilleumutoni.template.v1.models.User;
import com.rca.mireilleumutoni.template.v1.repositories.CourseRepository;
import com.rca.mireilleumutoni.template.v1.repositories.StudentRepository;
import com.rca.mireilleumutoni.template.v1.repositories.UserRepository;
import com.rca.mireilleumutoni.template.v1.services.StudentService;
import com.rca.mireilleumutoni.template.v1.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<Student> getAllStudents() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student getStudentById(UUID id) {
        try {
            return studentRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public Student createStudent(StudentDTO student) {
        try {
            User user = userService.getLoggedInUser();
            System.out.println("The persisting database is " + user.getId());
            User userFromDb = userRepository.findById(user.getId()).orElseThrow(() -> new NotFoundException("The user with the given id was not found"));
            Student studentEntity = new Student();
            studentEntity.setFirstName(student.getFirstName());
            studentEntity.setLastName(student.getLastName());
            studentEntity.setEmail(student.getEmail());
            studentEntity.setGender(student.getGender());
            studentEntity.setCreatedBy(userFromDb);
            studentRepository.save(studentEntity);
            return studentEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student assingCourseToStudent(UUID studentId, UUID courseId) {
        try {
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new NotFoundException("The student with the given id was not found"));
            Course course = courseRepository.findById(courseId).orElseThrow(() -> new NotFoundException("The course with the given id was not found"));
            Set<Course> courses = student.getCourses();
            courses.add(course);
            student.setCourses(courses);
            return studentRepository.save(student);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

