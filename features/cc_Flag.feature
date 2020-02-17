@Flag
Feature: Test Flag letters

  Scenario: Flag first three letters
    Given I am on inbox
    When I flag first three letters
    Then I see first three letters flagged

  Scenario: Unflag first three letters
    Given I am on inbox
    When I unflag first three letters
    Then I see first three letters unflagged

