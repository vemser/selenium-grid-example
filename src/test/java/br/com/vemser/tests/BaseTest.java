package br.com.vemser.tests;

import br.com.vemser.factory.selenium.BrowserService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;


public class BaseTest extends BrowserService {

    @BeforeMethod
    @Parameters("Browser")
    public void abrirNavegador(String browser) throws MalformedURLException {
        initDriver("http://www.automationpractice.pl/index.php", browser);
    }

    @AfterMethod(alwaysRun = true)
    public void fecharNavegador() {
        quit();
    }

}
