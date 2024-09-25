package DesignPatternHomeTasks.Two_Two;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxFactoryCapability
{
    private WebDriver driver;

    public FireFoxFactoryCapability() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless"); // Example capability
        driver = new FirefoxDriver(options);
        System.out.println("Firefox Driver with Custom Capabilities initialized.");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
