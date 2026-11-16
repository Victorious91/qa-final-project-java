package com.Victorious91.tests.stepdefinitions;

import com.Victorious91.tests.pages.CartPage;
import com.Victorious91.tests.pages.CheckoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    private final CartPage cartPage = new CartPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        cartPage.checkout();
    }

    @When("I fill in the checkout information:")
    public void iFillInTheCheckoutInformation(DataTable table) {
        checkoutPage.fillInformation(table.asMap(String.class, String.class));
    }

    @When("I continue to the order overview")
    public void iContinueToTheOrderOverview() {
        checkoutPage.continueToOverview();
    }

    @Then("I should see the order overview")
    public void iShouldSeeTheOrderOverview() {
        checkoutPage.shouldShowOverview();
    }

    @When("I finish the order")
    public void iFinishTheOrder() {
        checkoutPage.finishOrder();
    }

    @Then("I should see the order confirmation {string}")
    public void iShouldSeeTheOrderConfirmation(String message) {
        checkoutPage.shouldShowConfirmation(message);
    }

    @Then("I should see the checkout error {string}")
    public void iShouldSeeTheCheckoutError(String message) {
        checkoutPage.shouldShowError(message);
    }
}
