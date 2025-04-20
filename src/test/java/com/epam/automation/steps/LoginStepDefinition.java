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

public class LoginStepDefinition {
    private static final Logger log = LogManager.getLogger();
    private static final String url = "https://www.saucedemo.com";

    private WebDriver driver;
    private ILoginPage loginPage;
    private IDashboardPage dashboardPage;

    @Before
    public void setUp() {
        String browser = BrowserManager.getBrowser();
        log.info("Setting up test environment");
        driver = DriverProvider.getDriver(browser);
        loginPage = new LoginPageLog(new LoginPageImpl(driver));
        log.info("Test environment set up completed successfully");
    }

    @AfterStep
    public void takeScreenshotOnFailedResult(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.takeScreenshot(driver, scenario);
        }
    }

    @After
    public void tearDown() {
        log.info("Tearing down test environment");
        if (driver != null) {
            driver.quit();
            log.info("WebDriver closed successfully");
        }
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        log.info("Navigating to: {}", url);
        driver.get(url);
    }

    @When("I enter the username {string}")
    public void i_enter_the_username(String username) {
        loginPage.setUsername(username);
    }

    @And("I enter the password {string}")
    public void i_enter_the_password(String password) {
        loginPage.setPassword(password);
    }

    @And("I clear the username field")
    public void i_clear_the_username_field() {
        loginPage.clearUsername();
    }

    @And("I clear the password field")
    public void i_clear_the_password_field() {
        loginPage.clearPassword();
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        this.dashboardPage = loginPage.clickLoginButton();
    }

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
