package com.example.Teacher.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TeacherRequestDto {
    private String firstname;
    private String lastname;
    private String email;
    @NotBlank(message = "this field cannot be blank")
    @NotEmpty(message = "this field cannot be empty")
    @NotNull(message = "this field cannot be null")
    @Max(value = 20,message = "password cannot exceed 20 characters")
    @Min(value = 8,message = "password cannot be less than 8 characters")
    private String password;

}
