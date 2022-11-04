Feature:Log out Function
  As a user, I should be able to log out

  Background:
    Given User goes to the login page
    Then User login to the application successfully

  @AZUL-1549
  Scenario: The user can log out the application and ends up on the login page.
    When User logs out the application
    Then User ends up on the login page
    And Verify title is "Authorization"

  @AZUL-1550
  Scenario: The user can not go to the home page by clicking the step back button after successfully logging out.
    When User logs out the application
    Then User ends up on the login page
    And Verify title is "Authorization"
    And User clicks step back button
    And Verify title is "Authorization"

  @AZUL-1551
  Scenario: The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)
    When User closes the opened tab
    And  User opens a new browser and goes to login page
    And  Verify title is "Authorization" (user should NOT be able to go back home page)

  @AZUL-1552
  Scenario: Verify that users can log out when they close current tab(s)
    When User opens multiple tabs
    And  User closes the tab that application is running
    And  User goes to login page on another tab
    And Verify title is "Authorization" (user should NOT be able to go back home page)
