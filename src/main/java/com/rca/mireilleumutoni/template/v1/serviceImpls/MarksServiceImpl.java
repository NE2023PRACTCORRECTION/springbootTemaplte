package com.rca.mireilleumutoni.template.v1.serviceImpls;

import com.rca.mireilleumutoni.template.v1.dto.requests.MarksDTO;
import com.rca.mireilleumutoni.template.v1.exceptions.NotFoundException;
import com.rca.mireilleumutoni.template.v1.models.Course;
import com.rca.mireilleumutoni.template.v1.models.Marks;
import com.rca.mireilleumutoni.template.v1.models.Student;
import com.rca.mireilleumutoni.template.v1.repositories.CourseRepository;
import com.rca.mireilleumutoni.template.v1.repositories.MarksRepository;
import com.rca.mireilleumutoni.template.v1.repositories.StudentRepository;
import com.rca.mireilleumutoni.template.v1.services.MarksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MarksServiceImpl implements MarksService {
    private final MarksRepository marksRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<Marks> getAllMarks() {
        try {
            return marksRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

        @Override
        public Marks getMarksById (UUID id){
            try {
                return marksRepository.findById(id).orElse(null);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public Marks createMarks (MarksDTO marks){
            try {
                Student student = studentRepository.findById(marks.getStudentId()).orElseThrow(
                        () -> new NotFoundException("The student with the given id was not found")
                );
                Course course = courseRepository.findById(marks.getCourseId()).orElseThrow(
                        () -> new NotFoundException("The course with the given id was not found")
                );
                Marks marksEntity = new Marks();
                marksEntity.setStudent(student);
                marksEntity.setCourse(course);
                marksEntity.setGrade(marks.getGrade());
                marksEntity.setTotalMarks(marks.getTotalMarks());
                marksEntity.setMarks(marks.getMarks());
                return marksRepository.save(marksEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public List<Marks> getMarksByStudentId(UUID studentId) {
        try {
            Student student = studentRepository.findById(studentId).orElseThrow(
                    () -> new NotFoundException("The student with the given id was not found")
            );
            return marksRepository.findAllByStudent(student);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Marks> getMarksByCourseId(UUID courseId) {
        try {
            Course course = courseRepository.findById(courseId).orElseThrow(
                    () -> new NotFoundException("The course with the given id was not found")
            );
            return marksRepository.findAllByCourse(course);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}