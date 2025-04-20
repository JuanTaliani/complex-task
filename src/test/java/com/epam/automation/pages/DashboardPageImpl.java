package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageImpl extends BasePage implements IDashboardPage {
    private final By dashboardTitle;

    public DashboardPageImpl(WebDriver driver) {
        super(driver);
        this.dashboardTitle = new By.ByXPath("//div[@class='app_logo']");
    }

    @Override
    public String getDashboardTitle() {
        return find(dashboardTitle).getText();
    }
}
