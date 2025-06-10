package ua.opnu.practice1_template.part2.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
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
}
