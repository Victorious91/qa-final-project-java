package com.Victorious91.tests.stepdefinitions;

import com.Victorious91.tests.pages.CartPage;
import com.Victorious91.tests.pages.InventoryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {

    private final InventoryPage inventoryPage = new InventoryPage();
    private final CartPage cartPage = new CartPage();

    @When("I add the product {string} to the cart")
    public void iAddTheProductToTheCart(String productName) {
        inventoryPage.addToCart(productName);
    }

    @Then("the cart badge should show {string}")
    public void theCartBadgeShouldShow(String count) {
        inventoryPage.shouldShowCartBadge(count);
    }

    @When("I open the cart")
    public void iOpenTheCart() {
        inventoryPage.openCart();
    }

    @Then("the cart should contain the product {string}")
    public void theCartShouldContainTheProduct(String productName) {
        cartPage.shouldContainProduct(productName);
    }
}
