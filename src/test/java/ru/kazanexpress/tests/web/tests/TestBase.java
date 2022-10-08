package ru.kazanexpress.tests.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.kazanexpress.tests.web.helpers.AllureAttachments;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static ru.kazanexpress.tests.api.helpers.AllureRestAssuredFilter.withCustomTemplates;


public class TestBase {

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://kazanexpress.ru/";
        RestAssured.baseURI = "https://kazanexpress.ru/";
        Configuration.browserSize = "1920x1080";

        RestAssured.filters(withCustomTemplates());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterEach
    void addAttachments() {
        AllureAttachments.screenshotAs();
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
        closeWebDriver();
    }
}