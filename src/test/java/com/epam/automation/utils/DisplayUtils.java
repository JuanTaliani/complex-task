package com.epam.automation.utils;

import java.awt.*;

public class DisplayUtils {
    private static final Toolkit toolkit = Toolkit.getDefaultToolkit();

    public static int getScreenWidth() {
        return toolkit.getScreenSize().width;
    }

    public static int getScreenHeight() {
        return toolkit.getScreenSize().height;
    }
}
