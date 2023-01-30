package com.example.firstspringproject;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class StudentRepository {
    HashMap<Integer, Student> dB = new HashMap<>();
    public String addStudent(Student student)
    {
        int id= student.getAdmno();
        dB.put(id,student);
        return "Student added succesfully";
    }
    public Student getStudent(int id)
    {
        return dB.get(id);
    }
    public String deleteStudent(int id)
    {
        if(!dB.containsKey(id))
            return "invalid id";
        dB.remove(id);
        return "Student deleted succesfully";
    }
    public String updateStudent(int id,int age)
    {
        if(!dB.containsKey(id))
            return "null";
        Student student=dB.get(id);
        student.setAge(age);
        return "Updated student";
    }

}
