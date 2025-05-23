package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Implementation of the {@link ILoginPage} interface that models the login page
 * of the application.
 * <p>
 * Provides methods to interact with login fields, perform the login action, and
 * retrieve error messages.
 * </p>
 */
public class LoginPage extends BasePage {
    /** Locator for the username input field. */
    private final By usernameField = new By.ByXPath("//input[@id='user-name']");

    /** Locator for the password input field. */
    private final By passwordField = new By.ByXPath("//input[@id='password']");

    /** Locator for the login button. */
    private final By loginButton = new By.ByXPath("//input[@value='Login']");

    /** Locator for the error message. */
    private final By messageError = new By.ByXPath("//div[contains(@class, 'error')]/h3");

    /**
     * Constructs a new instance of {@code LoginPageImpl}.
     *
     * @param driver the {@link WebDriver} instance used to interact with the page
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sets the username in the corresponding input field.
     *
     * @param text the username to be entered
     */
    public void setUsername(String text) {
        sendText(usernameField, text);
    }

    /**
     * Sets the password in the corresponding input field.
     *
     * @param text the password to be entered
     */
    public void setPassword(String text) {
        sendText(passwordField, text);
    }

    /**
     * Clears the username input field.
     */
    public void clearUsername() {
        clear(usernameField);
    }

    /**
     * Clears the password input field.
     */
    public void clearPassword() {
        clear(passwordField);
    }

    /**
     * Clicks the login button to perform the login.
     *
     * @return an instance of {@link DashboardPage} representing the dashboard page
     */
    public DashboardPage clickLoginButton() {
        click(loginButton);
        return new DashboardPage(driver);
    }

    /**
     * Retrieves the error message text displayed on the login page.
     *
     * @return the error message as a {@link String}
     */
    public String getErrorMessage() {
        return find(messageError).getText();
    }
}
