package com.school.studentmanagement.controller;

import com.school.studentmanagement.entity.Student;
import com.school.studentmanagement.service.StudentService;
import com.school.studentmanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/remove/{id}")
    public String removeStudent(@PathVariable Long id) {
        return "Student " + id + " removed";
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @GetMapping("/admin")
    public String adminAccess(@RequestParam String code) {
        if ("admin123".equals(code)) {
            return "Admin access granted";
        }
        return "Access denied";
    }

    @GetMapping("/data")
    public String getAllData() {
        return "All student data";
    }

    @GetMapping("/teacher/{id}/salary")
    public Double getTeacherSalary(@PathVariable Long id) {
        var teacher = teacherService.getTeacher(id);
        return teacher != null ? teacher.getMonthlySalary() : 0.0;
    }

    @GetMapping("/process")
    public String processRequest(@RequestParam(required = false) String option) {
        String response = "";

        if (option != null) {
            if (option.equals("A")) {
                response = "Option A selected";
            } else if (option.equals("B")) {
                response = "Option B selected";
            } else if (option.equals("C")) {
                response = "Option C selected";
            } else if (option.equals("D")) {
                response = "Option D selected";
            } else {
                response = "Unknown option";
            }
        }

        System.out.println("Response: " + response);

        return response;
    }
}