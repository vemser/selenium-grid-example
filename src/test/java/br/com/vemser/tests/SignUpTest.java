package br.com.vemser.tests;

import br.com.vemser.dto.SignupDTO;
import br.com.vemser.factory.data.SignupData;
import org.testng.annotations.Test;

import static br.com.vemser.factory.selenium.Validation.*;
import static br.com.vemser.page.LoginPage.clickSignInRedirectButton;
import static br.com.vemser.page.LoginPage.getPageLogin;
import static br.com.vemser.page.SignupPage.*;

public class SignUpTest extends BaseTest {
    SignupData signupData = new SignupData();

    @Test
    public void testSignUpWithSucess() {
        SignupDTO signupDTO = signupData.validSignup();
        clickSignInRedirectButton();
        validatePage(getPageLogin());
        fillEmailInput(signupDTO.getEmail());
        clickCreateAccountButton();
        validateText(getAccountCreationText(), "YOUR PERSONAL INFORMATION");
        clickTitleRadioButton();
        fillFirstNameInput(signupDTO.getFirstName());
        fillLastNameInput(signupDTO.getLastName());
        fillPwdInput(signupDTO.getPassword());
        setSelectDays(signupDTO.getDayOfBirth());
        setSelectMonths(signupDTO.getMonthOfBirth());
        setSelectYears(signupDTO.getYearOfBirth());
        clickNewsletterButton();
        clickRegisterButton();
        String expected = getSucessText();
        validateText(expected, "Your account has been created.");
    }

    @Test
    public void testSignUpWithInvalidEmailFormat() {
        SignupDTO signupDTO = signupData.invalidEmailFormat();
        firstPageSignup(signupDTO);
        validatePresence(getFormNotOk());
    }

    @Test
    public void testSignUpWithAlreadyExistingEmail() {
        SignupDTO signupDTO = signupData.existingEmail();
        firstPageSignup(signupDTO);
        validateText(getErrorMessageText(), "An account using this email address has already been registered. Please enter a valid password or request a new one.");
    }

    @Test
    public void testSignUpWithBlankForm() {
        firstPageSignup(signupData.validSignup());
        validateText(getAccountCreationText(), "YOUR PERSONAL INFORMATION");
        clearEmailInput();
        clickRegisterButton();
        validateText(getCreateAccountErrorMessage(), "There are 4 errors");
        validateText(getFirstErrorMessage(), "lastname is required.");
        validateText(getSecondErrorMessage(), "firstname is required.");
        validateText(getThirdErrorMessage(), "email is required.");
        validateText(getFourthErrorMessage(), "passwd is required.");
    }

    @Test
    public void testFormWithPasswordWithLessThanFiveCharacters() {
        SignupDTO signupDTO = signupData.invalidPasswordFormat();
        secondPageSingup(signupDTO);
        validateText(getCreateAccountErrorMessage(), "There is 1 error");
        validateText(getFirstErrorMessage(), "passwd is invalid.");
    }

    @Test
    public void testFormWithEmailAlreadyExisting() {
        SignupDTO signupDTO = signupData.existingEmail();
        secondPageSingup(signupDTO);
        validateText(getCreateAccountErrorMessage(), "There is 1 error");
        validateText(getFirstErrorMessage(), "An account using this email address has already been registered.");
    }

}
