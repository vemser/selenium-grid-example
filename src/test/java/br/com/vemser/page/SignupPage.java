package br.com.vemser.page;

import br.com.vemser.dto.SignupDTO;
import br.com.vemser.factory.data.SignupData;
import br.com.vemser.factory.selenium.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static br.com.vemser.factory.selenium.Validation.validatePage;
import static br.com.vemser.factory.selenium.Validation.validateText;
import static br.com.vemser.page.LoginPage.clickSignInRedirectButton;
import static br.com.vemser.page.LoginPage.getPageLogin;

public class SignupPage extends Interactions {
    static SignupData signupData = new SignupData();

    private static final By inputEmail =
            By.cssSelector("input[id='email_create']");
    private static final By btnMyFirstAddress =
            By.cssSelector("#center_column > div > div > ul > li:nth-child(1) > a > span");

    private static final By btnCreateAcc =
            By.cssSelector("button[id='SubmitCreate']");

    private static final By RadioButtonTitle =
            By.cssSelector("input[id='id_gender1']");

    private static final By inputFirstName =
            By.cssSelector("input[id='customer_firstname']");

    private static final By inputLastName =
            By.cssSelector("input[id='customer_lastname']");

    private static final By inputEmailSignUp =
            By.cssSelector("input[id='email']");

    private static final By inputPassword =
            By.cssSelector("input[id='passwd']");

    private static final By selectDays =
            By.cssSelector("select[id='days']");

    private static final By selectMonths =
            By.cssSelector("select[id='months']");

    private static final By selectYears =
            By.cssSelector("select[id='years']");

    private static final By inputNewsletter =
            By.cssSelector("input[id='newsletter']");

    private static final By buttonSubmit =
            By.cssSelector("button[id='submitAccount']");

    private static final By sucessText =
            By.cssSelector(".alert.alert-success");

    private static final By formNotOk =
            By.cssSelector("form[id=\"create-account_form\"] div[class=\"form-group form-error\"]");

    private static final By textErrorMessage =
            By.cssSelector("div[id=\"create_account_error\"] li");

    private static final By textAccountCreation =
            By.cssSelector("div[class=\"account_creation\"] h3");

    private static final By textCreateAccountErrorMessage =
            By.cssSelector("div[class=\"alert alert-danger\"] p");

    private static final By textFirstErrorMessage =
            By.cssSelector("div[class=\"alert alert-danger\"] li:nth-child(1)");

    private static final By textSecondErrorMessage =
            By.cssSelector("div[class=\"alert alert-danger\"] li:nth-child(2)");

    private static final By textThirdErrorMessage =
            By.cssSelector("div[class=\"alert alert-danger\"] li:nth-child(3)");

    private static final By textFourthErrorMessage =
            By.cssSelector("div[class=\"alert alert-danger\"] li:nth-child(4)");

    public static void fillEmailInput(String email) {
        sendKeys(inputEmail, email);
    }

    public static void fillPwdInput(String pwd) {
        sendKeys(inputPassword, pwd);
    }

    public static void clickCreateAccountButton() {
        click(btnCreateAcc);
    }

    public static void clickTitleRadioButton() {
        click(RadioButtonTitle);
    }

    public static void fillFirstNameInput(String firstName) {
        sendKeys(inputFirstName, firstName);
    }

    public static void fillLastNameInput(String lastName) {
        sendKeys(inputLastName, lastName);
    }

    public static void fillFormEmailInput(String email) {
        sendKeys(inputEmailSignUp, email);
    }

    public static void setSelectDays(String value) {
        selectValue(selectDays, value);
    }

    public static void setSelectMonths(String value) {
        selectValue(selectMonths, value);
    }

    public static void setSelectYears(String value) {
        selectValue(selectYears, value);
    }

    public static void clickNewsletterButton() {
        click(inputNewsletter);
    }

    public static void clickRegisterButton() {
        click(buttonSubmit);
    }

    public static String getSucessText() {
        return getText(sucessText);
    }

    public static WebElement getFormNotOk() {
        return getBody(formNotOk);
    }

    public static String getErrorMessageText() {
        return getText(textErrorMessage);
    }

    public static String getAccountCreationText() {
        return getText(textAccountCreation);
    }

    public static String getCreateAccountErrorMessage() {
        return getText(textCreateAccountErrorMessage);
    }

    public static String getFirstErrorMessage() {
        return getText(textFirstErrorMessage);
    }

    public static String getSecondErrorMessage() {
        return getText(textSecondErrorMessage);
    }

    public static String getThirdErrorMessage() {
        return getText(textThirdErrorMessage);
    }

    public static String getFourthErrorMessage() {
        return getText(textFourthErrorMessage);
    }

    public static void clearEmailInput() {
        clear(inputEmailSignUp);
    }

    public static void firstPageSignup(SignupDTO signupDTO) {
        clickSignInRedirectButton();
        validatePage(getPageLogin());
        fillEmailInput(signupDTO.getEmail());
        clickCreateAccountButton();
    }

    public static void secondPageSingup(SignupDTO signupDTO) {
        firstPageSignup(signupData.validSignup());
        validateText(getAccountCreationText(), "YOUR PERSONAL INFORMATION");
        fillFormEmailInput(signupDTO.getEmail());
        fillFirstNameInput(signupDTO.getFirstName());
        fillLastNameInput(signupDTO.getLastName());
        fillPwdInput(signupDTO.getPassword());
        clickRegisterButton();
    }
}
