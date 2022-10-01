package ru.kazanexpress.tests.web.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.kazanexpress.tests.web.config.WebDriverConfig;
import ru.kazanexpress.tests.web.pages.AutorizationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class UiTests extends TestBase {

    AutorizationFormPage autorizationFormPage = new AutorizationFormPage();

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
    void keSearchTest(String testData) {

        open("");
        $("[data-test-id=input__search]").setValue(testData);
        $("[data-test-id=button__search]").click();
        //ождиаемый результат
        $$("[data-test-id=text__title]")
                .find(Condition.text(testData))
                .shouldBe(visible);
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
                .shouldBe(visible);
    }

    @Test
    @DisplayName("Тест формы авторизации")
    void authPageTest() {

        autorizationFormPage
                .openPage()
                .authButtonClick()
                //.setLoginField(userLogin)
               //.setPasswordField(userPassword)
                .clickEnterButton()


                //asserts
                .assertUserAuth();

    }

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
