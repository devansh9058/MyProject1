package com.example.springSecurity2.Config;

import jakarta.security.auth.message.config.AuthConfigProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsService  userDetailsService;
@Autowired
private JwtFilter jwtFilter;
    @Bean
    public  SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {
//       http.csrf(customizer->customizer.disable());
//        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
//      //http.formLogin(Customizer.withDefaults());
//      http.httpBasic(Customizer.withDefaults());
//      http.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        return http.build();


     return http.csrf(customizer->customizer.disable())
                .authorizeHttpRequests(request-> request
                        .requestMatchers("resistor","login")
                        .permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
             .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();



//   Customizer<CsrfConfigurer<HttpSecurity>> custCsrf=new Customizer<CsrfConfigurer<HttpSecurity>>() {
//       @Override
//       public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//
//           customizer.disable();
//
//       }
//   };
//http.csrf(custCsrf);
//
//        return http.build();
    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1= User
//                .withDefaultPasswordEncoder()
//                .username("ankur")
//                .password("Ankur@123")
//                .roles("USER")
//                .build();
//        UserDetails user2= User
//                .withDefaultPasswordEncoder()
//                .username("devansh")
//                .password("Devansh@123")
//                .roles("ADMIN")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
   // provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

    provider.setUserDetailsService(userDetailsService);
    return provider;

}
@Bean
    public AuthenticationManager uuthenticationManager(AuthenticationConfiguration config) throws Exception {
     return config.getAuthenticationManager();

}
}
