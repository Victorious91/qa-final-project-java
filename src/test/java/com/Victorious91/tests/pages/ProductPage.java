package com.Victorious91.tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    // Selectori saucedemo.com (structura cunoscuta a site-ului - ajusteaza daca e cazul)
    private final SelenideElement productName = $("[data-test='inventory-item-name'], .inventory_details_name");
    private final SelenideElement productPrice = $("[data-test='inventory-item-price'], .inventory_details_price");
    private final SelenideElement backButton = $("[data-test='back-to-products'], #back-to-products");

    public void shouldShowName(String expectedName) {
        productName.shouldBe(visible).shouldHave(exactText(expectedName));
    }

    public void shouldShowPrice(String expectedPrice) {
        productPrice.shouldBe(visible).shouldHave(exactText(expectedPrice));
    }

    public void backToProducts() {
        backButton.click();
    }
}
