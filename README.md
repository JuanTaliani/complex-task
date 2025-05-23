# Complex Task

Launch URL: https://www.saucedemo.com/

## UC-1 Test Login form with empty credentials:

Type any credentials into "Username" and "Password" fields.
Clear the inputs.
Hit the "Login" button.
Check the error messages: "Username is required".

## UC-2 Test Login form with credentials by passing Username:

Type any credentials in username.
Enter password.
Clear the "Password" input.
Hit the "Login" button.
Check the error messages: "Password is required".

## UC-3 Test Login form with credentials by passing Username & Password:

Type credentials in username which are under Accepted username are sections.
Enter password as secret sauce.
Click on Login and validate the title “Swag Labs” in the dashboard.


**Provide parallel execution, add logging for tests and use Data Provider to parametrize tests. Make sure that all tasks are supported by these 3 conditions: UC-1; UC-2; UC-3.**

Please, add task description as README.md into your solution!

### To perform the task use the various of additional options:
- **Test Automation Tool:** Selenium WebDriver;
- **Project Builder:** Maven;
- **Browsers:** 1) Edge; 2) Chrome;
- **Locators:** XPath;
- **Test Runner:** JUnit;
- **[Optional] Patterns:** 1) Abstract Factory; 2) Adapter; 3) Decorator;
- **[Optional] Test automation approach:** BDD;
- **Assertions:** Hamcrest;
- **[Optional] Loggers:** Log4j.

NOTE: The version of the drivers used are:
- Chrome: 135.0.7049.95
- Edge: 135.0.3179.85