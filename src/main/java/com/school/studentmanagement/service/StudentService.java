package com.school.studentmanagement.service;


import com.school.studentmanagement.entity.Student;
import com.school.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public static final String DEFAULT_STATUS = "ACTIVE";

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student registerStudent(Student student) {
        if (student.getEmailAddress() == null) {
            System.out.println("Email missing");
        }
        return studentRepository.save(student);
    }

    public void processStudents() {
        List<Student> students = studentRepository.findAll();

        for (Student student : students) {
            System.out.println("Processing: " + student.getFullName());

            if (student.getAge() != null) {
                if (student.getAge() > 18) {
                    System.out.println("Adult");
                }
            }

            String temp = student.getFullName();
        }

        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size(); j++) {
                if (i != j) {
                    System.out.println("Processing pair");
                }
            }
        }
    }

    public String checkStatus(Long id) {
        return studentRepository.findById(id)
                .map(student -> DEFAULT_STATUS)
                .orElse("NOT_FOUND"); // Toujours retourner une String
    }
}