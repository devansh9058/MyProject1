package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Dto.EmployeeDto;
import com.example.RegisterLogin.Dto.LoginDto;
import com.example.RegisterLogin.Entity.Employee;
import com.example.RegisterLogin.Exception.EmailAlreadyExistsException;
import com.example.RegisterLogin.Exception.EmailNotFound;
import com.example.RegisterLogin.Repo.EmployeeRepository;
import com.example.RegisterLogin.Response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
     private PasswordEncoder passwordEncoder;


    private final Map<String, String> otpStore = new HashMap<>();

    public String addEmployee(EmployeeDto employeeDto) {

        if (employeeRepository.existsByEmail(employeeDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + employeeDto.getEmail());
        }
        Employee emp=new Employee(
                employeeDto.getName(),
                employeeDto.getEmail(),
                this.passwordEncoder.encode(employeeDto.getPassword())

        );
        employeeRepository.save(emp);
        return emp.getName();

    }


    public String sendOtp(String email) {

            Employee employee = employeeRepository.findByEmail(email);
            if (employee == null) {
                throw new EmailNotFound("Email not exists: " + email);
            }


            String otp = String.format("%06d", new Random().nextInt(999999));
            otpStore.put(email, otp);


            System.out.println("OTP for " + email + " is: " + otp);
       //endEmail(email, "Your OTP Code", "Your OTP is: " + otp);
            return "OTP sent to your email.";
        }

        public LoginResponse verifyOtp(String email, String inputOtp) {
            String validOtp = otpStore.get(email);

            if (validOtp != null && validOtp.equals(inputOtp)) {
                otpStore.remove(email); // remove OTP after successful login
                return new LoginResponse("Login success with OTP", true);
            } else {
                return new LoginResponse("Invalid or expired OTP", false);
            }
        }



//    public LoginResponse loginEmployee(LoginDto loginDto) {
//        String msg="";
//        Employee employee=employeeRepository.findByEmail(loginDto.getEmail());
//        if(employee!=null){
//            String password= loginDto.getPassword();
//            String password1=employee.getPassword();
//           boolean x=passwordEncoder.matches(password,password1);
//           // boolean x=password.equals(password1);
//            if(x){
//                Optional<Employee> emp= Optional.ofNullable(employeeRepository.findByEmailAndPassword(loginDto.getEmail(), password1));
//                if(emp.isPresent()){
//                    return new LoginResponse("login success",true);
//
//                }else{
//                    return new LoginResponse("login failed",false);
//                }
//
//
//            }else{
//                return new LoginResponse("password not match",false);
//
//            }
//
//        }else{
//            return new LoginResponse("email not exits",false);
//
//        }
//
//
//    }

}
