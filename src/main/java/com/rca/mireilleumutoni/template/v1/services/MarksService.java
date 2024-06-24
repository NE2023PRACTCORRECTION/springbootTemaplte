package com.rca.mireilleumutoni.template.v1.services;


import com.rca.mireilleumutoni.template.v1.dto.requests.MarksDTO;
import com.rca.mireilleumutoni.template.v1.models.Marks;

import java.util.List;
import java.util.UUID;

public interface MarksService {

    List<Marks> getAllMarks();
    Marks getMarksById(UUID id);
    Marks createMarks(MarksDTO marks);
    List<Marks> getMarksByStudentId(UUID studentId);
    List<Marks> getMarksByCourseId(UUID courseId);
}
