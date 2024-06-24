package com.rca.mireilleumutoni.template.v1.repositories;

;
import com.rca.mireilleumutoni.template.v1.models.Course;
import com.rca.mireilleumutoni.template.v1.models.Marks;
import com.rca.mireilleumutoni.template.v1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MarksRepository extends JpaRepository<Marks, UUID> {
    List<Marks> findAllByStudent(Student student);
    List<Marks> findAllByCourse(Course course);
}
