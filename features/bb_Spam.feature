@Spam
Feature: Test moving letter to/out of spam

  Scenario: Test moving one letter to spam
    Given I am on the inbox page
    When I move letter to spam
    Then I see notification of moving letter to spam

  Scenario: Test moving one letter from spam to inbox
    Given I am on spam page
    When I move letter from spam to inbox
    Then I see notification of moving letter from spam to inbox
