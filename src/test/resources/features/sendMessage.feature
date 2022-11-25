Feature: Message functionality

  User Story:
  As a user, I should be able to send messages by clicking on Message tab under Active Stream.

  Description:
  - Mandatory fields:  'Message Title'(content) & 'Recipient'.
  - Error messages for mandatory fields:
          "The message title is not specified."
          "Please specify at least one person."
  - Recipients should be selectable from "Recent", "My Groups"(enable to see this type of Recipients you need to join at least one of the groups beforehand) and "Employees and departments."
  - Recipients can be added more than one and are deletable.

  Background: User is already logged in.
    Given User goes to the login page
    Then User login to the application successfully


  Scenario: User should be able to send a message by filling in the mandatory fields.
    When User clicks MESSAGE module
    Then User writes a message "title" and "text" into Message box
    And User clicks SEND button
    And User should see the created Message Title and Message Body on the Activity Stream


  Scenario:The message delivery should be to 'All employees' by default and should be changeable.
    When User clicks MESSAGE module
    Then User writes a message "title" and "text" into Message box
    And All Employees button should be seen as default recipient
    And User removes default recipient
    And User clicks "Add persons, groups or department" link
    And User clicks "Employees and departments" link on the opened window
    And User clicks a person "email" from the people list
    And User adds a "department" from the department list
    And User clicks SEND button


  Scenario: Verify that users are able to SEARCH people that they want to send message
    When User clicks MESSAGE module
    Then User writes a message "title" and "text" into Message box
    And User removes default recipient
    And User should be able to search the recipients
    And User clicks SEND button


  Scenario: Verify that users CAN NOT send a message without writing Message TEXT
    When User clicks MESSAGE module
    Then User enters a "Message Topic"
    And User does NOT write a Message Text
    And User clicks SEND button
    Then "The message text is empty." message should be displayed


  Scenario: Verify that users SHOULD NOT be able to send a message without writing Message TOPIC and Message TEXT
    When User clicks MESSAGE module
    Then User does NOT write a Message Topic
    And User does NOT write a Message Text
    And User clicks SEND button
    Then User should see "The message title is not specified" message


  Scenario: Verify that users CAN NOT send a message without adding a Recipient
    When User clicks MESSAGE module
    And User writes a message "title" and "text" into Message box
    And User removes default recipient
    And User clicks SEND button
    Then User should be able to see  "Please specify at least one person." message


  Scenario: User should be able to CANCEL sending messages at any time before sending.
    When User clicks MESSAGE module
    And User writes a message "title" and "text" into Message box
    And User removes default recipient
    And User clicks "Add persons, groups or department" link
    And User clicks "Employees and departments" link on the opened window
    And User adds a "department" from the department list
    And User CANCELS sending this message


  Scenario: User should be able to DELETE messages after sending.
    When User searches the message that he wants to delete
    Then User clicks the MORE button at the bottom of that message
    And  User clicks the Delete link
    And  User clicks the OK button on the pop up window
    And User sees "The post has been deleted." message on the window







