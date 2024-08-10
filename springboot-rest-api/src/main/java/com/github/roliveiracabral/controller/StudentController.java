package com.github.roliveiracabral.controller;

import com.github.roliveiracabral.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        return new Student("Rodrigo", 1, "Cabral");
    }
}
