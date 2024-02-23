package com.truongnhudat.student.controller;

import com.truongnhudat.student.entity.Student;
import com.truongnhudat.student.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudentsBySchoolId(@PathVariable("school-id") Integer schoolId){
        return ResponseEntity.ok(studentService.findAllBySchoolId(schoolId));
    }
}
