package br.com.vemser.factory.data;

import br.com.vemser.dto.LoginDTO;
import br.com.vemser.util.*;

public class LoginData {
    DataFakerGenerator faker = new DataFakerGenerator();

    public LoginDTO validLogin() {
        LoginDTO loginDTO = newLogin();
        loginDTO.setEmail(Manipulation.getLogin());
        loginDTO.setPassword(Manipulation.getPwd());
        return loginDTO;
    }

    public LoginDTO invalidPasswordLogin() {
        LoginDTO loginDTO = newLogin();
        loginDTO.setEmail(Manipulation.getLogin());
        loginDTO.setPassword("12345");
        return loginDTO;
    }

    public LoginDTO blankPasswordLogin() {
        LoginDTO loginDTO = newLogin();
        loginDTO.setEmail(Manipulation.getLogin());
        loginDTO.setPassword("");
        return loginDTO;
    }

    public LoginDTO blankEmailLogin() {
        LoginDTO loginDTO = newLogin();
        loginDTO.setEmail("");
        loginDTO.setPassword(Manipulation.getPwd());
        return loginDTO;
    }

    private LoginDTO newLogin() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(faker.emailFaker());
        loginDTO.setPassword(faker.passwordFaker());
        return loginDTO;
    }
}
