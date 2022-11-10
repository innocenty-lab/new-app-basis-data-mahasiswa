package com.enigmacamp.student.repository;

import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.util.Error;
import com.enigmacamp.student.util.ErrorResponse;
import com.enigmacamp.student.util.ResponseStatus;
import com.enigmacamp.student.util.SuccessResponse;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private List<Student> studentList = new ArrayList<>();
    private int maxData;

    public StudentRepositoryImpl(int maxData) {
        this.maxData = maxData;
    }

//    @Override
//    public void add(Student student) {
//        if (studentList.size() < maxData) {
//            studentList.add(student);
//        }
//    }
//
//    @Override
//    public List<Student> viewAll() {
//        return studentList;
//    }
//
//    @Override
//    public void delete() {
//        if (!studentList.isEmpty()) {
//            studentList.remove(studentList.size() - 1);
//        }
//    }
//
//    @Override
//    public Student viewByIndex(int idx) {
//        if (idx >= 0 && idx < studentList.size()) {
//            return studentList.get(idx);
//        } else {
//            return null;
//        }
//    }

    @Override
    public ResponseStatus add(Student student) {
        if (studentList.size() < maxData) {
            studentList.add(student);
            return new SuccessResponse();
        }
        return new ErrorResponse(Error.NOT_ENOUGH_SPACE);
    }

    @Override
    public List<Student> viewAll() {
        return studentList;
    }

    @Override
    public ResponseStatus delete() {
        if (!studentList.isEmpty()) {
            studentList.remove(studentList.size() - 1);
            return new SuccessResponse();
        }
        return new ErrorResponse(Error.DATA_IS_EMPTY);
    }

    @Override
    public Student viewByIndex(int idx) {
        if (idx >= 0 && idx < studentList.size()) {
            return studentList.get(idx);
        } else {
            return null;
        }
    }
}