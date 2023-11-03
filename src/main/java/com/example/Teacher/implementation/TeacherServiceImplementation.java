package com.example.Teacher.implementation;

import com.example.Teacher.dto.request.TeacherRequestDto;
import com.example.Teacher.entity.Teacher;
import com.example.Teacher.repository.TeacherRepository;
import com.example.Teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
@Service
public class TeacherServiceImplementation implements TeacherService {
    private TeacherRepository teacherRepository;
       @Autowired
    public TeacherServiceImplementation(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher registerTeacher(TeacherRequestDto teacherRequestDto) {
        if (teacherRequestDto.getFirstname() == null || teacherRequestDto.getPassword() == null){
            throw  new InputMismatchException("check for incorrect input");
        }else{
            if (teacherRepository.findFirstByEmail(teacherRequestDto.getEmail()).isPresent()){
                throw new InputMismatchException("check for incorrect input");
            }
            Teacher teacher = new Teacher();
            teacher.setFirstname(teacherRequestDto.getFirstname());
            teacher.setLastname(teacherRequestDto.getLastname());
            teacher.setEmail(teacherRequestDto.getEmail());
            teacher.setPassword(teacherRequestDto.getPassword());
            teacherRepository.save(teacher);
            return teacher;
        }
    }

    @Override
    public Teacher loginATeacher(TeacherRequestDto teacherRequestDto) {
       return teacherRepository
               .findByEmailAndPassword(teacherRequestDto
                               .getEmail()
                       ,teacherRequestDto.getPassword())
               .orElseThrow(()-> new InputMismatchException("invalid input"));
    }
}
