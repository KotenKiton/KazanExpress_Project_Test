package ru.kazanexpress.tests.web.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kazanexpress.tests.web.pages.CardFirstPopularPage;
import ru.kazanexpress.tests.web.pages.MainPage;

@Tag("ui")
public class CardTest extends TestBase {

    MainPage mainPage = new MainPage();

    // Как этот mainPage( розовый) совместить с cardFirstPopulPage ?
    CardFirstPopularPage cardFirstPopularPage = new CardFirstPopularPage();

    @Test
    @DisplayName("Отображение количества товара, после добавления 1 позиции")
    void addCardTest() {

        cardFirstPopularPage
                .openPage()
                .addCard()
                .confirmationPopUp()

                //asserts
                .assertProductIsEqualToOne();
    }
}
