package com.example.RegisterLogin.Response;

public class LoginResponse {
    private String massage;
    private Boolean status;

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    public LoginResponse(String massage, Boolean status) {
        this.massage = massage;
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "massage='" + massage + '\'' +
                ", status=" + status +
                '}';
    }
}
