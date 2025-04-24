package com.epam.automation.utils;

import org.apache.logging.log4j.ThreadContext;

/**
 * Utility class that manages the browser type for test execution using {@link ThreadLocal}.
 * <p>
 * This class allows each thread in a parallel test execution environment to maintain
 * its own isolated browser configuration, ensuring thread safety and independence.
 * It also integrates with Log4j's {@link ThreadContext} to enrich logging context
 * by associating the current thread's browser type, enabling more informative logs.
 * </p>
 */
public class BrowserManager {
    /** Thread-local variable that stores the browser type for the current thread. */
    private static final ThreadLocal<String> browser = new ThreadLocal<>();

    /**
     * Sets the browser type for the current thread.
     * Also adds the browser name to the {@link ThreadContext} to be used in logging.
     *
     * @param browser the name of the browser (e.g., "chrome", "edge")
     */
    public static void setBrowser(String browser) {
        BrowserManager.browser.set(browser);
        ThreadContext.put("browser", browser.toUpperCase());
    }

    /**
     * Retrieves the browser type associated with the current thread.
     *
     * @return the browser name for the current thread
     */
    public static String getBrowser() {
        return BrowserManager.browser.get();
    }

    /**
     * Removes the browser type from the current thread.
     * Also clears the value from {@link ThreadContext} for logging.
     */
    public static void removeBrowser() {
        browser.remove();
        ThreadContext.remove("browser");
    }
}
