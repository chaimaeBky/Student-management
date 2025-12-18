package com.school.studentmanagement.service;


import com.school.studentmanagement.entity.Student;
import com.school.studentmanagement.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void getStudent_ReturnsEmpty_WhenNotFound() {
        when(studentRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<Student> result = studentService.getStudent(999L);

        assertFalse(result.isPresent());
        verify(studentRepository).findById(999L);
    }

    @Test
    void checkStatus_ReturnsNotFound_ForInvalidId() {
        when(studentRepository.findById(999L)).thenReturn(Optional.empty());

        String status = studentService.checkStatus(999L);

        assertEquals("NOT_FOUND", status);
    }
}
