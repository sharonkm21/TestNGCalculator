package DesignPatternHomeTasks.Two_One;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IEEdgeFactory
{
    private WebDriver driver;

    public IEEdgeFactory() {
        // Setup IEDriver using WebDriverManager
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        System.out.println("IE Driver initialized.");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
