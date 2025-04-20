package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Implementation of the {@link IDashboardPage} interface that models the dashboard page
 * of the application.
 * <p>
 * Provide a method to retrieve the dashboard title.
 * </p>
 */
public class DashboardPageImpl extends BasePage implements IDashboardPage {
    /** Locator for the dashboard title. */
    private final By dashboardTitle;

    /**
     * Constructs a new instance of {@code DashboardPageImpl}.
     *
     * @param driver the {@link WebDriver} instance used to interact with the page
     */
    public DashboardPageImpl(WebDriver driver) {
        super(driver);
        this.dashboardTitle = new By.ByXPath("//div[@class='app_logo']");
    }

    /**
     * Retrieves the title text displayed on the dashboard page.
     *
     * @return the dashboard title as a {@link String}
     */
    @Override
    public String getDashboardTitle() {
        return find(dashboardTitle).getText();
    }
}
