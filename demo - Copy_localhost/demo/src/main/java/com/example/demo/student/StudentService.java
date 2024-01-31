package com.example.demo.student;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.spi.STEUtil;
import jakarta.transaction.Transactional;

/**
 * This class represents the service layer for managing student-related operations.
 * It provides methods to retrieve, add, update, and delete student records.
 */

@Service //Used to indicate this is a service class and it is used to implement business logic.
public class StudentService {

    private final studentRepository studentRepository; //Creating a final reference variable of type studentRepository. 
    //Will use this to use methods from studentRepository
    
    //Constructor
    @Autowired // instead of using new keyword to create an object of studentRepository, we use @Autowired annotation
    //spring will automatically create an object of studentRepository.
    //This is called dependency injection.
    public StudentService(com.example.demo.student.studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
		return studentRepository.findAll();
	}

    

    public void addNewStudent(Student student){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
        System.out.println(student);
    }


    public void deleteStudent(long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("student with id " + studentId + " does not exits");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException("Student with id " + studentId+ "does not exists"));

        if(name !=null && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }



        
        
    }

}
