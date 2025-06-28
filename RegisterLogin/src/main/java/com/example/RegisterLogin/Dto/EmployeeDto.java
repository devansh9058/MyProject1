package com.example.RegisterLogin.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Data
public class EmployeeDto {

    private String name;
    private String email;
    private String password;


}
