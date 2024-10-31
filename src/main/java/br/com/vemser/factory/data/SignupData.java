package br.com.vemser.factory.data;

import br.com.vemser.dto.SignupDTO;
import br.com.vemser.util.DataFakerGenerator;
import br.com.vemser.util.Manipulation;

import java.util.Random;


public class SignupData {
    Random rd = new Random();
    DataFakerGenerator faker = new DataFakerGenerator();

    public SignupDTO validSignup() {
        return newSignup();
    }

    public SignupDTO invalidPasswordFormat() {
        SignupDTO signupDTO = newSignup();
        signupDTO.setPassword("1234");
        return signupDTO;
    }

    public SignupDTO invalidNamesFormat() {
        SignupDTO signupDTO = newSignup();
        signupDTO.setFirstName("123");
        signupDTO.setLastName("456");
        return signupDTO;
    }

    public SignupDTO invalidEmailFormat() {
        SignupDTO signupDTO = newSignup();
        signupDTO.setEmail(faker.emailInvalidFaker());
        return signupDTO;
    }

    public SignupDTO existingEmail() {
        SignupDTO signupDTO = newSignup();
        signupDTO.setEmail(Manipulation.getLogin());
        return signupDTO;
    }

    private SignupDTO newSignup() {
        SignupDTO signupDTO = new SignupDTO();
        signupDTO.setEmail(faker.emailFaker());
        signupDTO.setPassword(faker.passwordFaker());
        signupDTO.setFirstName(faker.firstNameFaker());
        signupDTO.setLastName(faker.lastNameFaker());
        signupDTO.setDayOfBirth(String.valueOf(rd.nextInt(1, 29)));
        signupDTO.setMonthOfBirth(String.valueOf(rd.nextInt(1, 12)));
        signupDTO.setYearOfBirth(String.valueOf(rd.nextInt(1924, 2024)));
        return signupDTO;
    }

}
