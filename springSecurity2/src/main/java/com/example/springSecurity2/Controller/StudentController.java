package com.example.springSecurity2.Controller;

import com.example.springSecurity2.model.Student;
import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students=new ArrayList<>(List.of(new Student(1,"devansh",69),
            new Student(2,"ankur",56),
            new Student(3,"don",78)));


     @GetMapping("/students")
     public List<Student> getAllStudent(){

         return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
         return (CsrfToken)request.getAttribute("_csrf");

    }

    @PostMapping("/students")
    public Student getAllStudent(@RequestBody Student student){
         students.add(student);
         return student;

    }


}
