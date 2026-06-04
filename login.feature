Feature: Login validation

  Scenario: Login without username and password
    Given the user is on the SauceDemo login page
    When the user clicks the Login button without entering credentials
    Then the error message "Epic sadface: Username is required" should be displayed