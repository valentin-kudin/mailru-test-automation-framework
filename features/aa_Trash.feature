@Trash
Feature: Test moving letter to/out of trash

  Scenario: Test moving one letter to trash
    Given I am on inbox page
    When I move letter to trash
    Then I see notification of moving letter to trash

  Scenario: Test moving one letter from trash to inbox
    Given I am on trash page
    When I move letter from trash to inbox
    Then I see notification of moving letter from trash to inbox
