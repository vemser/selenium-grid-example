package br.com.vemser.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
}
