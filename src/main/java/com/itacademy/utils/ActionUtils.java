package com.itacademy.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {

    public static void hoverAndClick(WebDriver driver, WebElement hoverElement, WebElement clickElement){
        Actions builder = new Actions(driver);
        builder.moveToElement(hoverElement).perform();
        builder.moveToElement(clickElement).click().perform();
    }

    public static void hover(WebDriver driver, WebElement hoverElement){
        Actions builder = new Actions(driver);
        builder.moveToElement(hoverElement).perform();
    }

    public static void scroll(WebDriver driver, WebElement scrollElement){
        Actions builder = new Actions(driver);
        builder.scrollToElement(DriverManager.getDriver().findElement(By.xpath("//*[text()='черный']")));
    }
}
