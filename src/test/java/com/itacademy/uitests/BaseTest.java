package com.itacademy.uitests;

import com.itacademy.listeners.TestNGListener;
import com.itacademy.pages.HomePage;
import com.itacademy.utils.DriverManager;
import com.itacademy.utils.ScreenshotUtils;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners (TestNGListener.class)
@Log4j2

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        DriverManager.getDriver().get("https://www.lamoda.by/");
        DriverManager.getDriver().manage().window().maximize();
        homePage = new HomePage(DriverManager.getDriver());
        homePage.acceptCookies();
        log.info("");
    }

    @AfterMethod
    public void quitDriver() {
        ScreenshotUtils.makeScreenshot();
        DriverManager.quit();

    }
}
