package DesignPatternHomeTasks.Two_Two;

import org.openqa.selenium.WebDriver;

public class FireFoxDriverFactory implements BrowserFactory {
    @Override
    public WebDriver createBrowser(boolean withCapabilities) {
        if (withCapabilities) {
            return new FireFoxFactoryCapability().getDriver();
        } else {
            return new FireFoxFactory().getDriver();
        }
    }
}
