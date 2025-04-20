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

/**
 * Utility class for capturing and saving screenshots.
 * <p>
 * The class generates a timestamped and descriptive filename for each screenshot,
 * including the browser type and scenario name in PascalCase format.
 * Screenshots are saved to the /screenshots directory within the project root.
 * </p>
 */
public class ScreenshotUtils {
    /** Logger instance for logging screenshot path and errors. */
    private static final Logger log = LogManager.getLogger(ScreenshotUtils.class);

    /**
     * Captures a screenshot using the given WebDriver and saves it to a file.
     * <p>
     * The filename is composed of the current timestamp, browser name, and scenario name,
     * formatted in PascalCase.
     * </p>
     *
     * @param driver   the {@link WebDriver} used to take the screenshot
     * @param scenario the {@link Scenario} from which the name is used in the filename
     */
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

    /**
     * Returns the current system time formatted as a string.
     * <p>
     * Format used: yyyyMMdd-HHmmss
     * </p>
     *
     * @return the formatted current date and time string
     */
    public static String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuuMMdd-HHmmss");
        return ZonedDateTime.now().format(formatter);
    }

    /**
     * Converts a given string to PascalCase.
     * <p>
     * Each word in the input string will be capitalized and concatenated without spaces.
     * </p>
     *
     * @param text the string to convert
     * @return the PascalCase formatted string
     */
    public static String toPascalCase(String text) {
        return Arrays.stream(text.split("\\s"))
                .map(word -> word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining());
    }
}
