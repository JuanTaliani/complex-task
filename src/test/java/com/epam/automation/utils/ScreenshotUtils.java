package com.epam.automation.utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ScreenshotUtils {
    private static final Logger log = LogManager.getLogger(ScreenshotUtils.class);

    public static void takeScreenshot(WebDriver driver, Scenario scenario) {
        try {
            File capture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String screenshotPath = System.getProperty("user.dir").replaceAll("\\\\","/") +
                    "/screenshots/" +
                    getCurrentTimeAsString() + "_" +
                    BrowserManager.getBrowser() + "_" +
                    toPascalCase(scenario.getName()) + ".png";
            File destination = new File(screenshotPath);

            FileUtils.copyFile(capture, destination);
            log.info("Screenshot saved successfully to: {}", screenshotPath);
        } catch (IOException e) {
            log.error("Failed to capture screenshot: {}", e.getMessage());
        }
    }

    public static String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuuMMdd-HHmmss");
        return ZonedDateTime.now().format(formatter);
    }

    public static String toPascalCase(String text) {
        return Arrays.stream(text.split("\\s"))
                .map(word -> word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining());
    }
}
