package br.com.vemser.factory.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserService{

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    private final String GRID_URI = "http://localhost:4444/wd/hub";

    public void initDriver(String url, String browser) throws MalformedURLException {

        switch (browser.toLowerCase()) {
            case "chrome":
                driver.set(ThreadGuard.protect(new RemoteWebDriver(new URL(GRID_URI), new ChromeOptions())));
                break;
            case "firefox":
                driver.set(ThreadGuard.protect(new RemoteWebDriver(new URL(GRID_URI), new FirefoxOptions())));
                break;
            case "edge":
                driver.set(ThreadGuard.protect(new RemoteWebDriver(new URL(GRID_URI), new EdgeOptions())));
                break;
            default:
                throw new IllegalArgumentException("Navegador não suportado: " + browser);
        }

        wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(15)));
        getDriver().get(url);

    }

    public void quit() {
        getDriver().quit();
        driver.remove();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static WebDriverWait getWait(){
        return wait.get();
    }

}
