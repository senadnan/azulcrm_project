Feature: User should be able to delete messages after sending.

  Background:
    Given User goes to the login page
    Then User login to the application successfully


  Scenario: User should be able to delete messages after sending.
    When User searches the message that he wants to delete
    Then User clicks the MORE button at the bottom of that message
    And  User clicks the Delete link
    And  User clicks the OK button on the pop up window
    And User sees "The post has been deleted." message on the window