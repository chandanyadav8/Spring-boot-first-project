package com.example.firstspringproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class StudentController {


//    //adding the student
//    @PostMapping("/add_student")
//    public String addStudent(@RequestBody Student student) {
//        int admno = student.getAdmno();
//        dB.put(admno, student);
//        return "Added succesfully";
//    }
//
//    // gettting the student
//    //using request param add the elements
////    @GetMapping("/get_student")
////    public Student getstudent(@RequestParam("q") int admission)
////    {
////        return dB.get(admission);
////    }
//
//
//    //    using pathvariable add the elemements
//    @GetMapping("/get_student/{admnNo}")
//    public Student getStudent(@PathVariable("admnNo") int admission) {
//        return dB.get(admission);
//    }
//
//    //updating the student
//    @PutMapping("/put_student/{id}/{age}")
//    public String putStudent(@PathVariable("id")int id,@PathVariable("age")int age) {
//
//        if (!dB.containsKey(id))
//            return "invalid id";
//        Student student= dB.get(id);
//        student.setAge(age);
//        dB.put(id,student);
//        return "Added succesfully in put";
//    }
//
//    // deleting student
//    @DeleteMapping("/delete_student/{admnNo}")
//    public String deleteStudent(@PathVariable("admnNO") int admission) {
//        if(!dB.containsKey(admission))
//        {
//            return "invalid id";
//        }
//        dB.remove(admission);
//        return "Student deleted succesfully";
//    }

//    using the layered structure
//    response entity is added as well

    @Autowired
    StudentService studentService;
    //adding the student
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student) {
String response= studentService.addStudent(student);
return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //    using pathvariable add the elemements
    @GetMapping("/get_student/{admnNo}")
    public ResponseEntity getStudent(@PathVariable("admnNo") int admission) {
        Student response= studentService.getStudent(admission);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
//
//    //updating the student
    @PutMapping("/update_student/{id}/{age}")
    public ResponseEntity updateStudent(@PathVariable("id")int id,@PathVariable("age")int age) {

      String response=studentService.updateStudent(id,age);
      if(response.equals(null))
          return new ResponseEntity<>("null",HttpStatus.NOT_FOUND);
      return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

//    // deleting student
    @DeleteMapping("/delete_student/{admnNo}")
    public ResponseEntity deleteStudent(@PathVariable("admnNO") int admission) {
        String response=studentService.deleteStudent(admission);
        if(response.equals("invalid id"))
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

}
