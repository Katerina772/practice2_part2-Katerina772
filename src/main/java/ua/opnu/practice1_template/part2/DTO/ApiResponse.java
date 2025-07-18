package ua.opnu.practice1_template.part2.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

public class ApiResponse {
    private Boolean success;
    private String message;


    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}