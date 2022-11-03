package ru.kazanexpress.tests.web.pages;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPage {

    public MainPage openPage() {
        step("Открыть главную страницу", () ->
                open(""));

        return this;
    }
}
