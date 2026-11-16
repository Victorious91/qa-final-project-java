package com.Victorious91.tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    // Selectori saucedemo.com (structura cunoscuta a site-ului - ajusteaza daca e cazul)
    private final ElementsCollection cartProductNames = $$("[data-test='inventory-item-name'], .cart_item .inventory_item_name");
    private final SelenideElement checkoutButton = $("[data-test='checkout'], #checkout");

    public void shouldContainProduct(String productName) {
        cartProductNames.findBy(exactText(productName)).shouldBe(visible);
    }

    public void checkout() {
        checkoutButton.click();
    }
}
