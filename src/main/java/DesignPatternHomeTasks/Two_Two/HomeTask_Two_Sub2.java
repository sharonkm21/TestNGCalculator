package DesignPatternHomeTasks.Two_Two;

import org.openqa.selenium.WebDriver;

public class HomeTask_Two_Sub2
{
    public static void main(String[] args)
    {
        BrowserFactory chromeFactory = new ChromeDriverFactory();
        WebDriver chromeDriver = chromeFactory.createBrowser(true);
        chromeDriver.get("https://www.google.com");
        System.out.println("Chrome with capabilities launched");

        chromeDriver.quit();
    }
}
