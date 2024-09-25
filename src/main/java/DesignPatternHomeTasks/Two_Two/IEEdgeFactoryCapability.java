package DesignPatternHomeTasks.Two_Two;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEEdgeFactoryCapability
{
    private WebDriver driver;

    public IEEdgeFactoryCapability() {
        // Setup IEDriver with custom capabilities
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.introduceFlakinessByIgnoringSecurityDomains(); // Example capability
        driver = new InternetExplorerDriver(options);
        System.out.println("IE Driver with Custom Capabilities initialized.");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
