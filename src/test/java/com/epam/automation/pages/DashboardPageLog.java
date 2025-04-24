package com.epam.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Decorator class for {@link IDashboardPage} that adds logging functionality.
 * <p>
 * Logs actions and results related to retrieving the dashboard title.
 * Useful for debugging and tracing execution in automated tests.
 * </p>
 */
public class DashboardPageLog implements IDashboardPage {
    /** Logger instance for logging dashboard page actions and outcomes. */
    private static final Logger log = LogManager.getLogger(DashboardPageLog.class);

    /** The wrapped {@link IDashboardPage} implementation. */
    private final IDashboardPage dashboardPage;

    /**
     * Constructs a new {@code DashboardPageLog} that decorates the given {@link IDashboardPage}.
     *
     * @param dashboardPage the dashboard page to decorate with logging.
     */
    public DashboardPageLog(IDashboardPage dashboardPage) {
        this.dashboardPage = dashboardPage;
    }

    /**
     * Logs and delegates the retrieval of the dashboard title.
     *
     * @return the dashboard title as a {@link String}.
     * @throws RuntimeException if the underlying call throws an exception.
     */
    @Override
    public String getDashboardTitle() {
        log.info("Getting dashboard title");
        return dashboardPage.getDashboardTitle();
    }
}
