package com.example.springSecurity2.service;

import com.example.springSecurity2.Repo.UserRepo;
import com.example.springSecurity2.model.Users2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Users2Service {
    @Autowired
    private UserRepo repo;
    @Autowired
    private AuthenticationManager authManager;
@Autowired
private JwtService jwtServic;
    private BCryptPasswordEncoder encoder=new  BCryptPasswordEncoder(12);


    public Users2 add(Users2 users2){
        users2.setPassword(encoder.encode(users2.getPassword()));
        return repo.save(users2);

    }

    public String verify(Users2 users2) {
        Authentication authentication=
                authManager.authenticate(new UsernamePasswordAuthenticationToken(users2.getUsername(),users2.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtServic.generateToken(users2.getUsername() );
        }else{
            return "fail";
        }
    }
}
