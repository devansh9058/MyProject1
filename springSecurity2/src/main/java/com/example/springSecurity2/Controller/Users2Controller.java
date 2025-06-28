package com.example.springSecurity2.Controller;

import com.example.springSecurity2.model.Users2;
import com.example.springSecurity2.service.Users2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Users2Controller {
    @Autowired
    private Users2Service service;


    @PostMapping("/resistor")
    public Users2 AddUsers2(@RequestBody Users2 users2){
        return service.add(users2);


    }
    @PostMapping("/login")
    public String login(@RequestBody Users2 users2){

        return service.verify(users2);
    }
}
