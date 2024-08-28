@Login
Feature: Validate login API

  Scenario: To extract access token from login API
    Given the login API
    When user credentials are provided to login API
    Then access token is extracted from the response