package com.epam.automation.drivers;

import com.epam.automation.utils.DisplayUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverFactory implements DriverFactory {
    @Override
    public WebDriver createDriver() {
        EdgeOptions options = new EdgeOptions();

        int halfWidth = DisplayUtils.getScreenWidth() / 2;
        int height = DisplayUtils.getScreenHeight();

        options.addArguments("--window-position=" + halfWidth + ",0");
        options.addArguments("--window-size=" + halfWidth + "," + height);

        String driverPath = System.getProperty("user.dir") +
                "/src/test/resources/drivers/msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", driverPath);

        return new EdgeDriver(options);
    }
}
