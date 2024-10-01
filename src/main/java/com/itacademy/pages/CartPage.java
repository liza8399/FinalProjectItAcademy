package com.itacademy.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class CartPage {

    private final WebDriver driver;

    @FindBy(xpath="//span[(@class='_title_1tqn8_24')]")
    private WebElement itemTitle;

    @FindBy(xpath="//div[@class='_root_1m9xc_2']//div[@class='_value_1oots_21']")
    private WebElement priceInTheCart;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
