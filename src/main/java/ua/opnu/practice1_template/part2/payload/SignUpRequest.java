package ua.opnu.practice1_template.part2.payload;



import lombok.Data;
import jakarta.validation.constraints.*;

public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private String username;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
