Feature: SauceDemo Login Validation

  Scenario Outline: Login validation with different credentials
    Given User is on login page
    When User enters username "<username>" and password "<password>"
    And User clicks Login button
    Then User should see message "<errorMessage>"

    Examples:
      | username      | password   | errorMessage                                             |
      |               |            | Epic sadface: Username is required                       |
      | error-user    |            | Epic sadface: Password is required                       |
      | visual_user   | hello      | Epic sadface: Username and password do not match any user |
      | hello         | hello      | Epic sadface: Username and password do not match any user |