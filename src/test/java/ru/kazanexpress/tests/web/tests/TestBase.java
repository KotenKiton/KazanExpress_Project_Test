package ru.kazanexpress.tests.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.kazanexpress.tests.web.config.RemoteConfigInterface;
import ru.kazanexpress.tests.web.config.WebConfig;
import ru.kazanexpress.tests.web.helpers.AllureAttachments;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static ru.kazanexpress.tests.api.helpers.AllureRestAssuredFilter.withCustomTemplates;

public class TestBase {

    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        RemoteConfigInterface configLogg = ConfigFactory.create(RemoteConfigInterface.class);
        WebConfig webConfig = ConfigFactory.create(WebConfig.class);

        String remoteUrlSelenoid = System.getProperty("remoteUrl", configLogg.remoteUrl());
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String browser = System.getProperty("browser", "chrome");
        String environment = System.getProperty("env",webConfig.baseUrl());

        Configuration.browserSize = browserSize;
        Configuration.browser = browser;

        Configuration.remote = remoteUrlSelenoid; // Для локально запуска это закоментить
        DesiredCapabilities capabilities = new DesiredCapabilities();// Для локально запуска это закоментить
        capabilities.setCapability("enableVNC", true);// Для локально запуска это закоментить
        capabilities.setCapability("enableVideo", true);// Для локально запуска это закоментить
        Configuration.browserCapabilities = capabilities;// Для локально запуска это закоментить

        Configuration.baseUrl = environment ;
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