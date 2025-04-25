package com.epam.automation.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 * Implementation of the {@link DriverFactory} interface that creates and configures
 * a {@link EdgeDriver} instance.
 * <p>
 * The Edge browser window is positioned on the right half of the screen
 * and is resized to occupy half of the screen width and the full screen height.
 * The driver executable path is set dynamically based on the project directory.
 * </p>
 */
public class EdgeDriverFactory implements DriverFactory {

    /**
     * Creates and returns a configured instance of {@link EdgeDriver}.
     *
     * @return a new EdgeDriver instance with predefined window size and position
     */
    @Override
    public WebDriver createDriver() {
        EdgeOptions options = new EdgeOptions();

        // Set the path to the EdgeDriver executable
        String driverPath = System.getProperty("user.dir") +
                "/src/test/resources/drivers/msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", driverPath);

        return new EdgeDriver(options);
    }
}
