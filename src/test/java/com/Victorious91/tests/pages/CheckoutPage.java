package com.Victorious91.tests.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    // Selectori saucedemo.com (structura cunoscuta a site-ului - ajusteaza daca e cazul)
    private final SelenideElement continueButton = $("[data-test='continue'], #continue");
    private final SelenideElement finishButton = $("[data-test='finish'], #finish");
    private final SelenideElement errorMessage = $("[data-test='error']");
    private final SelenideElement pageTitle = $("[data-test='title'], .title");
    private final SelenideElement confirmationHeader = $("[data-test='complete-header'], .complete-header");

    /** Cheile din Data Table: "First Name", "Last Name", "Postal Code". */
    public CheckoutPage fillInformation(Map<String, String> data) {
        // O celula goala din Data Table ajunge null; o tratam ca "camp lasat gol".
        data.forEach((label, value) -> field(label).setValue(value == null ? "" : value));
        return this;
    }

    public void continueToOverview() {
        continueButton.click();
    }

    public void shouldShowOverview() {
        pageTitle.shouldBe(visible).shouldHave(text("Checkout: Overview"));
    }

    public void finishOrder() {
        finishButton.click();
    }

    public void shouldShowConfirmation(String expectedText) {
        confirmationHeader.shouldBe(visible).shouldHave(text(expectedText));
    }

    public void shouldShowError(String expectedMessage) {
        errorMessage.shouldBe(visible).shouldHave(text(expectedMessage));
    }

    private SelenideElement field(String label) {
        return switch (label) {
            case "First Name" -> $("[data-test='firstName'], #first-name");
            case "Last Name" -> $("[data-test='lastName'], #last-name");
            case "Postal Code" -> $("[data-test='postalCode'], #postal-code");
            default -> throw new IllegalArgumentException("Camp necunoscut in Data Table: " + label);
        };
    }
}
