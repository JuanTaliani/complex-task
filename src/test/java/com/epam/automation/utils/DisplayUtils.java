package com.epam.automation.utils;

import java.awt.*;

/**
 * Utility class for retrieving screen display properties.
 * <p>
 * This class provides helper methods to obtain the screen width and height
 * using the {@link Toolkit}.
 * It is used to dynamically set browser window sizes during test execution.
 * </p>
 */
public class DisplayUtils {
    /** Toolkit instance used to access screen information. */
    private static final Toolkit toolkit = Toolkit.getDefaultToolkit();

    /**
     * Returns the width of the primary screen in pixels.
     *
     * @return the screen width in pixels
     */
    public static int getScreenWidth() {
        return toolkit.getScreenSize().width;
    }

    /**
     * Returns the height of the primary screen in pixels.
     *
     * @return the screen height in pixels
     */
    public static int getScreenHeight() {
        return toolkit.getScreenSize().height;
    }
}
