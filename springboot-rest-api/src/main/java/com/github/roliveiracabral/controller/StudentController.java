package com.github.roliveiracabral.controller;

import com.github.roliveiracabral.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        //return new ResponseEntity<Student>(new Student("Rodrigo", 1, "Cabral"), HttpStatus.OK);
        //return ResponseEntity.ok(new Student("Rodrigo", 1, "Cabral"));
        return ResponseEntity.ok()
                .header("custom-header", "Rodrigo")
                .body(new Student("Rodrigo", 1, "Cabral"));
    }

    @GetMapping
    public ResponseEntity<List<Student>> students() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Rodrigo", 1, "Cabral"));
        students.add(new Student("Gisele", 2, "Freire"));
        students.add(new Student("Valentina", 3, "Cabral"));
        students.add(new Student("Vitória", 4, "Ally"));
        return ResponseEntity.ok(students);
    }

    @GetMapping("{id}/{firstName}/{lastName}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int id, @PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return ResponseEntity.ok(new Student(firstName, id, lastName));
    }

    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam("id") int id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return ResponseEntity.ok(new Student(firstName, id, lastName));
    }

    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
