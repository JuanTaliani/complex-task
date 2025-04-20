package com.epam.automation.drivers;

import com.epam.automation.utils.DisplayUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory implements DriverFactory {
    @Override
    public WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();

        int halfWidth = DisplayUtils.getScreenWidth() / 2;
        int height = DisplayUtils.getScreenHeight();

        options.addArguments("--window-position=0,0");
        options.addArguments("--window-size=" + halfWidth + "," + height);

        String driverPath = System.getProperty("user.dir") +
                "/src/test/resources/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        return new ChromeDriver(options);
    }
}
