package ru.kazanexpress.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class UiTests {

    @Test
    @DisplayName("Отображение количества товара, после добавления 1 позиции")
    void addCardTest(){
        step("Открыть главную страницу 'https://kazanexpress.ru/'", () ->
                open(""));

        step("Нажать кнопку 'Добавить в корзину'", () ->
                $("[data-test-id='button__add-to-cart']").click());

        step("Подтвердить добавление в корзину, в поп-ап окне", () ->{
            $(".characteristic-wrapper").click();
            $("[data-test-id='button__add-cart']").click();
        });

        step("Проверить, что в корзине отображается товар в количестве 1",()->
                $("[data-test-id='button__cart']").shouldHave(text("1")));
    }
}
