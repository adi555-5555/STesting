Feature: Testing Sign up with bad email

  Background:
    Given the home page is opened
    And the sign in button is clicked

    Scenario:
      Given the email address field is filled with "bademail"
      When the create an account button is clicked
      Then a "Invalid email address." signup error message is shown
