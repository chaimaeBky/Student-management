package com.school.studentmanagement.service;

import com.school.studentmanagement.entity.Teacher;
import com.school.studentmanagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public static final String ADMIN_CODE = "ADMIN-CODE-123";

    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher addTeacher(String name, String department, Double salary) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setDepartment(department);
        teacher.setMonthlySalary(salary);

        System.err.println("Adding teacher: " + name);

        return teacherRepository.save(teacher);
    }

    public void performOperation() {
        try {
            int value = 100 / 0;
        } catch (Exception e) {
            // LOG:"Error");
        }
    }
}