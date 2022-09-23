package ru.kazanexpress.tests.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.kazanexpress.tests.mobile.helpers.AllureAttachments;
import ru.kazanexpress.tests.web.config.WebConfig;
import ru.kazanexpress.tests.web.drivers.DriverSettings;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    static WebConfig config = ConfigFactory.create(WebConfig.class);
    static String useRemote = System.getProperty("webPlatform", "local");

    @BeforeAll
    static void firstSetup() {
        DriverSettings.configuration();
        if (useRemote.equals("remote")) {
            Configuration.remote = config.remoteUrl();
        }
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEach() {
        AllureAttachments.screenshotAs();
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        if (useRemote.equals("remote")) {
            AllureAttachments.addVideo();
        }
        closeWebDriver();
    }



}