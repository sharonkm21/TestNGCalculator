package DesignPatternHomeTasks.Two_Two;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxFactory
{
    private WebDriver driver;

    public FireFoxFactory() {
        // Setup FirefoxDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.out.println("Firefox Driver initialized.");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
