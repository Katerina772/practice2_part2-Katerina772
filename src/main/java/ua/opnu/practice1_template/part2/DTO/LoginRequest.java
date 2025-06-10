package ua.opnu.practice1_template.part2.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class LoginRequest {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;


    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}