package DesignPatternHomeTasks.Two_One;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeFactory {
    private WebDriver driver;

    public ChromeFactory() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Chrome Driver initialized.");
    }

    public WebDriver getDriver() {
        return driver;
    }
}

