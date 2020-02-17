@Sendletter
Feature: Test send letter

  Scenario: Test sending one letter to several addressees
    Given I am on page inbox
    When I go to letter creation window
    And I fill in fields
    And I send letter
    Then I see notification that letter was sent successfully

