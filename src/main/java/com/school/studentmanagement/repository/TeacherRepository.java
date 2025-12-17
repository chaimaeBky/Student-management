package com.school.studentmanagement.repository;

import com.school.studentmanagement.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.monthlySalary > 50000")
    List<Teacher> findHighSalaryTeachers();

    @Query("SELECT t FROM Teacher t WHERE t.department = ?1")
    List<Teacher> findByDepartment(String department);

    @Query("SELECT t FROM Teacher t WHERE t.department = ?1")
    List<Teacher> findTeachersByDepartment(String department);
}