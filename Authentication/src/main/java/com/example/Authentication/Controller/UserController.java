package com.example.Authentication.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Api/v1/user")
@RequiredArgsConstructor

public class UserController {
    @GetMapping
    public ResponseEntity<String>  sayHello(){
        return ResponseEntity.ok( "hi user");

    }
}
