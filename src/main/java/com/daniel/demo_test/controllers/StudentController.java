package com.daniel.demo_test.controllers;

import com.daniel.demo_test.beans.Student;
import com.daniel.demo_test.exceptions.SchoolCostumeException;
import com.daniel.demo_test.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by danielR on 08/12/2022
 */
@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("students")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) throws SchoolCostumeException {
        studentService.addStudent(student);
    }

    @PostMapping("students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable long id) throws SchoolCostumeException {
        studentService.deleteStudent(id);
        System.out.println("Student deleted");
    }

    @GetMapping("students/{id}")
    public Student getSingleStudent(@PathVariable long id) throws SchoolCostumeException {
        return studentService.getSingleStudent(id);
    }

    @GetMapping("students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("students/name")
    public List<Student> getAllStudentsByName(@RequestParam String name) {
        return studentService.getAllStudentsByName(name);
    }

    @GetMapping("students/{id}/avg")
    public double avgScoreOfSingleStudent(@PathVariable long id) {
        return studentService.avgScoreOfSingleStudent(id);
    }
}
