package com.example.RegisterLogin.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OtpVerificationDto {
    private String email;
    private String otp;
}
