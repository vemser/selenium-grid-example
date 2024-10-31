package br.com.vemser.page;

import br.com.vemser.factory.selenium.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static br.com.vemser.factory.selenium.Validation.validatePage;

public class LoginPage extends Interactions {
    private static final By pageID =
            By.cssSelector("body[id=\"authentication\"]");

    private static final By btnRedirectLogin =
            By.cssSelector(".header_user_info .login");

    private static final By inputEmail =
            By.cssSelector("input[id=\"email\"]");

    private static final By inputPwd =
            By.cssSelector("input[id=\"passwd\"]");

    private static final By btnSignIn =
            By.cssSelector("button[id=\"SubmitLogin\"]");

    private static final By textLoggedIn =
            By.cssSelector(".account span");

    private static final By textError =
            By.cssSelector(".alert-danger ol li");

    private static final By formOkEmail =
            By.cssSelector("div[class=\"form-group form-ok\"]:nth-child(1)");

    private static final By formNotOkEmail =
            By.cssSelector("div[class=\"form-group form-error\"]:nth-child(1)");

    private static final By formOkPwd =
            By.cssSelector("div[class=\"form-group form-ok\"]:nth-child(2)");

    private static final By formLogin =
            By.cssSelector("form[id=\"login_form\"]");


    public static void clickSignInRedirectButton() {
        click(btnRedirectLogin);
    }

    public static WebElement getPageLogin() {
        return getBody(pageID);
    }

    public static void fillEmailInput(String email) {
        sendKeys(inputEmail, email);
    }

    public static void fillPwdInput(String pwd) {
        sendKeys(inputPwd, pwd);
    }

    public static void clickSignInLoginButton() {
        click(btnSignIn);
    }

    public static String getErrorText() {
        return getText(textError);
    }

    public static String getLoggedInUsername() {
        return getText(textLoggedIn);
    }

    public static WebElement getEmailFormOk() {
        return getBody(formOkEmail);
    }

    public static WebElement getEmailFormNotOk() {
        return getBody(formNotOkEmail);
    }

    public static WebElement getPwdFormOk() {
        return getBody(formOkPwd);
    }


    public static void clickLoginForm() {
        click(formLogin);
    }

    public static void Login(String email, String password) {
        clickSignInRedirectButton();
        validatePage(getPageLogin());
        fillEmailInput(email);
        fillPwdInput(password);
        clickSignInLoginButton();
    }
}
