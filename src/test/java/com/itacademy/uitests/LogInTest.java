package com.itacademy.uitests;


import com.itacademy.pages.LoginPage;
import com.itacademy.utils.Waiters;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @Test
    public void signInTest(){

        LoginPage loginPage = homePage.loginBtnClick();;
        loginPage.checkLoginPageTitle();
        loginPage.sendEmailKeysToEmailField("123@gmail.com");
        Waiters.wait(5000);
        loginPage.sendPasswordKeysToPasswordField("123456");
        loginPage.clickSubmitButton();
        String failedLoginErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(failedLoginErrorMessage, "Неверный логин или пароль.");
    }
}
