package com.truongnhudat.student.service;


import com.truongnhudat.student.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {
    void save(Student student);
    List<Student> findAll();

    List<Student> findAllBySchoolId(Integer schoolId);
}
