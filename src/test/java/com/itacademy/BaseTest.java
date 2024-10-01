package com.itacademy;

import com.itacademy.listeners.TestNGListener;
import com.itacademy.utils.DriverManager;
import com.itacademy.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

@Listeners (TestNGListener.class)

public class BaseTest {

    protected WebDriver driver;

    @AfterMethod
    public void quitDriver() {
        ScreenshotUtils.makeScreenshot();
        DriverManager.getDriver().quit();

    }
}
