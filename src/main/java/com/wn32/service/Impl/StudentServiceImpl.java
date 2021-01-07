package com.wn32.service.Impl;

import com.wn32.mapper.StudentMapper;
import com.wn32.model.Student;
import com.wn32.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> listStudent() throws SQLException {
        List<Student> studentList = studentMapper.selectAll();
        return studentList;
    }
}
