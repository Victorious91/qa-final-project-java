package com.Victorious91.tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InventoryPage {

    // Selectori saucedemo.com (structura cunoscuta a site-ului - ajusteaza daca e cazul)
    private final SelenideElement productList = $("[data-test='inventory-list'], .inventory_list");
    private final SelenideElement cartLink = $("[data-test='shopping-cart-link'], .shopping_cart_link");
    private final SelenideElement cartBadge = $("[data-test='shopping-cart-badge'], .shopping_cart_badge");
    private final ElementsCollection productCards = $$("[data-test='inventory-item'], .inventory_item");
    private final ElementsCollection productNames = $$("[data-test='inventory-item-name'], .inventory_item_name");

    public boolean isDisplayed() {
        return productList.is(visible);
    }

    public void shouldBeDisplayed() {
        productList.shouldBe(visible);
    }

    /** Butonul "Add to cart" apartine cardului produsului cu numele dat. */
    public void addToCart(String productName) {
        productCards.findBy(text(productName)).$("button").shouldBe(visible).click();
    }

    public void shouldShowCartBadge(String count) {
        cartBadge.shouldBe(visible).shouldHave(exactText(count));
    }

    public void openCart() {
        cartLink.click();
    }

    public void openProduct(String productName) {
        productNames.findBy(exactText(productName)).shouldBe(visible).click();
    }
}
