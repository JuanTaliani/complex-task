package com.epam.automation.drivers;

import org.openqa.selenium.WebDriver;

/**
 * A factory interface for creating {@link WebDriver} instances.
 * <p>
 * Implementations of this interface are responsible for providing
 * configured instances of WebDriver, depending on the desired browser type
 * or other custom configurations.
 * </p>
 */
public interface DriverFactory {

    /**
     * Creates and returns a new instance of {@link WebDriver}.
     *
     * @return a newly created WebDriver instance
     */
    WebDriver createDriver();
}
