Feature: Inventory page

  Scenario: Products are visible after login
    Given I open SauceDemo page
    When I login with valid credentials
    Then products should be visible