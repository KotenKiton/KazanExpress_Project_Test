package ru.kazanexpress.tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutorizationFormPage {
    // locators
    SelenideElement buttonAuth = $("[data-test-id=button__auth]");


    // actions
    public AutorizationFormPage openPage() {
        open("");

        return this;
    }

    public AutorizationFormPage authButtonClick() {
        buttonAuth.click();
        $("[data-test-id=text__name-modal-base]").shouldHave(text("Вход"));

        return this;
    }

    public AutorizationFormPage setLoginField(String value) {
        $("[data-test-id=input__login]").setValue(value);

        return this;
    }

    public AutorizationFormPage setPasswordField(String value) {
        $("[data-test-id=input__password]").setValue(value);

        return this;
    }

    public AutorizationFormPage clickEnterButton() {
        $("[data-test-id=button__sign-in]").click();

        return this;
    }

    public AutorizationFormPage assertUserAuth() {
        $("[data-test-id=button__user]").shouldHave(text("KotenKiton"));

        return this;
    }
}
