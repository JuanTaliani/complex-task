package com.epam.automation.pages;

public interface ILoginPage {
    void setUsername(String text);
    void setPassword(String text);
    void clearUsername();
    void clearPassword();
    IDashboardPage clickLoginButton();
    String getErrorMessage();
}
