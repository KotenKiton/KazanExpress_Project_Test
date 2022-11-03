package ru.kazanexpress.tests.web.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("ui")
public class PageElementsTests extends TestBase {

    @Test
    @BeforeEach
    @DisplayName("Проверка 'Хэдэра' сайта на стартовой странице")
    void firstTest() {
        step("Открыть главную страницу", () ->
                open(""));
        step("Проверка 'Хэдэра'", () ->
                $$("[data-test-id=text__promo-delivery-info]").first()
                        .shouldHave(text("Доставим ваш заказ бесплатно — всего за 1 день!")));
    }

    @Test
    @DisplayName("Проверка заголовка страницы 'Электроника'")
    void headerElectronicsTest() {
        step("Открыть главную страницу", () ->
                open(""));
        step("Нажать на кнопку 'Электроника' на главной странице", () -> {
            $(byText("Электроника")).click();
            $("[data-test-id=text__title]")
                    .shouldBe(Condition.text("Электроника"),
                            Duration.ofSeconds(15));
        });
    }

    @ValueSource(strings = {
            "Iphone",
            "Apple Watch"
    })
    @ParameterizedTest(name = "Проверка строки поиска (вводное значение {0}) ")
    void keSearchTest(String testData) {

        open("");
        $("[data-test-id=input__search]").setValue(testData);
        $("[data-test-id=button__search]").click();
        $$("[data-test-id=text__title]")
                .find(Condition.text(testData))
                .shouldBe(visible, Duration.ofSeconds(15));
    }

    @CsvSource(value = {
            "Macbook | Результаты поиска по запросу \"Macbook\""
            ,
            "Ipad | Результаты поиска по запросу \"Ipad\"\n"
    },
            delimiter = '|'
    )
    @ParameterizedTest(name = "Проверка строки поиска (вводное значение {0}), ожидаем результат: {1}")
    void keSearchComplexTest(String testData, String expectedResult) {
        open("");
        $("[data-test-id=input__search]").setValue(testData);
        $("[data-test-id=button__search]").click();
        $$("[data-test-id=text__title]")
                .find(Condition.text(expectedResult))
                .shouldBe(visible, Duration.ofSeconds(15));
    }
}

