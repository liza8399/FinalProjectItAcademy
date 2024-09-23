package com.itacademy.utils;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {

        static final Logger LOGGER = LogManager.getLogger(com.itacademy.utils.ScreenshotUtils.class);

        @Attachment(value = "Page screenshot", type = "image/png")
        public static byte[] makeScreenshot(){
            return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        }
}
