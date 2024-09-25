package DesignPatternHomeTasks.Two_One;

import org.openqa.selenium.WebDriver;

public class HomeTaskTwo_SubOne
{
    public static void main(String[] args) {
        // Initialize Chrome browser
        WebDriver chromeDriver = BrowserFactory.getBrowser("chrome");
        chromeDriver.get("https://www.google.com");
        System.out.println("Chrome Browser launched");

        chromeDriver.quit();
    }
}
