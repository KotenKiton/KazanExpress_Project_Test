package ru.kazanexpress.tests.web.tests;


import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kazanexpress.tests.web.config.WebConfig;
import ru.kazanexpress.tests.web.pages.AutorizationFormPage;
import ru.kazanexpress.tests.web.pages.MainPage;

@Tag("ui")
public class AuthFormTest extends TestBase {

    MainPage mainPage = new MainPage();
    AutorizationFormPage autorizationFormPage = new AutorizationFormPage();
    WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    String userLogin = webConfig.userLogin();
    String userPassword = webConfig.userPassword();

    private String buttonAuthName = "Вход";
    private String UserName = "KotenKiton";

    @Test
    @DisplayName("Тест формы авторизации")
    void authPageTest() {
        mainPage
                .openPage();
        autorizationFormPage
                .authButtonClick(buttonAuthName)
                .setLoginField(userLogin)
                .setPasswordField(userPassword)
                .clickEnterButton()

                .assertUserAuth(UserName);
    }
}
