package com.itacademy.pages;

import com.itacademy.utils.DriverManager;
import com.itacademy.utils.JSExecutorUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@aria-label='Электронная почта']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*[@class='x-button x-button_primaryFilledWeb7184 x-button_56 x-button_intrinsic-width _submit_7r0bx_31']")
    private WebElement submitButton;

    @FindBy(xpath="//*[@class='_header_te5k7_2']")
    private WebElement loginPageTitle;

    @FindBy(xpath="//*[@class='_message_11do5_46']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void checkLoginPageTitle(){
        Assert.assertEquals(loginPageTitle.getText(),"Добро пожаловать в Lamoda");
    }

    public void sendEmailKeysToEmailField(String email) {
        emailInputField.click();
        emailInputField.sendKeys(email);
    }

    public void sendPasswordKeysToPasswordField(String password) {
        JSExecutorUtils.click(DriverManager.getDriver(), passwordInputField);
        passwordInputField.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }





}

