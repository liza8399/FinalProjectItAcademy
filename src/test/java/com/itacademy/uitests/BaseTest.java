package com.itacademy.uitests;

import com.itacademy.listeners.TestNGListener;
import com.itacademy.pages.HomePage;
import com.itacademy.utils.DriverManager;
import com.itacademy.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners (TestNGListener.class)

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverManager.getDriver().get("https://www.lamoda.by/");
        DriverManager.getDriver().manage().window().maximize();
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.acceptCookies();
    }

    @AfterMethod
    public void quitDriver() {
        ScreenshotUtils.makeScreenshot();
        DriverManager.getDriver().quit();

    }
}
