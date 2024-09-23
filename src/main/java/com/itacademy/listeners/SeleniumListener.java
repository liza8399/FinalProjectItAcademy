package com.itacademy.listeners;

import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

@Log4j2
public class SeleniumListener implements WebDriverListener {

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement element) {
        Allure.step(element.toString().split("->")[1] + "is found");
        log.info(element.toString().split("->")[1] + "is found");
    }

    @Override
    public void afterClick(WebElement element) {
        Allure.step(element.toString().split("->")[1] + "is clicked");
        log.info(element.toString().split("->")[1] + "is clicked");
    }

    @Override
    public void afterQuit(WebDriver driver){
        log.info("Driver quit");
    }

}
