package ru.kazanexpress.tests.web.drivers;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import ru.kazanexpress.tests.web.config.WebConfig;

public class DriverSettings {

    static WebConfig config = ConfigFactory.create(WebConfig.class);

    public static void configuration() {

        Configuration.baseUrl = config.baseUrl();
        Configuration.browserSize = config.browserSize();
        Configuration.browser = config.browserName();
        Configuration.browserVersion = config.browserVersion();
    }
}
