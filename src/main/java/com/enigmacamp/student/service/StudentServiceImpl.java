package com.enigmacamp.student.service;

import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.repository.StudentRepository;
import com.enigmacamp.student.util.ResponseStatus;
import com.enigmacamp.student.validation.MaxDataValidation;
import com.enigmacamp.student.validation.StudentAgeValidation;
import com.enigmacamp.student.validation.StudentNameLengthValidation;
import com.enigmacamp.student.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    StudentAgeValidation studentAgeValidation;
    @Autowired
    StudentNameLengthValidation studentNameLengthValidation;

    // tanpa response status dan validation
//    public StudentServiceImpl(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    // tanpa response status dan validation
//    @Override
//    public boolean registerStudent(Student newStudent) {
//        int nameLength = newStudent.getFullName().length();
//        int age = newStudent.getUmur();
//        if (age > 17 && nameLength > 3 && nameLength < 20) {
//            studentRepository.add(newStudent);
//        }
//        return true;
//    }
//
//    @Override
//    public List<Student> getAllStudent() {
//        return studentRepository.viewAll();
//    }
//
//    @Override
//    public Student getStudentByIndex(int idx) {
//        return studentRepository.viewByIndex(idx);
//    }
//
//    @Override
//    public boolean unregisterStudent() {
//        studentRepository.delete();
//        return true;
//    }

    // dengan response status dan validatiom
    @Override
    public boolean registerStudent(Student newStudent) {
        ResponseStatus ageStatus = studentAgeValidation.test(newStudent);
        if (!ageStatus.isValid()) return ageStatus.isValid();

        ResponseStatus nameLenStatus = studentNameLengthValidation.test(newStudent);
        if (!nameLenStatus.isValid()) return nameLenStatus.isValid();

        ResponseStatus registerStatus = studentRepository.add(newStudent);
        return registerStatus.isValid();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.viewAll();
    }

    @Override
    public Student getStudentByIndex(int idx) {
        return studentRepository.viewByIndex(idx);
    }

    @Override
    public boolean unregisterStudent() {
        return studentRepository.delete().isValid();
    }
}
