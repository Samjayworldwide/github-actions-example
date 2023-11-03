package com.example.Teacher.service;

import org.springframework.stereotype.Service;

import com.example.Teacher.dto.request.TeacherRequestDto;
import com.example.Teacher.entity.Teacher;

public interface TeacherService {
    Teacher registerTeacher(TeacherRequestDto teacherRequestDto);
    Teacher loginATeacher(TeacherRequestDto teacherRequestDto);
}
