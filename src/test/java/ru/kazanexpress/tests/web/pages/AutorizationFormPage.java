package ru.kazanexpress.tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
public class AutorizationFormPage {

    // locators
    SelenideElement buttonAuth = $("[data-test-id=button__auth]");
    SelenideElement inputLogin = $("[data-test-id=input__login]");
    SelenideElement inputPassword = $("[data-test-id=input__password]");
    SelenideElement buttonSignIn = $("[data-test-id=button__sign-in]");
    SelenideElement buttonUser = $("[data-test-id=button__user]");
    SelenideElement headerAuthForm = $("[data-test-id=text__name-modal-base]");

    // actions
    public AutorizationFormPage authButtonClick(String enter) {
        buttonAuth.click();
        headerAuthForm.shouldHave(text(enter));

        return this;
    }

    public AutorizationFormPage setLoginField(String value) {
        inputLogin.setValue(value);

        return this;
    }

    public AutorizationFormPage setPasswordField(String value) {
        inputPassword.setValue(value);

        return this;
    }

    public AutorizationFormPage clickEnterButton() {
        buttonSignIn.click();

        return this;
    }

    public AutorizationFormPage assertUserAuth(String userName) {
        buttonUser.shouldHave(text(userName));

        return this;
    }
}
