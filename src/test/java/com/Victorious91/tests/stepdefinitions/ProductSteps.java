package com.Victorious91.tests.stepdefinitions;

import com.Victorious91.tests.pages.InventoryPage;
import com.Victorious91.tests.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {

    private final InventoryPage inventoryPage = new InventoryPage();
    private final ProductPage productPage = new ProductPage();

    @When("I open the product {string}")
    public void iOpenTheProduct(String productName) {
        inventoryPage.openProduct(productName);
    }

    @Then("I should see the product page of {string}")
    public void iShouldSeeTheProductPageOf(String productName) {
        productPage.shouldShowName(productName);
    }

    @Then("the product price should be {string}")
    public void theProductPriceShouldBe(String price) {
        productPage.shouldShowPrice(price);
    }

    @When("I go back to the products list")
    public void iGoBackToTheProductsList() {
        productPage.backToProducts();
    }

    @Then("I should see the products page again")
    public void iShouldSeeTheProductsPageAgain() {
        inventoryPage.shouldBeDisplayed();
    }
}
