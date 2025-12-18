package com.school.studentmanagement.service;

import com.school.studentmanagement.entity.Student;
import com.school.studentmanagement.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);
    private static final String DEFAULT_STATUS = "ACTIVE";

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getStudent(Long id) {
        LOG.debug("Fetching student with id: {}", id);
        return studentRepository.findById(id);
    }

    public Student registerStudent(Student student) {
        if (student.getEmailAddress() == null || student.getEmailAddress().trim().isEmpty()) {
            LOG.warn("Attempt to register student without email");
            throw new IllegalArgumentException("Email is required");
        }

        LOG.info("Registering new student: {}", student.getFullName());
        return studentRepository.save(student);
    }

    public void processStudents() {
        List<Student> students = studentRepository.findAll();
        LOG.info("Processing {} students", students.size());

        students.forEach(student -> {
            LOG.debug("Processing student: {}", student.getFullName());

            if (student.getAge() != null && student.getAge() > 18) {
                LOG.trace("Adult student detected");
            }
        });
    }

    public String checkStatus(Long id) {
        return studentRepository.findById(id)
                .map(student -> DEFAULT_STATUS)
                .orElse("NOT_FOUND");
    }
}