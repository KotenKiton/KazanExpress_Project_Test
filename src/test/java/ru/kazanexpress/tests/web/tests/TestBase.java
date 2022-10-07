package ru.kazanexpress.tests.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.kazanexpress.tests.web.helpers.AllureAttachments;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static ru.kazanexpress.tests.api.helpers.AllureRestAssuredFilter.withCustomTemplates;


public class TestBase {

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://kazanexpress.ru/";
        RestAssured.baseURI = "https://kazanexpress.ru/";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        RestAssured.filters(withCustomTemplates());

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        //CredentialsConfig configLogg = ConfigFactory.create(CredentialsConfig.class);

        //String login = configLog.login();
        // String password = configLog.password();
        String remoteUrlSelenoid = System.getProperty("remoteUrl", "selenoid.autotests.cloud/wd/hub");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String browser = System.getProperty("browser", "chrome");

        Configuration.browserSize = browserSize;
        //Configuration.remote = "https://" + login + ":" + password + "@" + remoteUrlSelenoid;
        Configuration.browser = browser;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

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