package br.com.vemser.tests;

import br.com.vemser.dto.LoginDTO;
import br.com.vemser.factory.data.LoginData;
import org.testng.annotations.Test;

import static br.com.vemser.factory.selenium.Validation.validatePage;
import static br.com.vemser.factory.selenium.Validation.validateText;
import static br.com.vemser.page.ForgotPasswordPage.*;
import static br.com.vemser.page.LoginPage.clickSignInRedirectButton;
import static br.com.vemser.page.LoginPage.getPageLogin;

public class ForgotPasswordTest extends BaseTest {
    LoginData loginData = new LoginData();

    @Test
    public void testForgotMyPasswordWithSucess() {
        LoginDTO loginDTO = loginData.validLogin();
        clickSignInRedirectButton();
        validatePage(getPageLogin());
        clickForgotPwdButton();
        validatePage(getForgotPwdPage());
        fillEmailInput(loginDTO.getEmail());
        clickSubmitButton();
        validateText(getSuccessText(), "A confirmation email has been sent to your address: " + loginDTO.getEmail());
    }

    @Test
    public void testForgotMyPasswordWithBlankEmail() {
        LoginDTO loginDTO = loginData.blankEmailLogin();
        ForgotPWD(loginDTO.getEmail());
        validateText(getErrorText(), "Invalid email address.");
    }

    @Test
    public void testForgotMyPasswordWithIncorrectFormatEmail() {
        LoginDTO loginDTO = loginData.validLogin();
        ForgotPWD("incorrectMail.br");
        validateText(getErrorText(), "Invalid email address.");
    }

}
