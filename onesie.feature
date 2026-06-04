Feature: SauceDemo shopping cart

  Scenario: Add Sauce Labs Onesie product to cart
    Given the user opens the SauceDemo website
    When the user logs in with visual_user credentials
    And the user opens the "Sauce Labs Onesie" product
    And the user adds the product to the cart
    And the user opens the cart
    Then the cart should contain the "Sauce Labs Onesie" product