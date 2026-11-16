@cart
Feature: Adaugarea produselor in cos
  Ca utilizator autentificat vreau sa adaug produse in cos
  pentru a le cumpara ulterior.

  Background:
    Given I am logged in as a standard user

  @smoke
  Scenario: Adaugarea unui produs in cos
    When I add the product "Sauce Labs Backpack" to the cart
    Then the cart badge should show "1"
    When I open the cart
    Then the cart should contain the product "Sauce Labs Backpack"

  Scenario Outline: Adaugarea mai multor produse in cos
    When I add the product "<produs>" to the cart
    And I open the cart
    Then the cart should contain the product "<produs>"

    Examples:
      | produs                  |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Onesie       |
