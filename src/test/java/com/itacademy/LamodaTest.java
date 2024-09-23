package com.itacademy;

import com.itacademy.pages.HomePage;
import com.itacademy.pages.LoginPage;
import com.itacademy.utils.DriverManager;
import com.itacademy.utils.Waiters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LamodaTest extends BaseTest {

    @Test
    public void signUpTest(){
        DriverManager.getDriver().get("https://www.lamoda.by/");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.acceptCookies();
        homePage.loginBtnClick();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.checkLoginPageTitle();
        loginPage.sendEmailKeysToEmailField("123@gmail.com");
        Waiters.wait(5000);
        loginPage.sendPasswordKeysToPasswordField("123456");
        loginPage.clickSubmitButton();
        loginPage.checkErrorMessage();
    }
}
