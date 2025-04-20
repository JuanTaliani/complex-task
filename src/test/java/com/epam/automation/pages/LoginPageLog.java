package com.epam.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPageLog implements ILoginPage {
    private static final Logger log = LogManager.getLogger(LoginPageLog.class);
    private final ILoginPage loginPage;

    public LoginPageLog(ILoginPage loginPage) {
        this.loginPage = loginPage;
    }


    @Override
    public void setUsername(String text) {
        log.info("Setting username: {}", text);
        loginPage.setUsername(text);
    }

    @Override
    public void setPassword(String text) {
        log.info("Setting password: ******");
        loginPage.setPassword(text);
    }

    @Override
    public void clearUsername() {
        log.info("Clearing username field");
        loginPage.clearUsername();
    }

    @Override
    public void clearPassword() {
        log.info("Clearing password field");
        loginPage.clearPassword();
    }

    @Override
    public IDashboardPage clickLoginButton() {
        log.info("Clicking login button");
        try {
            return new DashboardPageLog(loginPage.clickLoginButton());
        } catch (Exception e) {
            log.error("Error clicking login button: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public String getErrorMessage() {
        log.info("Getting error message");
        try {
            String errorMessage = loginPage.getErrorMessage();
            log.info("Error message received: {}", errorMessage);
            return errorMessage;
        } catch (Exception e) {
            log.error("Error getting error message: {}", e.getMessage());
            throw e;
        }
    }
}
