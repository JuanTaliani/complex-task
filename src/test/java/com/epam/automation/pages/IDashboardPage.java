package com.epam.automation.pages;

/**
 * Interface that defines the contract for the Dashboard Page.
 * <p>
 * This interface is responsible for abstracting actions and elements
 * available on the dashboard page
 * </p>
 */
public interface IDashboardPage {
    /**
     * Retrieves the title text displayed on the dashboard page.
     *
     * @return the dashboard title as a {@link String}
     */
    String getDashboardTitle();
}
