Feature: Home page check

  Scenario: Open homepage and verify URL
    Given user opens the homepage
    Then url should contain "automationintesting"