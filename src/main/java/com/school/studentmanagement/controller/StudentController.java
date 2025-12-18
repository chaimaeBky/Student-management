package com.school.studentmanagement.controller;

import com.school.studentmanagement.entity.Student;
import com.school.studentmanagement.service.StudentService;
import com.school.studentmanagement.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeStudent(@PathVariable Long id) {
        LOG.info("Removing student with id: {}", id);
        // Implémentation réelle ici
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student) {
        LOG.info("Adding new student: {}", student.getFullName());
        return studentService.registerStudent(student);
    }

    @GetMapping("/admin")
    public String adminAccess(@RequestParam String code) {
        LOG.debug("Admin access attempt with code");
        // En production: utiliser Spring Security
        return "Access verified";
    }

    @GetMapping("/teacher/{id}/salary")
    public Double getTeacherSalary(@PathVariable Long id) {
        return teacherService.getTeacher(id)
                .map(teacher -> {
                    LOG.info("Retrieved salary for teacher id: {}", id);
                    return teacher.getMonthlySalary();
                })
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Teacher not found"));
    }

    @GetMapping("/process")
    public String processRequest(@RequestParam(required = false) String option) {
        return switch (option != null ? option : "default") {
            case "A" -> "Option A selected";
            case "B" -> "Option B selected";
            case "C" -> "Option C selected";
            case "D" -> "Option D selected";
            default -> "Unknown option";
        };
    }
}