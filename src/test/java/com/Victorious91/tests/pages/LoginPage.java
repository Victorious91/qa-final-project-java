package com.Victorious91.tests.pages;

import com.Victorious91.tests.config.TestConfig;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    // Selectori saucedemo.com (structura cunoscuta a site-ului - ajusteaza daca e cazul)
    private final SelenideElement usernameInput = $("#user-name");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorMessage = $("[data-test='error']");

    public LoginPage openPage() {
        open(TestConfig.baseUrl());
        usernameInput.shouldBe(visible);
        return this;
    }

    public void loginAs(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }

    public void shouldShowError(String expectedMessage) {
        errorMessage.shouldBe(visible).shouldHave(text(expectedMessage));
    }

    public boolean isLoginFormDisplayed() {
        return usernameInput.is(visible) && passwordInput.is(visible) && loginButton.is(visible);
    }
}
