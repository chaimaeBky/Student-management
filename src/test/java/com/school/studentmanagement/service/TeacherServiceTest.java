package com.school.studentmanagement.service;

import com.school.studentmanagement.entity.Teacher;
import com.school.studentmanagement.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TeacherServiceTest {

    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private TeacherService teacherService;

    @Test
    void getTeacher_ReturnsEmpty_WhenNotFound() {
        when(teacherRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<Teacher> result = teacherService.getTeacher(999L);

        assertFalse(result.isPresent());
    }

    @Test
    void calculateBonus_ReturnsZero_ForZeroYears() {
        Teacher teacher = new Teacher();
        teacher.setMonthlySalary(5000.0);

        double bonus = teacher.calculateBonus(0);

        assertEquals(0.0, bonus, 0.001);
    }
}