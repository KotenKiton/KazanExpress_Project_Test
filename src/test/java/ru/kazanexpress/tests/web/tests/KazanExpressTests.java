package ru.kazanexpress.tests.web.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class KazanExpressTests extends TestBase {

    @Test
    @BeforeEach
    @DisplayName("Проверка 'Хэдэра' сайта на стартовой странице")
    void firstTest() {
        step("Открыть главную страницу", () -> {
            Selenide.open("");
            $$("[data-test-id=text__promo-delivery-info]").first()
                    .shouldHave(text("Доставим ваш заказ бесплатно — всего за 1 день!"));
        });
    }

    @Test
    @DisplayName("Проверка раздела 'Электроника' на стартовой странице")
    void headerElectronicsTest() {
        step("Нажать на кнопку 'Электроника' на главной странице", () -> {
            $(byLinkText("Электроника")).click(); // 1. СЕЛИНУМ ИДЕ ВЗЯЛ. НЕ разобрался с селекторами.
            $("[data-test-id=text__title]").shouldHave(text("Электроника"));
        });
    }

    @ParameterizedTest(name = "Параметризованные тесты на поиск")
    void texPortSearchTests(String testData) { // будет передано сюда!
        open("");
        //Steps
        $("#desktop_search_input").click();
        $("#desktop_search_input").setValue(testData);
        $("#desktop_search_submit svg").click();
        //ождиаемый результат
        $$(".ellip")
                .find(Condition.text(testData))
                .shouldBe(visible);
    }


}
