package hu.unideb.inf;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CommonStepDefs extends AbstractStepDefs {

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }

}
