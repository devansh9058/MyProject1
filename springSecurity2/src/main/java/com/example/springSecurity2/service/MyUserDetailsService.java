package com.example.springSecurity2.service;

import com.example.springSecurity2.Repo.UserRepo;
import com.example.springSecurity2.model.UserPrincipal;
import com.example.springSecurity2.model.Users2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users2 user =userRepo.findByUsername(username);

       if(user==null){
    System.out.print("user not found");
    throw new UsernameNotFoundException("user not found");
      }


        return new UserPrincipal(user);

    }


}
