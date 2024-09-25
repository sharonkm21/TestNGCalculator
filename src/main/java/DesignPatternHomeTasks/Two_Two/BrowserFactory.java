package DesignPatternHomeTasks.Two_Two;

import org.openqa.selenium.WebDriver;

public interface BrowserFactory {
    WebDriver createBrowser(boolean withCapabilities);
}