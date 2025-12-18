package com.school.studentmanagement.repository;

import com.school.studentmanagement.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.monthlySalary > :minSalary")
    List<Teacher> findHighSalaryTeachers(@Param("minSalary") Double minSalary);

    @Query("SELECT t FROM Teacher t WHERE t.department = :department")
    List<Teacher> findByDepartment(@Param("department") String department);
}