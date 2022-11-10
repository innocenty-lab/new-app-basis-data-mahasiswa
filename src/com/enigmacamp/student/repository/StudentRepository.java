package com.enigmacamp.student.repository;

import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.util.ResponseStatus;

import java.util.List;

public interface StudentRepository {
    // tanpa respone status
//    void add(Student student);
//    List<Student> viewAll();
//    void delete();
//    Student viewByIndex(int idx);

    // dengan respone status
    ResponseStatus add(Student student);
    List<Student> viewAll();
    ResponseStatus delete();
    Student viewByIndex(int idx);
}
