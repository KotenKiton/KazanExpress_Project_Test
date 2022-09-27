package ru.kazanexpress.tests.web.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
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
    @DisplayName("проверка заголовка страницы 'Электроника'")
    void headerElectronicsTest() {
        step("Нажать на кнопку 'Электроника' на главной странице", () -> {
            $(byLinkText("Электроника")).click(); // 1. СЕЛИНУМ ИДЕ ВЗЯЛ. НЕ разобрался с селекторами.
            $("[data-test-id=text__title]").shouldHave(text("Электроника"));
        });
    }

    @ValueSource(strings = {
            "Iphone",
            "Apple Watch"
    })
    @ParameterizedTest(name = "Проверка строки поиска (вводное значение {0}) ")
    void texPortSearchTests(String testData) {
        open("");
        $("[data-test-id=input__search]").click();
        $("[data-test-id=input__search]").setValue(testData);
        $("[data-test-id=button__search]").click();
//        //ождиаемый результат
//        $$("")
//                .find(Condition.text(testData))
//                .shouldBe(visible);
    }


}
