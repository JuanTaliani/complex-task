package com.epam.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DashboardPageLog implements IDashboardPage {
    private static final Logger log = LogManager.getLogger(DashboardPageLog.class);
    private final IDashboardPage dashboardPage;

    public DashboardPageLog(IDashboardPage dashboardPage) {
        this.dashboardPage = dashboardPage;
    }


    @Override
    public String getDashboardTitle() {
        log.info("Getting dashboard title");
        try {
            String title = dashboardPage.getDashboardTitle();
            log.info("Dashboard title: {}", title);
            return title;
        } catch (Exception e) {
            log.error("Error getting dashboard title: {}", e.getMessage());
            throw e;
        }
    }
}
