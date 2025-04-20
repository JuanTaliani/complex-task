package com.epam.automation.steps;

import com.epam.automation.drivers.DriverProvider;
import com.epam.automation.pages.*;
import com.epam.automation.utils.BrowserManager;
import com.epam.automation.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Step definition class for Login feature in the automation test.
 * <p>
 * Contains the steps required to execute login tests, including navigation,
 * setting input values, clearing input field, clicking buttons, and verifying results.
 * </p>
 * <p>
 * This class utilizes Cucumber step annotations to map feature steps to code execution.
 * </p>
 */
public class LoginStepDefinition {
    /** Logger instance for logging test environment setup and tear down, and assertion results. */
    private static final Logger log = LogManager.getLogger();

    /** URL of the login page */
    private static final String url = "https://www.saucedemo.com";

    /** The WebDriver instance used to interact with the browser. */
    private WebDriver driver;

    /** Instance of the login page interface to interact with login elements. */
    private ILoginPage loginPage;

    /** Instance of the dashboard page interface to interact with dashboard elements. */
    private IDashboardPage dashboardPage;

    /**
     * Setup method to initialize the WebDriver and login page elements before each scenario.
     * <p>
     * This method configures the browser driver, sets up the login page object,
     * and logs the environment setup.
     * </p>
     */
    @Before
    public void setUp() {
        String browser = BrowserManager.getBrowser();
        log.info("Setting up test environment");
        driver = DriverProvider.getDriver(browser);
        loginPage = new LoginPageLog(new LoginPageImpl(driver));
        log.info("Test environment set up completed successfully");
    }

    /**
     * Takes a screenshot if a step fails during the scenario execution.
     * <p>
     * This method captures a screenshot of the current page after each step
     * if the scenario has failed and logs the result.
     * </p>
     *
     * @param scenario the Cucumber scenario that contains the step result.
     */
    @AfterStep
    public void takeScreenshotOnFailedResult(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.takeScreenshot(driver, scenario);
        }
    }

    /**
     * Tear down method to close the WebDriver and perform clean-up after each scenario.
     * <p>
     * This method terminates the WebDriver instance and logs the environment tear down.
     * </p>
     */
    @After
    public void tearDown() {
        log.info("Tearing down test environment");
        if (driver != null) {
            driver.quit();
            log.info("WebDriver closed successfully");
        }
    }

    /**
     * Navigates to the login page of the application.
     * <p>
     * This method accesses the login page URL to initiate the login flow.
     * </p>
     */
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        log.info("Navigating to: {}", url);
        driver.get(url);
    }

    /**
     * Enters the provided username into the login page's username field.
     *
     * @param username the username to be entered.
     */
    @When("I enter the username {string}")
    public void i_enter_the_username(String username) {
        loginPage.setUsername(username);
    }

    /**
     * Enters the provided password into the login page's password field.
     *
     * @param password the password to be entered.
     */
    @And("I enter the password {string}")
    public void i_enter_the_password(String password) {
        loginPage.setPassword(password);
    }

    /**
     * Clears the username field on the login page.
     */
    @And("I clear the username field")
    public void i_clear_the_username_field() {
        loginPage.clearUsername();
    }

    /**
     * Clears the password field on the login page.
     */
    @And("I clear the password field")
    public void i_clear_the_password_field() {
        loginPage.clearPassword();
    }

    /**
     * Clicks the login button to perform the login.
     */
    @And("I click the login button")
    public void i_click_the_login_button() {
        this.dashboardPage = loginPage.clickLoginButton();
    }

    /**
     * Verifies that the expected error message is displayed after an unsuccessful login.
     *
     * @param errorMessage the expected error message of the login page.
     */
    @Then("I should see the error message {string}")
    public void i_should_see_the_error_message(String errorMessage) {
        log.info("Verifying error message: {}", errorMessage);
        try {
            assertThat(loginPage.getErrorMessage(), is(equalTo(errorMessage)));
            log.info("Assertion passed: Error message matches expected");
        } catch (AssertionError e) {
            log.error("Assertion failed: {}", e.getMessage());
        }
    }

    /**
     * Verifies that the expected dashboard title is displayed after a successful login.
     *
     * @param dashboardTitle the expected title of the dashboard page.
     */
    @Then("I should see the dashboard title {string}")
    public void i_should_see_the_dashboard_title(String dashboardTitle) {
        log.info("Verifying dashboard title: {}", dashboardTitle);
        try {
            assertThat(dashboardPage.getDashboardTitle(), is(equalTo(dashboardTitle)));
            log.info("Assertion passed: Dashboard title matches expected");
        } catch (AssertionError e) {
            log.error("Assertion failed: {}", e.getMessage());
        }
    }
}
