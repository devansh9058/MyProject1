package com.demo.practice.service;

import com.demo.practice.entity.Persion;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PersionService {



    void addPersion(Persion persion);


    ResponseEntity<List<Persion>> getAllPersion();


    Optional<Persion> getById(Integer id);
}
