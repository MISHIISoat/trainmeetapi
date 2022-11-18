Feature: Meeting management

  Scenario: Create meeting
    Given a meeting with name "Sign the contract"
    And the description is "the purpose of the meeting is to sign your new contract"
    And the meeting first potential date is "22-09-2022"
    And the last potential date is "30-09-2022"
    And a sender with email "sender@email.com" that have account
    And a receiver with email "receiver@email.com" that have account
    And today is "20-09-2022"
    When the sender try to create meeting
    Then the meeting should be created
