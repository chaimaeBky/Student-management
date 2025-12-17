package com.school.studentmanagement.repository;


import com.school.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM students WHERE full_name = :name", nativeQuery = true)
    List<Student> findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM students WHERE email_address = '" + ":email" + "'", nativeQuery = true)
    List<Student> findByEmail(@Param("email") String email);

    default void logQuery() {
        System.out.println("Query executed");
    }
}