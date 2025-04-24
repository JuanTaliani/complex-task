package com.epam.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Decorator class for the {@link ILoginPage} that adds the logging functionality.
 * <p>
 * Logs actions and results related to the interactions with the login page.
 * Useful for debugging and tracing execution in automated tests.
 * </p>
 */
public class LoginPageLog implements ILoginPage {
    /** Logger instance for logging login page actions and outcomes. */
    private static final Logger log = LogManager.getLogger(LoginPageLog.class);

    /** The wrapped {@link ILoginPage} implementation. */
    private final ILoginPage loginPage;

    /**
     * Constructs a new {@code LoginPageLog} that decorates the given {@link ILoginPage}.
     *
     * @param loginPage the login page to decorate with logging
     */
    public LoginPageLog(ILoginPage loginPage) {
        this.loginPage = loginPage;
    }

    /**
     * Logs and delegates the action of setting the username.
     *
     * @param text the username to be entered
     */
    @Override
    public void setUsername(String text) {
        log.info("Setting username: {}", text);
        loginPage.setUsername(text);
    }

    /**
     * Logs and delegates the action of setting the password (masked in logs).
     *
     * @param text the password to be entered
     */
    @Override
    public void setPassword(String text) {
        log.info("Setting password: ******");
        loginPage.setPassword(text);
    }

    /**
     * Logs and delegates the action of clearing the username field.
     */
    @Override
    public void clearUsername() {
        log.info("Clearing username field");
        loginPage.clearUsername();
    }

    /**
     * Logs and delegates the action of clearing the password field.
     */
    @Override
    public void clearPassword() {
        log.info("Clearing password field");
        loginPage.clearPassword();
    }

    /**
     * Logs and delegates the action of clicking the login button.
     * Wraps the resulting {@link IDashboardPage} in a {@link DashboardPageLog} decorator.
     *
     * @return an instance of {@link IDashboardPage} representing the dashboard page.
     * @throws RuntimeException if the underlying call throws an exception.
     */
    @Override
    public IDashboardPage clickLoginButton() {
        log.info("Clicking login button");
        return new DashboardPageLog(loginPage.clickLoginButton());
    }

    /**
     * Logs and delegates the retrieval of the login error message.
     *
     * @return the login error message as a {@link String}.
     * @throws RuntimeException if the underlying call throws an exception.
     */
    @Override
    public String getErrorMessage() {
        log.info("Getting error message");
        return loginPage.getErrorMessage();
    }
}
