package ru.kazanexpress.tests.web.config;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/user.properties"
})
public interface WebConfig extends Config {

    String userLogin();

    String userPassword();

    String testHeaderAuthBasic(); // без этого не работает

    String baseUrl();
}
