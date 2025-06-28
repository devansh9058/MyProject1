package com.demo.practice.service.Imp;

import com.demo.practice.entity.Persion;
import com.demo.practice.repository.PersionRepository;
import com.demo.practice.service.PersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersionServiceImp implements PersionService {
    @Autowired
    private PersionRepository persionRepository;


    @Override
    public void addPersion(Persion persion) {
        persionRepository.save(persion);
    }

    @Override
    public ResponseEntity<List<Persion>> getAllPersion() {
        List<Persion> list=persionRepository.findAll();
        return ResponseEntity.ok(list);

    }

    @Override
    public Optional<Persion> getById(Integer id) {
        Optional<Persion> persion=persionRepository.findById(id);

        return persion;
    }


}
