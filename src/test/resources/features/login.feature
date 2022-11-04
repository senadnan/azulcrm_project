@Regression
Feature: Login functionality

  Background:
    Given User goes to the login page

  @AZUL-1419 @wip
  Scenario Outline: As a user, I should be able to log in the application
    When User enters valid email "<email>" in to the login input box
    And User enter valid password "<password>" in to the password input box
    And User clicks login button
    Then User login to the application successfully and verify URL contains "stream/?login=yes"


    Examples: valid username and passwords for HELPDESK users
      | email                         | password |
      | helpdesk1@cybertekschool.com  | UserUser |
      | helpdesk10@cybertekschool.com | UserUser |
      | helpdesk20@cybertekschool.com | UserUser |


    Examples: valid username and passwords for HR users
      | email                   | password |
      | hr30@cybertekschool.com | UserUser |
      | hr40@cybertekschool.com | UserUser |
      | hr50@cybertekschool.com | UserUser |


    Examples: valid username and passwords for MARKETING users
      | email                           | password |
      | marketing52@cybertekschool.com  | UserUser |
      | marketing90@cybertekschool.com  | UserUser |
      | marketing100@cybertekschool.com | UserUser |

  @AZUL-1421 @wip
  Scenario Outline:"Incorrect login or password." should be displayed for invalid
  (valid username-invalid password and invalid username-valid password) credentials

    When User enters invalid email "<email>" and invalid password "<password>"
    And User enters invalid email "<email>" and valid password "<password>"
    And User enters valid email "<email>" and invalid password "<password>"
    And User clicks login button
    Then User should see "Incorrect login or password" message

    Examples: invalid email and invalid passwords for all type of users
      | email                  | password    |
      | abc@cybertekschool.com | asdflasdjlf |
      | senadnan82@gmail.com   | 123123      |
      | sdf123@yahoo.com       | 123asd      |

    Examples: invalid email and valid passwords for all type of users
      | email                       | password |
      | helpdesk@cybertekschool.com | UserUser |
      | helpme@cybertekschool.com   | UserUser |
      | trgo@hotmail.com            | UserUser |

    Examples: valid email and invalid passwords for all type of users
      | email                          | password    |
      | helpdesk1@cybertekschool.com   | 456123      |
      | hr50@cybertekschool.com        | sdf123sdf   |
      | marketing80@cybertekschool.com | marketing80 |

  @AZUL-1422 @wip
  Scenario: Please fill out this field" message should be displayed if the password or username is empty
    When User enters email ""
    And User enters password ""
    And User clicks login button
    Then User should see "Please fill out this field" message

  @AZUL-1423 @wip
  Scenario: User land on the ‘Get Password’ page after clicking on the "Forgot your password?" link
    When User Clicks "Forgot your password?" link
    Then User should lands on the "Get Password" page

  @AZUL-1424 @wip
  Scenario: User can see "Remember Me" link exists and is clickable on the login page
    When User is on the login page
    Then User should see "Remember me on this computer" link exists and is clickable

  @AZUL-1425 @wip
  Scenario: User should see the password in bullet signs by default
    When User enters password "UserUser" into the password input box
    Then User should see password in bullet signs by default

  @AZUL-1426 @wip
  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
    When User enters valid email "helpdesk1@cybertekschool.com" in to the login input box
    And User enter valid password "UserUser" in to the password input box
    And User hits the ENTER key of the keyboard to login the application
    Then Enter key is should be worked

  @AZUL-1427 @wip
  Scenario Outline:All users can see their own usernames in the profile menu, after successful login
    When User enters valid email "<email>" in to the login input box
    And User enter valid password "<password>" in to the password input box
    And User clicks login button
    Then User should see his own profileName "<profileName>" in the profile menu, after successful login

    Examples: username and passwords for HELPDESK users
      | email                        | password | profileName                  |
      | helpdesk5@cybertekschool.com | UserUser | helpdesk5@cybertekschool.com |
      | helpdesk7@cybertekschool.com | UserUser | helpdesk7@cybertekschool.com |
      | helpdesk10@cybertekschool.com | UserUser | helpdesk10@cybertekschool.com |
      | helpdesk45@cybertekschool.com | UserUser | helpdesk45@cybertekschool.com |
      | helpdesk57@cybertekschool.com | UserUser | helpdesk57@cybertekschool.com |

    Examples: username and passwords for HR users
      | email                   | password | profileName             |
      | hr1@cybertekschool.com | UserUser | hr1@cybertekschool.com |
      | hr20@cybertekschool.com | UserUser | hr20@cybertekschool.com |
      | hr25@cybertekschool.com | UserUser | hr25@cybertekschool.com |
      | hr42@cybertekschool.com | UserUser | hr42@cybertekschool.com |
      | hr75@cybertekschool.com | UserUser | hr75@cybertekschool.com |

    Examples: username and passwords for MARKETING users
      | email                          | password | profileName                    |
      | marketing1@cybertekschool.com | UserUser | marketing1@cybertekschool.com |
      | marketing75@cybertekschool.com | UserUser | marketing75@cybertekschool.com |
      | marketing80@cybertekschool.com | UserUser | marketing80@cybertekschool.com |
      | marketing90@cybertekschool.com | UserUser | marketing90@cybertekschool.com |
      | marketing97@cybertekschool.com | UserUser | marketing97@cybertekschool.com |






