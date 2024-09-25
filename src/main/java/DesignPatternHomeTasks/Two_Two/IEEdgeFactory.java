package DesignPatternHomeTasks.Two_Two;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
