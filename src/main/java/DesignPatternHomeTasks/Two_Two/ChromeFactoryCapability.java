package DesignPatternHomeTasks.Two_Two;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactoryCapability {
    private WebDriver driver;

    public ChromeFactoryCapability() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // Example capability
       // options.addArguments("--headless"); // Example capability
        driver = new ChromeDriver(options);
        System.out.println("Chrome Driver with Custom Capabilities initialized.");
    }

    public WebDriver getDriver() {
        return driver;
    }
}

