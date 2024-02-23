package com.truongnhudat.school.service;

import com.truongnhudat.school.dto.FullSchoolResponse;
import com.truongnhudat.school.entity.School;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISchoolService {
    void save(School school);
    List<School> findAll();
    FullSchoolResponse findSchoolsWithStudents(Integer schoolId);
}
