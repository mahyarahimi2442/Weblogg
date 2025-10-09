package ir.ac.weblogg.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDto {
    private  String username;
    private  String password;
    private  String fullName;
    private  String email;

public UserDto() {}
    public UserDto(String username, String password, String fullName, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    @NotBlank(message = "user.username.null")
    public String getUsername() {
        return username;
    }

    @NotBlank(message = "user.password.null")
    public String getPassword() {
        return password;
    }

    @NotBlank(message = "user.fullName.null")
    public String getFullName() {
        return fullName;
    }


    @NotBlank(message = "user.email.null")
    public String getEmail() {
        return email;
    }
}
