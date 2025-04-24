package com.epam.automation.runners;

import com.epam.automation.utils.BrowserManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Cucumber test runner configured to execute scenarios using the Edge browser.
 * <p>
 * This class sets up the test environment by specifying the browser type before test execution.
 * It uses the {@code @RunWith(Cucumber.class)} annotation to run Cucumber tests
 * with the JUnit framework.
 * Configuration options include:
 * <ul>
 *     <li>{@code features} - Path to the feature files.</li>
 *     <li>{@code glue} - Location of step definition classes.</li>
 *     <li>{@code plugin} - Cucumber plugins used for output formatting.</li>
 * </ul>
 * </p>
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.epam.automation.steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports"
        }
)
public class TestRunnerEdge {

    /**
     * Sets the browser type to Edge before executing any Cucumber tests.
     * <p>
     * This method ensures the browser type is configured appropriately
     * using the {@link BrowserManager}.
     * </p>
     */
    @BeforeClass
    public static void setUp() {
        BrowserManager.setBrowser("edge");
    }
}
