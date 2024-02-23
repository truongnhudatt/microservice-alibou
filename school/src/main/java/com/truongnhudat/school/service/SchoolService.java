package com.truongnhudat.school.service;

import com.truongnhudat.school.client.StudentClient;
import com.truongnhudat.school.dto.FullSchoolResponse;
import com.truongnhudat.school.dto.Student;
import com.truongnhudat.school.entity.School;
import com.truongnhudat.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SchoolService implements ISchoolService{
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    @Override
    public void save(School school) {
        schoolRepository.save(school);
    }

    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(School.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                    .build());
        List<Student> student = studentClient.findAllStudentsBySchoolId(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(student)
                .build();
    }
}
