package tests;

import common.BrowserSettings;
import listeners.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import property.PropertyManager;

import java.io.File;

public class BaseTest extends BrowserSettings {
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                startChrome();
                break;
            case "firefox":
                startFirefox();
                break;
            case "edge":
                startEdge();
                break;
            default:
                startChrome();
                System.out.println("Does not exist that browser, started Chrome.");
        }
        driver.get(PropertyManager.getInstance().getUrl());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    public WebDriver getDriver(){
        return this.driver;
    }
}
