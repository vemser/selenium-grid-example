package br.com.vemser.factory.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Elements extends BrowserService {

    public static WebElement element(By by) {
        return getDriver().findElement(by);
    }

}
