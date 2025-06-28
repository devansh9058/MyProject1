package com.demo.practice.controller;

import com.demo.practice.entity.Persion;
import com.demo.practice.service.PersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persion")

public class PersionController {
    @Autowired
    private PersionService persionService;
    @PostMapping("/create")
    public ResponseEntity<Persion> addPersion(@RequestBody Persion persion){
        persionService.addPersion(persion);
        return     ResponseEntity.status(  HttpStatus.CREATED).body(persion);

    }
    @GetMapping("/allPersion")
    public ResponseEntity<List<Persion>> getAllPersion(){

        return (persionService.getAllPersion()) ;

    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Persion>> getById(@RequestParam Integer id){

        return ResponseEntity.status(200).body(persionService.getById(id));
    }

    }

