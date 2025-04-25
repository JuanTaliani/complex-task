package com.epam.automation.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Implementation of the {@link DriverFactory} interface that creates and configures
 * a {@link ChromeDriver} instance.
 * <p>
 * The Chrome browser window is positioned on the left half of the screen
 * and is resized to occupy half of the screen width and the full screen height.
 * The driver executable path is set dynamically based on the project directory.
 * </p>
 */
public class ChromeDriverFactory implements DriverFactory {

    /**
     * Creates and returns a configured instance of {@link ChromeDriver}.
     *
     * @return a new ChromeDriver instance with predefined window size and position
     */
    @Override
    public WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();

        // Set the path to the ChromeDriver executable
        String driverPath = System.getProperty("user.dir") +
                "/src/test/resources/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        return new ChromeDriver(options);
    }
}
