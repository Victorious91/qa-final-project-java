package com.Victorious91.tests.stepdefinitions;

import com.Victorious91.tests.config.TestConfig;
import com.Victorious91.tests.pages.InventoryPage;
import com.Victorious91.tests.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();
    private final InventoryPage inventoryPage = new InventoryPage();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.openPage();
    }

    @Given("I am logged in as a standard user")
    public void iAmLoggedInAsAStandardUser() {
        loginPage.openPage().loginAs(TestConfig.validUser(), TestConfig.validPassword());
        inventoryPage.shouldBeDisplayed();
    }

    @When("I log in with valid credentials")
    public void iLogInWithValidCredentials() {
        loginPage.loginAs(TestConfig.validUser(), TestConfig.validPassword());
    }

    @When("I log in with username {string} and password {string}")
    public void iLogInWithUsernameAndPassword(String username, String password) {
        loginPage.loginAs(username, password);
    }

    @Then("I should see the products page")
    public void iShouldSeeTheProductsPage() {
        inventoryPage.shouldBeDisplayed();
    }

    @Then("I should see the login error {string}")
    public void iShouldSeeTheLoginError(String message) {
        loginPage.shouldShowError(message);
    }

    @Then("I should remain on the login page")
    public void iShouldRemainOnTheLoginPage() {
        assertTrue("Formularul de login nu mai este afisat", loginPage.isLoginFormDisplayed());
    }
}
