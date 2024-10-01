package com.itacademy.pages;

import com.itacademy.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    private final WebDriver driver;

    @FindBy (xpath = "//*[@class='x-button x-button_secondaryFilledWeb7184 x-button_32 _button_1xhq2_8 _item_1xhq2_13']")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@class='x-button x-button_primaryPremium x-button_32 _button_1su1z_11']")
    private WebElement searchBtn;

    @FindBy(xpath = "//*[@class='_notifyForm_1x9k4_2 _notifyBar_1h0rw_2']")
    private WebElement acceptCookiesNotification;

    @FindBy(xpath ="//*[text()='Принять']")
    private WebElement acceptCookiesBtn;

    @FindBy(xpath ="//*[@class='_input_1su1z_19 _inputShown_1su1z_43']")
    private WebElement searchInputField;

    public HomePage(WebDriver driver) {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void acceptCookies(){
        Assert.assertTrue(acceptCookiesNotification.isDisplayed());
        acceptCookiesBtn.click();
    }

    public LoginPage loginBtnClick() {
        loginBtn.click();
        return new LoginPage(DriverManager.getDriver());
    }

    public void sendKeysToSearchInputField(String product) {
        searchInputField.click();
        searchInputField.sendKeys(product);
    }

    public SearchPage searchBtnClick() {
        searchBtn.click();
        return new SearchPage(DriverManager.getDriver());
    }
}
