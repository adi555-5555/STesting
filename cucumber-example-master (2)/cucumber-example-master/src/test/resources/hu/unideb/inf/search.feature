Feature: Testing the Search Field

  Background:
    Given the home page is opened
    And the search field is clicked

    Scenario:
      Given the search bar is filled with "random"
      When the search button is clicked
      Then a "No results were found for your search \"random\"" search error message is shown
