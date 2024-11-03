Feature: Login Negatif

  Scenario: Login dengan Username dan Password salah
    Given Go to the login page
    When Enter the wrong Username
    And Enter the wrong Password
    And Click the login button
    Then showing error message Username and password do not match

  Scenario: Login dengan Username kosong
    Given Go to the login page
    When Leave the Username blank
    And Enter the valid Password
    And Click the login button
    Then showing error message Username is required

    Scenario: Login dengan Password kosong
      Given Go to the login page
      When Enter the valid Username
      And  Leave the Password blank
      And Click the login button
      Then showing error message Password is required
