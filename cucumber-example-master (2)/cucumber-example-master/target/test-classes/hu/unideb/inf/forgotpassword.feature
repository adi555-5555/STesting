Feature: Testing Sign up

  Background:
    Given the home page is opened
    And the sign in button is clicked for forgot password

    Scenario:
      Given the forgot password button is clicked
      When the retrieve password button is clicked without an email
      Then a "Invalid email address." for forgot password error is shown
