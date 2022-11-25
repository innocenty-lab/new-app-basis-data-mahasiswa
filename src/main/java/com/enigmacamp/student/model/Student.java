package com.enigmacamp.student.model;

public class Student {

    private String fullName;
    private Integer umur;
    private Major major;

    public Student(String fullName, Integer umur, Major major) {
        this.fullName = fullName;
        this.umur = umur;
        this.major = major;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", umur=" + umur +
                ", major=" + major +
                '}';
    }
}
