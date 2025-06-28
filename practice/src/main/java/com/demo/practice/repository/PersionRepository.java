package com.demo.practice.repository;

import com.demo.practice.entity.Persion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersionRepository extends JpaRepository<Persion,Integer> {
}
