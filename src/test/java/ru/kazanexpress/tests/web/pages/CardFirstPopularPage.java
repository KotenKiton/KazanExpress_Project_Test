package ru.kazanexpress.tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CardFirstPopularPage {

    // locators

    // actions
    public CardFirstPopularPage openPage() {
        step("Открыть главную страницу 'https://kazanexpress.ru/'", () ->
                open(""));

        return this;
    }

    public CardFirstPopularPage addCard() {
        step("Нажать кнопку 'Добавить в корзину'", () ->
                $("[data-test-id='button__add-to-cart']").click());

        return this;

    }

    public CardFirstPopularPage confirmationPopUp() {
        step("Подтвердить добавление в корзину, в поп-ап окне", () -> {
            $(".characteristic-wrapper").click();
            $("[data-test-id='button__add-cart']").click();

        });

        return this;
    }


    public CardFirstPopularPage productIsEqualToOne() {
        step("Проверить, что в корзине отображается товар в количестве 1", () ->
                $("[data-test-id='button__cart']").shouldHave(text("1")));

        return this;
    }


}