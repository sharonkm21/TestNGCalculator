package DesignPatternHomeTasks.Two_Two;

import org.openqa.selenium.WebDriver;

public class ChromeDriverFactory implements BrowserFactory {
    @Override
    public WebDriver createBrowser(boolean withCapabilities) {
        if (withCapabilities) {
            return new ChromeFactoryCapability().getDriver();
        } else {
            return new ChromeFactory().getDriver();
        }
    }
}
