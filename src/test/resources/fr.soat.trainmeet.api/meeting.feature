Feature: Meeting management

  Scenario: Organize meeting
    Given a meeting with name "Sign the contract"
    And the description is "the purpose of the meeting is to sign your new contract"
    And the meeting first potential date is "22-09-2022"
    And the last potential date is "30-09-2022"
    And today is "20-09-2022"
    When the meeting is organized
    Then the meeting is created with properties
      | name               | Sign the contract                                      |
      | description        | the purpose of the meeting is to sign you new contract |
      | firstPotentialDate | 22-09-2022                                             |
      | lastPotentialDate  | 30-09-2022                                             |

