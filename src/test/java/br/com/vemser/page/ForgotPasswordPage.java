package br.com.vemser.page;


import br.com.vemser.factory.selenium.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static br.com.vemser.factory.selenium.Validation.validatePage;
import static br.com.vemser.page.LoginPage.clickSignInRedirectButton;
import static br.com.vemser.page.LoginPage.getPageLogin;

public class ForgotPasswordPage extends Interactions {

    private static final By pageID =
            By.cssSelector("body[id='password']");

    private static final By inputEmail =
            By.cssSelector("form[id='form_forgotpassword'] input[class='form-control']");

    private static final By buttonSubmit =
            By.cssSelector(".submit button");

    private static final By textSuccess =
            By.cssSelector("p[class='alert alert-success']");

    private static final By btnForgotPwd =
            By.cssSelector(".lost_password a");


    private static final By textError =
            By.cssSelector(".alert-danger ol li");

    public static WebElement getForgotPwdPage() {
        return getBody(pageID);
    }

    public static void fillEmailInput(String email) {
        sendKeys(inputEmail, email);
    }

    public static void clickSubmitButton() {
        click(buttonSubmit);
    }

    public static String getSuccessText() {
        return getText(textSuccess);
    }

    public static void clickForgotPwdButton() {
        click(btnForgotPwd);
    }

    public static String getErrorText() {
        return getText(textError);
    }

    public static void ForgotPWD(String email) {
        clickSignInRedirectButton();
        validatePage(getPageLogin());
        clickForgotPwdButton();
        validatePage(getForgotPwdPage());
        fillEmailInput(email);
        clickSubmitButton();
    }
}
