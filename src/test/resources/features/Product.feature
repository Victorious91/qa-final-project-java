@product
Feature: Pagina de detalii a produsului
  Ca utilizator autentificat vreau sa deschid pagina unui produs
  pentru a-i vedea numele si pretul.

  Background:
    Given I am logged in as a standard user

  @smoke
  Scenario Outline: Accesarea paginii unui produs
    When I open the product "<produs>"
    Then I should see the product page of "<produs>"
    And the product price should be "<pret>"

    Examples:
      | produs                  | pret   |
      | Sauce Labs Backpack     | $29.99 |
      | Sauce Labs Bike Light   | $9.99  |
      | Sauce Labs Bolt T-Shirt | $15.99 |

  Scenario: Intoarcerea de pe pagina produsului la lista
    When I open the product "Sauce Labs Onesie"
    And I go back to the products list
    Then I should see the products page again
