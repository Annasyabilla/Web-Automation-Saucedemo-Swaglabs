Feature: Cart

  Scenario: Add to cart
    Given User login
    When Click the add to cart button on the first product
    And Click the add to cart button on the second product
    Then The cart icon is marked with a cart badge into 2
