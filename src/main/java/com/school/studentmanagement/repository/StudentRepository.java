package com.school.studentmanagement.repository;

import com.school.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.fullName = :name")
    List<Student> findByName(@Param("name") String name);

    @Query("SELECT s FROM Student s WHERE s.emailAddress = :email")
    Optional<Student> findByEmail(@Param("email") String email);

    // Méthode native sécurisée
    @Query(value = "SELECT * FROM students WHERE email_address = :email", nativeQuery = true)
    Optional<Student> findByEmailNative(@Param("email") String email);
}