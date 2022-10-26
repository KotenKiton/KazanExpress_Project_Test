package ru.kazanexpress.tests.web.tests;

import com.codeborne.selenide.Condition;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.kazanexpress.tests.web.config.WebConfig;
import ru.kazanexpress.tests.web.pages.AutorizationFormPage;
import ru.kazanexpress.tests.web.pages.CardFirstPopularPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("UI")
public class UiTests extends TestBase {

    AutorizationFormPage autorizationFormPage = new AutorizationFormPage();
    CardFirstPopularPage cardFirstPopularPage = new CardFirstPopularPage();

    WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
    String userLogin = webConfig.userLogin();
    String userPassword = webConfig.userPassword();

    @Test
    @BeforeEach
    @DisplayName("Проверка 'Хэдэра' сайта на стартовой странице")
    void firstTest() {
        step("Открыть главную страницу", () -> {
            open("");
            $$("[data-test-id=text__promo-delivery-info]").first()
                    .shouldHave(text("Доставим ваш заказ бесплатно — всего за 1 день!"));
        });
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
                .setLoginField(userLogin)
                .setPasswordField(userPassword)
                .clickEnterButton()

                //asserts
                .assertUserAuth();
    }

    @Test
    @DisplayName("Отображение количества товара, после добавления 1 позиции")
    void addCardTest() {

        cardFirstPopularPage
                .openPage()
                .addCard()
                .confirmationPopUp()

                //asserts
                .productIsEqualToOne();
    }
}

