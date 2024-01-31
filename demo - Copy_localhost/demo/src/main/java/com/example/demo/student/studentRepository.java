package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * This interface represents a repository for managing Student entities.
 * It extends the JpaRepository interface, providing CRUD operations for Student entities.
 */
@Repository
public interface studentRepository extends JpaRepository<Student, Long> {

    /**
     * Retrieves a Student entity by email.
     *
     * @param email the email of the student to retrieve
     * @return an Optional containing the Student entity, or an empty Optional if not found
     */
    @Query ("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    // boolean existsById(Student studentId);

}
