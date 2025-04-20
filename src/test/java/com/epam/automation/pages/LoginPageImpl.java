package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageImpl extends BasePage implements ILoginPage {
    private final By usernameField;
    private final By passwordField;
    private final By loginButton;
    private final By messageError;

    public LoginPageImpl(WebDriver driver) {
        super(driver);
        this.usernameField = new By.ByXPath("//input[@id='user-name']");
        this.passwordField = new By.ByXPath("//input[@id='password']");
        this.loginButton = new By.ByXPath("//input[@value='Login']");
        this.messageError = new By.ByXPath("//div[contains(@class, 'error')]/h3");
    }

    @Override
    public void setUsername(String text) {
        set(usernameField, text);
    }

    @Override
    public void setPassword(String text) {
        set(passwordField, text);
    }

    @Override
    public void clearUsername() {
        clear(usernameField);
    }

    @Override
    public void clearPassword() {
        clear(passwordField);
    }

    @Override
    public IDashboardPage clickLoginButton() {
        click(loginButton);
        return new DashboardPageImpl(driver);
    }

    @Override
    public String getErrorMessage() {
        return find(messageError).getText();
    }
}
