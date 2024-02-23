package com.truongnhudat.school.controller;

import com.truongnhudat.school.entity.School;
import com.truongnhudat.school.service.ISchoolService;
import com.truongnhudat.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody School school){
        schoolService.save(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools(){
        return ResponseEntity.ok(schoolService.findAll());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<?> findSchoolsWithStudents(@PathVariable("school-id") Integer schoolId){
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }

}
