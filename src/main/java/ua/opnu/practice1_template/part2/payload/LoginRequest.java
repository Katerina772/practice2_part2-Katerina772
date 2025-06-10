package ua.opnu.practice1_template.part2.payload;

import lombok.Data;
import jakarta.validation.constraints.NotBlank; // Змінено з javax на jakarta




public class LoginRequest {
    private String usernameOrEmail;
    private String password;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }
}
