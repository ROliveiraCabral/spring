package com.github.roliveiracabral.controller;

import com.github.roliveiracabral.bean.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        return new Student("Rodrigo", 1, "Cabral");
    }

    @GetMapping("students")
    public List<Student> students() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Rodrigo", 1, "Cabral"));
        students.add(new Student("Gisele", 2, "Freire"));
        students.add(new Student("Valentina", 3, "Cabral"));
        students.add(new Student("Vitória", 4, "Ally"));
        return students;
    }

    @GetMapping("student/{id}")
    public Student studentPathVariable(@PathVariable("id") int id) {
        return new Student("Rodrigo", id, "Cabral");
    }

    @GetMapping("student/query")
    public Student studentRequestVariable(@RequestParam("id") int id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return new Student(firstName, id, lastName);
    }
}
