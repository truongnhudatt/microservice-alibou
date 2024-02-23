package com.truongnhudat.student.service;


import com.truongnhudat.student.entity.Student;
import com.truongnhudat.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllBySchoolId(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
