package com.wn32.controller;

import com.wn32.model.Student;
import com.wn32.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/showAllStudents")
    public String showAllStudents(ModelMap modelMap){
        List<Student> studentList = null;

        try {
            studentList = studentService.listStudent();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        modelMap.addAttribute("stuList",studentList);
        return "list";

    }
}
