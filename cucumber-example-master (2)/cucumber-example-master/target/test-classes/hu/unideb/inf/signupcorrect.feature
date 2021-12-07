Feature: Testing Sign up

  Background:
    Given the home page is opened
    And the sign in button is clicked for registration

    Scenario:
      Given the email address field is filled with correct email "goodemail@mail.com"
      When the create an account button is clicked with correct email
      And the register button is clicked with the fields empty
      Then a "There are 8 errors" list of errors is shown
