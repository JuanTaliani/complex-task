package com.epam.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Abstract base class that provides common functionality for all page objects.
 * <p>
 * Encapsulates common WebDriver actions such as finding elements, setting input fields,
 * clearing fields, and clicking elements. Implements explicit wait for visibility of elements.
 * </p>
 */
public abstract class BasePage {
    /** Logger instance for logging interactions and actions within page objects. */
    protected Logger log = LogManager.getLogger(BasePage.class);

    /** The WebDriver instance used to interact with the browser. */
    protected WebDriver driver;

    /** WebDriverWait instance for applying explicit waits. */
    private final WebDriverWait wait;

    /**
     * Constructs a new BasePage instance with the specified WebDriver.
     *
     * @param driver the WebDriver instance to use
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * Finds a visible web element using the provided locator.
     *
     * @param locator the {@link By} locator to identify the element
     * @return the visible {@link WebElement}
     */
    public WebElement find(By locator) {
        log.info("Finding web element: {}", locator.toString());

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return driver.findElement(locator);
    }

    /**
     * Clears the field located by the given locator and types the specified text into it.
     *
     * @param locator the {@link By} locator of the input field
     * @param text    the text to enter
     */
    public void sendText(By locator, String text) {
        log.info("Sending text to input field {}", locator.toString());

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement element = driver.findElement(locator);
        clear(locator);
        element.sendKeys(text);
    }

    /**
     * Clears the content of the input field located by the given locator using keyboard shortcuts.
     *
     * @param locator the {@link By} locator of the input field
     */
    public void clear(By locator) {
        log.info("Clearing input field: {}", locator.toString());

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement element = driver.findElement(locator);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

    /**
     * Clicks on the element located by the given locator.
     *
     * @param locator the {@link By} locator of the element to click
     */
    public void click(By locator) {
        log.info("Clicking web element: {}", locator.toString());

        WebElement element = driver.findElement(locator);

        wait.until(ExpectedConditions.elementToBeClickable(locator));

        element.click();
    }
}
