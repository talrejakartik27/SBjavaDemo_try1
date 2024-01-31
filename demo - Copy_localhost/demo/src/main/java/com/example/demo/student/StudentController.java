package com.example.demo.student;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class represents the controller for managing student-related operations.
 */
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Retrieves a list of all students.
     *
     * @return the list of students
     */
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }



    /**
     * Registers a new student.
     *
     * @param student the student to be registered
     */
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) { //RequestBody annotation is used to bind the request body(from http body) with a method parameter STUDENT.
        studentService.addNewStudent(student);
    }



    /**
     * Deletes a student with the specified ID.
     *
     * @param studentId the ID of the student to be deleted
     */
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }



    
    /**
     * Updates a student with the specified ID.
     *
     * @param studentId the ID of the student to be updated
     * @param name      the new name of the student (optional)
     * @param email     the new email of the student (optional)
     */
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
