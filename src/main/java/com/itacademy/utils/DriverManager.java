package com.itacademy.utils;

import com.itacademy.enums.PropertiesValue;
import com.itacademy.listeners.SeleniumListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class DriverManager {
    private volatile static WebDriver driver;
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public synchronized static WebDriver getDriver() {
        if(threadLocal.get() == null){
            threadLocal.set(driver);
            driver = DriverFactory.createDriver(ConfigurationReader.getProperty(PropertiesValue.BROWSER));
            EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(new SeleniumListener());
            driver = decorator.decorate(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            threadLocal.set(driver);
            return driver;
        } else{
            return threadLocal.get();
        }
    }

    public static void quit(){
        driver.quit();
        threadLocal.set(null);
    }
}
