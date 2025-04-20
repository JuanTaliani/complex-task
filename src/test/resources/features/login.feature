Feature: Login Functionality

  Scenario Outline: Login with empty credentials
    Given I am on the login page
    When I enter the username "<username>"
    And I enter the password "<password>"
    And I clear the username field
    And I clear the password field
    And I click the login button
    Then I should see the error message "Epic sadface: Username is required"

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |

  Scenario Outline: Login with missing password
    Given I am on the login page
    When I enter the username "<username>"
    And I enter the password "<password>"
    And I clear the password field
    And I click the login button
    Then I should see the error message "Epic sadface: Password is required"

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |

  Scenario Outline: Login with valid credentials
    Given I am on the login page
    When I enter the username "<username>"
    And I enter the password "<password>"
    And I click the login button
    Then I should see the dashboard title "Swag Labs"

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |
