package com.epam.automation.drivers;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverProvider {
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
                throw new IllegalArgumentException("Navegador no soportado: " + browserType);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }
}
