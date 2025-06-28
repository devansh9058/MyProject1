package com.example.RegisterLogin.Controllers;


import com.example.RegisterLogin.Dto.EmployeeDto;
import com.example.RegisterLogin.Dto.LoginDto;
import com.example.RegisterLogin.Dto.OtpRequestDto;
import com.example.RegisterLogin.Dto.OtpVerificationDto;
import com.example.RegisterLogin.Response.LoginResponse;
import com.example.RegisterLogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String createEmployee(@RequestBody EmployeeDto employeeDto){
        String  n= employeeService.addEmployee(employeeDto);
        return n;
    }
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> loginEmployee(@RequestBody LoginDto loginDto){
//       LoginResponse loginResponse=employeeService.loginEmployee(loginDto);
//               return ResponseEntity.ok(loginResponse);
//    }
@PostMapping("/send")
public ResponseEntity<String> sendOtp(@RequestBody OtpRequestDto request) {
    return ResponseEntity.ok(employeeService.sendOtp(request.getEmail()));
}

    @PostMapping("/verify")
    public ResponseEntity<LoginResponse> verifyOtp(@RequestBody OtpVerificationDto dto) {
        return ResponseEntity.ok(employeeService.verifyOtp(dto.getEmail(), dto.getOtp()));
    }


}
