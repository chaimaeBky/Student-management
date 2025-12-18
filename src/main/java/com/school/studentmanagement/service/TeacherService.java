package com.school.studentmanagement.service;

import com.school.studentmanagement.entity.Teacher;
import com.school.studentmanagement.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TeacherService {

    private static final Logger LOG = LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    private TeacherRepository teacherRepository;

    public Optional<Teacher> getTeacher(Long id) {
        LOG.debug("Fetching teacher with id: {}", id);
        return teacherRepository.findById(id);
    }

    public Teacher addTeacher(String name, String department, Double salary) {
        if (salary != null && salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }

        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setDepartment(department);
        teacher.setMonthlySalary(salary);

        LOG.info("Adding new teacher: {}", name);
        return teacherRepository.save(teacher);
    }

    public void validateDataOperation() {
        LOG.info("Performing data validation operation");
        // Logique de validation
    }
}