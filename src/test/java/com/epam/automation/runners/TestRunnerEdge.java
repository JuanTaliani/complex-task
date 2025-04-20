package com.epam.automation.runners;

import com.epam.automation.utils.BrowserManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.epam.automation.steps",
        plugin = {"pretty"}
)
public class TestRunnerEdge {
    @BeforeClass
    public static void setUp() {
        BrowserManager.setBrowser("edge");
    }
}
