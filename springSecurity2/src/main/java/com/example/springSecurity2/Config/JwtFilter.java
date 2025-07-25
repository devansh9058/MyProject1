package com.example.springSecurity2.Config;

import com.example.springSecurity2.service.JwtService;
import com.example.springSecurity2.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqaG9uIiwiaWF0IjoxNzQyNTM5OTc5LCJleHAiOjE3NDI1NDAwODd9.P23HJvukbEcCxvogitPDAmaQDosUFqHIjuT_dqoCJ84
        String authHeader= request.getHeader("Authorization");
        String token=null;
        String username=null;



if(authHeader!=null && authHeader.startsWith("Bearer")){
    token=authHeader.substring(7);
    username=jwtService.extractUsername(token);
}

if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
    UserDetails userDetails=context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
    if(jwtService.validateToken(token,userDetails)){
    UsernamePasswordAuthenticationToken authToken=
            new UsernamePasswordAuthenticationToken(userDetails,null,(userDetails.getAuthorities()));
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
    }
}
  filterChain.doFilter(request,response);
    }
}
