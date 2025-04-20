package com.epam.automation.pages;

/**
 * Interface that defines the contract for the Login Page.
 * <p>
 * This interface is responsible for abstracting actions and elements
 * available on the login page.
 * </p>
 */
public interface ILoginPage {
    /**
     * Sets the username in the corresponding input field.
     *
     * @param text the username to be entered
     */
    void setUsername(String text);

    /**
     * Sets the password in the corresponding input field.
     *
     * @param text the password to be entered
     */
    void setPassword(String text);

    /**
     * Clears the username input field.
     */
    void clearUsername();

    /**
     * Clears the password input field.
     */
    void clearPassword();

    /**
     * Clicks the login button to perform the login.
     *
     * @return an instance of {@link IDashboardPage} representing the dashboard page
     */
    IDashboardPage clickLoginButton();

    /**
     * Retrieves the error message displayed on the login page.
     *
     * @return the error message as a {@link String}
     */
    String getErrorMessage();
}
