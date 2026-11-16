@login
Feature: Login in aplicatia Swag Labs (saucedemo.com)
  Ca utilizator vreau sa ma autentific
  pentru a avea acces la lista de produse.

  Background:
    Given I am on the login page

  @smoke
  Scenario: Login cu credentiale valide
    When I log in with valid credentials
    Then I should see the products page

  @negative
  Scenario Outline: Login esuat cu date invalide
    When I log in with username "<username>" and password "<password>"
    Then I should see the login error "<mesaj>"
    And I should remain on the login page

    Examples:
      | username              | password     | mesaj                                                       |
      | locked_out_user       | secret_sauce | Sorry, this user has been locked out.                       |
      | standard_user         | parola_gresita | Username and password do not match any user in this service |
      | utilizator_inexistent | secret_sauce | Username and password do not match any user in this service |
      |                       | secret_sauce | Username is required                                        |
      | standard_user         |              | Password is required                                        |
