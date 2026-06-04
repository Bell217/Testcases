Feature: Admin login validation

  Scenario: Login without credentials shows error message
    Given user is on admin login page
    When user clicks login button without entering username and password
    Then error message "Invalid credentials" should be displayed