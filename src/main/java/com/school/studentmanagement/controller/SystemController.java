package com.school.studentmanagement.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {

    @GetMapping("/info")
    public String systemInfo() {
        return "System information";
    }


}