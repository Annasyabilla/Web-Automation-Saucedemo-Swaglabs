Feature: Login Positif

  Scenario: Login dengan Username dan password yang valid
    Given Go to the login page
    When Enter the valid Username
    And Enter the valid Password
    And Click the login button
    Then user redirected to home page