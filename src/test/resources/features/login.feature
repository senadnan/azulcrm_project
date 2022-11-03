@Regression
Feature: Login functionality

  Background:
    Given User goes to the login page

  @AZUL-1419
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
      | marketing80@cybertekschool.com  | UserUser |
      | marketing90@cybertekschool.com  | UserUser |
      | marketing100@cybertekschool.com | UserUser |

  @AZUL-1421
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

  @AZUL-1422
  Scenario: Please fill out this field" message should be displayed if the password or username is empty
    When User enters email ""
    And User enters password ""
    And User clicks login button
    Then User should see "Please fill out this field" message

  @AZUL-1423
  Scenario: User land on the ‘Get Password’ page after clicking on the "Forgot your password?" link
    When User Clicks "Forgot your password?" link
    Then User should lands on the "Get Password" page

  @AZUL-1424
  Scenario: User can see "Remember Me" link exists and is clickable on the login page
    When User is on the login page
    Then User should see "Remember me on this computer" link exists and is clickable

  @AZUL-1425
  Scenario: User should see the password in bullet signs by default
    When User enters password "UserUser" into the password input box
    Then User should see password in bullet signs by default

  @AZUL-1426
  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
    When User enters valid email "helpdesk1@cybertekschool.com" in to the login input box
    And User enter valid password "UserUser" in to the password input box
    And User hits the ENTER key of the keyboard to login the application
    Then Enter key is should be worked

  @AZUL-1427
  Scenario Outline:All users can see their own usernames in the profile menu, after successful login
    When User enters valid email "<email>" in to the login input box
    And User enter valid password "<password>" in to the password input box
    And User clicks login button
    Then User should see his own profileName "<profileName>" in the profile menu, after successful login

    Examples: valid username and passwords for HELPDESK users
      | email                        | password | profileName                  |
      | helpdesk5@cybertekschool.com | UserUser | helpdesk5@cybertekschool.com |
      | helpdesk7@cybertekschool.com | UserUser | helpdesk7@cybertekschool.com |
      | helpdesk9@cybertekschool.com | UserUser | helpdesk9@cybertekschool.com |

    Examples: valid username and passwords for HR users
      | email                   | password | profileName             |
      | hr15@cybertekschool.com | UserUser | hr15@cybertekschool.com |
      | hr20@cybertekschool.com | UserUser | hr20@cybertekschool.com |
      | hr25@cybertekschool.com | UserUser | hr25@cybertekschool.com |

    Examples: valid username and passwords for MARKETING users
      | email                          | password | profileName                    |
      | marketing85@cybertekschool.com | UserUser | marketing85@cybertekschool.com |
      | marketing86@cybertekschool.com | UserUser | marketing86@cybertekschool.com |
      | marketing87@cybertekschool.com | UserUser | marketing87@cybertekschool.com |






