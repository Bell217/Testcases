Feature: Cart functionality

  Scenario: Add product to cart
    Given I am logged into SauceDemo
    When I add first product to cart
    Then cart badge should show "1"