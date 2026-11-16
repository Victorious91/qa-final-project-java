@checkout
Feature: Finalizarea comenzii
  Ca utilizator autentificat vreau sa finalizez o comanda
  completand datele de livrare.

  Background:
    Given I am logged in as a standard user
    And I add the product "Sauce Labs Backpack" to the cart
    And I open the cart
    And I proceed to checkout

  @smoke
  Scenario: Comanda finalizata cu succes
    When I fill in the checkout information:
      | First Name  | Victor    |
      | Last Name   | Lucian    |
      | Postal Code | 010101    |
    And I continue to the order overview
    Then I should see the order overview
    When I finish the order
    Then I should see the order confirmation "Thank you for your order!"

  @negative
  Scenario: Checkout esuat fara codul postal
    When I fill in the checkout information:
      | First Name  | Victor |
      | Last Name   | Lucian |
      | Postal Code |        |
    And I continue to the order overview
    Then I should see the checkout error "Postal Code is required"
