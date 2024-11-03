Feature: Checkout

  Scenario: Successful Checkout
    Given User login
    When Click on the cart badge
    And Click on the Check out button
    And Fill First name
    And Fill Last Name
    And Fill Postal Code
    And Click Continue
    And Click Finish
    Then User redirected to complate order page

  Scenario: Checkout Empaty Cart
    Given User back to home
    When Click on the cart badge
    And Click on the Check out button
    Then Showing error message empaty cart can not to processed

  Scenario: Leave the first name section blank
    Given leave the first name section blank
    When Fill Last Name
    And Fill Postal Code
    And Click Continue
    Then Showing error message First Name is required

  Scenario: Leave the Last name section blank
    Given Fill First name
    When  leave the last name section blank
    And Fill Postal Code
    And Click Continue
    Then Showing error message Last Name is required


  Scenario: Leave the Zip Code section blank
    Given Fill First name
    When  Fill Last Name
    And Leave the ZIP code section blank
    And Click Continue
    Then Showing error message Postal Code is required
