package DesignPatternHomeTasks.Two_Two;

import org.openqa.selenium.WebDriver;

public class IEEdgeDriverFactory implements BrowserFactory {
    @Override
    public WebDriver createBrowser(boolean withCapabilities) {
        if (withCapabilities) {
            return new IEEdgeFactoryCapability().getDriver();
        } else {
            return new IEEdgeFactory().getDriver();
        }
    }
}
