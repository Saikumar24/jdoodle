Feature: JDoodle application tests

  Scenario: User is able to successfully launch the application
    Given User launches the jdoodle application
    And User is able to view the homepage of the application

  Scenario Outline: User is able to sign up for the application
    Given User launches the jdoodle application
    And  User is able to view the login button
    When User clicks on the login button
    Then User is shown with the signup option
    And User fills in the "<EmailId>","<Name>","<Password>" in the signup page
    And User completes the signup process
    Examples:
      | EmailId             | Name  | Password |
      | saikumar@yopmail.com| Jdoodle | Jdoodle    |

  Scenario Outline: User is thrown with "This email is already registered" error while trying to sign up for the application with existing user credentials
    Given User launches the jdoodle application
    And  User is able to view the login button
    When User clicks on the login button
    Then User is shown with the signup option
    And User fills in the "<EmailId>","<Name>","<Password>" in the signup page
    And User is thrown with already registered email error message
    Examples:
      | EmailId             | Name  | Password |
      | saikumar@yopmail.com| Jdoodle | Jdoodle    |

  Scenario: User is able to run the default java program and verify the working of the java compiler
    Given User launches the jdoodle application
    And User clicks on execute button
    And User is able to see the correct response in the output screen

  Scenario: User is able to edit the editor screen and add the required text
    Given User launches the jdoodle application
    And User scrolls up to the editor screen
    And User is able to add text into the editor screen

