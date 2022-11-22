Feature: Message functionality

  User Story:
  As a user, I should be able to send messages by clicking on Message tab under Active Stream.

  Background: User is already logged in.
    Given User goes to the login page
    Then User login to the application successfully
    When User clicks MESSAGE module

@smoke
  Scenario: User should be able to send a message by filling in the mandatory fields.
    When User writes a message "text" into Message box
    Then User clicks SEND button
    And User should see the created Message on the Active Stream


  Scenario:The message delivery should be to 'All employees' by default and should be changeable.
    When User writes a message "text" into Message box
    Then All Employees button should be seen as default recipient
    And User chooses a persons "email"
#    And user clicks the Employees and departments tab
#    And user clicks a person "email" from the people list

#    And User should be able to change the recipients
#    And User is be able to search recipient in the Message Module
    And User clicks SEND button



  Scenario: Verify that users CAN NOT send message without writing message body
    And User clicks SEND button
    Then "The message title is not specified" message should be displayed


  Scenario: Verify that users CAN NOT send message without adding a Recipient
    When User writes a message "text" into Message box
    And User removes default recipient
    And User clicks SEND button
    Then An "Please specify at least one person." message should be displayed


  Scenario: User should be able to CANCEL sending messages at any time before sending.
    When User writes message into Message box
    And User add some recipients for this message
    Then User cancels sending this message







