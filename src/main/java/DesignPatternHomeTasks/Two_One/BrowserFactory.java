package DesignPatternHomeTasks.Two_One;

import org.openqa.selenium.WebDriver;

public class BrowserFactory
{
    public static WebDriver getBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            return new ChromeFactory().getDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            return new FireFoxFactory().getDriver();
        } else if (browserType.equalsIgnoreCase("ie")) {
            return new IEEdgeFactory().getDriver();
        } else {
            throw new IllegalArgumentException("Unknown browser type: " + browserType);
        }
    }
}
