package br.com.vemser.tests;

import br.com.vemser.dto.LoginDTO;
import br.com.vemser.factory.data.LoginData;
import br.com.vemser.util.Manipulation;
import org.testng.annotations.Test;

import static br.com.vemser.factory.selenium.Validation.*;
import static br.com.vemser.page.LoginPage.*;

public class LoginTest extends BaseTest{
    LoginData loginData = new LoginData();

    @Test
    public void testLoginWithSucess() {
        LoginDTO login = loginData.validLogin();
        clickSignInRedirectButton();
        validatePage(getPageLogin());
        fillEmailInput(login.getEmail());
        fillPwdInput(login.getPassword());
        clickSignInLoginButton();
        String validation = getLoggedInUsername();
        validateText(validation, Manipulation.getNome());
    }

    @Test
    public void testLoginWithIncorretPassword() {
        LoginDTO login = loginData.invalidPasswordLogin();
        Login(login.getEmail(), login.getPassword());
        validateText(getErrorText(), "Authentication failed.");
    }

    @Test
    public void testLoginWithBlankPassword() {
        LoginDTO login = loginData.blankPasswordLogin();
        Login(login.getEmail(), login.getPassword());
        validateText(getErrorText(), "Password is required.");
    }

    @Test
    public void testLoginWithBlankEmail() {
        LoginDTO login = loginData.blankEmailLogin();
        Login(login.getEmail(), login.getPassword());
        validateText(getErrorText(), "An email address required.");
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        LoginDTO login = loginData.invalidPasswordLogin();
        Login(login.getEmail(), login.getPassword());
        validateText(getErrorText(), "Authentication failed.");
    }

    @Test
    public void testValidateFormsInputDataWithSucess() {
        LoginDTO login = loginData.validLogin();
        clickSignInRedirectButton();
        validatePage(getPageLogin());
        fillEmailInput(login.getEmail());
        fillPwdInput(login.getPassword());
        clickLoginForm();
        validatePresence(getEmailFormOk());
        validatePresence(getPwdFormOk());
    }

    @Test
    public void testValidateEmailFormWithIncorrectInputData() {
        LoginDTO login = loginData.validLogin();
        clickSignInRedirectButton();
        validatePage(getPageLogin());
        fillEmailInput(login.getEmail().replace("@gmail.com", ""));
        fillPwdInput(login.getPassword());
        clickLoginForm();
        validatePresence(getEmailFormNotOk());
        validatePresence(getPwdFormOk());
    }

}
