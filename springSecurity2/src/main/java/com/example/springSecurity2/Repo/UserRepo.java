package com.example.springSecurity2.Repo;

import com.example.springSecurity2.model.Users2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users2, Integer> {

Users2 findByUsername(String username);

}
