package com.task.mentortask.controller;

import com.task.mentortask.student.Student;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = List.of(
            new Student(1L, "ziya", "ziya@gmail.com"),
            new Student(2L, "rufer", "rufet@gmail.com"),
            new Student(3L, "cavid", "cavid@gmail.com")
    );

    // GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    // GET student by id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // GET students by name
    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String name) {
        return students.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
