package br.com.vemser.factory.selenium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Validation {

    public static void validateText(String expected, String Actual) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expected, Actual);
    }

    public static void validatePage(WebElement element) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(element.isDisplayed());
    }

    public static void validatePresence(WebElement element) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(element);
    }

}
