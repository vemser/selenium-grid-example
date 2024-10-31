package br.com.vemser.factory.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static br.com.vemser.factory.selenium.Waits.waitElement;

public class Interactions extends Elements {

    protected static void sendKeys(By by, String text) {
        waitElement(by);
        element(by).sendKeys(text);
    }

    protected static void click(By by) {
        waitElement(by);
        element(by).click();
    }

    protected static String getText(By by) {
        waitElement(by);
        return element(by).getText();
    }

    protected static WebElement getBody(By by) {
        waitElement(by);
        return element(by);
    }

    protected static void selectValue(By by, String value) {
        waitElement(by);
        Select select = new Select(element(by));
        select.selectByValue(value);
    }

    protected static void clear(By by) {
        waitElement(by);
        element(by).clear();
    }

}
