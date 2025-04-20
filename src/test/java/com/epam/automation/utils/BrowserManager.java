package com.epam.automation.utils;

import org.apache.logging.log4j.ThreadContext;

public class BrowserManager {
    private static final ThreadLocal<String> browser = new ThreadLocal<>();

    public static void setBrowser(String browser) {
        BrowserManager.browser.set(browser);
        ThreadContext.put("browser", browser.toUpperCase());
    }

    public static String getBrowser() {
        return BrowserManager.browser.get();
    }

    public static void removeBrowser() {
        browser.remove();
        ThreadContext.remove("browser");
    }
}
