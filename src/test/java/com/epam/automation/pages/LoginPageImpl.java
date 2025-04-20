package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Implementation of the {@link ILoginPage} interface that models the login page
 * of the application.
 * <p>
 * Provides methods to interact with login fields, perform the login action, and retrieve error messages.
 * </p>
 */
public class LoginPageImpl extends BasePage implements ILoginPage {
    /** Locator for the username input field. */
    private final By usernameField;

    /** Locator for the password input field. */
    private final By passwordField;

    /** Locator for the login button. */
    private final By loginButton;

    /** Locator for the error message. */
    private final By messageError;

    /**
     * Constructs a new instance of {@code LoginPageImpl}.
     *
     * @param driver the {@link WebDriver} instance used to interact with the page
     */
    public LoginPageImpl(WebDriver driver) {
        super(driver);
        this.usernameField = new By.ByXPath("//input[@id='user-name']");
        this.passwordField = new By.ByXPath("//input[@id='password']");
        this.loginButton = new By.ByXPath("//input[@value='Login']");
        this.messageError = new By.ByXPath("//div[contains(@class, 'error')]/h3");
    }

    /**
     * Sets the username in the corresponding input field.
     *
     * @param text the username to be entered
     */
    @Override
    public void setUsername(String text) {
        set(usernameField, text);
    }

    /**
     * Sets the password in the corresponding input field.
     *
     * @param text the password to be entered
     */
    @Override
    public void setPassword(String text) {
        set(passwordField, text);
    }

    /**
     * Clears the username input field.
     */
    @Override
    public void clearUsername() {
        clear(usernameField);
    }

    /**
     * Clears the password input field.
     */
    @Override
    public void clearPassword() {
        clear(passwordField);
    }

    /**
     * Clicks the login button to perform the login.
     *
     * @return an instance of {@link IDashboardPage} representing the dashboard page
     */
    @Override
    public IDashboardPage clickLoginButton() {
        click(loginButton);
        return new DashboardPageImpl(driver);
    }

    /**
     * Retrieves the error message text displayed on the login page.
     *
     * @return the error message as a {@link String}
     */
    @Override
    public String getErrorMessage() {
        return find(messageError).getText();
    }
}
