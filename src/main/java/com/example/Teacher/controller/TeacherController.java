package com.example.Teacher.controller;

import com.example.Teacher.dto.request.TeacherRequestDto;
import com.example.Teacher.entity.Teacher;
import com.example.Teacher.implementation.TeacherServiceImplementation;
import com.example.Teacher.service.TeacherService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {
    private final TeacherService teacherServiceImplementation;
      @Autowired
    public TeacherController(TeacherService teacherServiceImplementation) {
        this.teacherServiceImplementation = teacherServiceImplementation;
    }


    @GetMapping("/registerTeacher")
    public String getTeachersRegistrationPage(Model model){
          model.addAttribute("registerRequest", new TeacherRequestDto());
          return "teacherRegistrationPage";
    }

    @GetMapping("/loginTeacher")
    public String getTeachersLoginPage(Model model){
          model.addAttribute("loginRequest", new TeacherRequestDto());
          return "teacherLoginPage";
    }

    @PostMapping("/registerTeacher")
    public String registerTeacher(@ModelAttribute TeacherRequestDto teacherRequestDto){
          Teacher registeredTeacher = teacherServiceImplementation.registerTeacher(teacherRequestDto);
          return registeredTeacher == null ? "errorPage" : "teacherLoginPage";
    }
    @PostMapping("/loginTeacher")
    public String loginTeacher(@ModelAttribute TeacherRequestDto teacherRequestDto, Model model, HttpServletRequest request){
          Teacher loginATeacher = teacherServiceImplementation.loginATeacher(teacherRequestDto);
          if (loginATeacher != null){
             model.addAttribute("loginRequest",loginATeacher.getEmail());

              HttpSession session = request.getSession();
              session.setAttribute("teacherId", loginATeacher.getId());
             return "addToBookStorePage";
          }else return  "errorPage";

    }
}
