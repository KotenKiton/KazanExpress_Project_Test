package ru.kazanexpress.tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CardFirstPopularPage {

    // locators
    SelenideElement addCard = $("[data-test-id='button__add-to-cart']");
    SelenideElement charicWrapper = $(".characteristic-wrapper");
    SelenideElement addCardButton = $("$([data-test-id='button__add-cart']");
    SelenideElement buttonCard = $($("[data-test-id='button__cart']"));

    // actions
    public CardFirstPopularPage openPage() {
        step("Открыть главную страницу", () ->
                open(""));
//'https://kazanexpress.ru/'
        return this;
    }

    public CardFirstPopularPage addCard() {
        step("Нажать кнопку 'Добавить в корзину'", () ->
                addCard.click());

        return this;

    }

    public CardFirstPopularPage confirmationPopUp() {
        step("Подтвердить добавление в корзину, в поп-ап окне", () -> {
            charicWrapper.click();
            addCardButton.click();

        });

        return this;
    }

    public CardFirstPopularPage assertProductIsEqualToOne() {
        step("Проверить, что в корзине отображается товар в количестве 1", () ->
                buttonCard.shouldHave(text("1")));

        return this;
    }
}