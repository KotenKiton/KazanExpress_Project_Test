package ru.kazanexpress.tests.web.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutorizationFormPage {
    // locators


    // actions
    public void openPage() {
        open("");
    }

    public void authButtonClick() {
        $("[data-test-id=button__auth]").click();
        $("[data-test-id=text__name-modal-base]").shouldHave(text("Вход"));
    }

    public void setLoginField() {
        $("[data-test-id=input__login]").click();
        $("[data-test-id=input__login]").setValue("89116138904");
    }
    public void setPasswordField(){
        $("[data-test-id=input__password]").click();
        $("[data-test-id=input__password]").setValue("12345678Asdf1369");
    }
    public void clickEnterButton() {
        $("[data-test-id=button__sign-in]").click();
    }
    public void assertUserAuth() {
        $("[data-test-id=button__user]").shouldHave(text("KotenKiton"));
    }
}
