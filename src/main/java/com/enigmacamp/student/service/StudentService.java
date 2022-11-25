package com.enigmacamp.student.service;

import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.validation.MaxDataValidation;

import java.util.List;

public interface StudentService {
    boolean registerStudent(Student newStudent);
    List<Student> getAllStudent();
    Student getStudentByIndex(int idx);
    boolean unregisterStudent();
}
