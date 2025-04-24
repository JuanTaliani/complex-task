package com.epam.automation.drivers;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

/**
 * Provides a configured {@link WebDriver} instance based on the specified browser type.
 * <p>
 * This class acts as a central access point for creating WebDriver instances
 * using the appropriate {@link DriverFactory} implementation.
 * Currently supported browsers:
 * <ul>
 *     <li>chrome</li>
 *     <li>edge</li>
 * </ul>
 * </p>
 */
public class DriverProvider {

    /**
     * Returns a configured {@link WebDriver} instance for the specified browser type.
     * <p>
     * The driver will be configured with an implicit wait of 5 seconds.
     * </p>
     *
     * @param browserType the type of browser to use (e.g., "chrome", "edge")
     * @return a configured WebDriver instance
     * @throws IllegalArgumentException if the browser type is not supported
     */
    public static WebDriver getDriver(String browserType) {
        DriverFactory factory;
        WebDriver driver;

        switch (browserType.toLowerCase()) {
            case "edge":
                factory = new EdgeDriverFactory();
                driver = factory.createDriver();
                break;
            case "chrome":
                factory = new ChromeDriverFactory();
                driver = factory.createDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsopported browser: " + browserType);
        }

        // Set implicit wait timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }
}
