Feature: Testing the Buy Items Feature

  Background:
    Given the home page is opened
    And the women's section tab is clicked

    Scenario:
      Given the casual dresses section is clicked
      And the printed dress is clicked
      When the add to cart for the printed dress is clicked
      Then a "Product successfully added to your shopping cart" is shown
