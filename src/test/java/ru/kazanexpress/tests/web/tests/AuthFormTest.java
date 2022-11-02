package ru.kazanexpress.tests.web.tests;


import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kazanexpress.tests.web.config.WebConfig;
import ru.kazanexpress.tests.web.pages.AutorizationFormPage;

@Tag("ui")
public class AuthFormTest extends TestBase {

    AutorizationFormPage autorizationFormPage = new AutorizationFormPage();
    WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    String userLogin = webConfig.userLogin();
    String userPassword = webConfig.userPassword();

    @Test
    @DisplayName("Тест формы авторизации")
    void authPageTest() {

        autorizationFormPage
                .openPage()
                .authButtonClick("Вход")
                .setLoginField(userLogin)
                .setPasswordField(userPassword)
                .clickEnterButton()

                //asserts
                .assertUserAuth("KotenKiton");
    }
}
