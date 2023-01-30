package com.example.firstspringproject;

public class Student {
    private String name;
    private int age;
    private int admno;
    private String state;

    public Student(String name, int age, int admno, String state) {
        this.name = name;
        this.age = age;
        this.admno = admno;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAdmno() {
        return admno;
    }

    public void setAdmno(int admno) {
        this.admno = admno;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
