package com.wn32.service;

import com.wn32.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    List<Student> listStudent() throws SQLException;
}
