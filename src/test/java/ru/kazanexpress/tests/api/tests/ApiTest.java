package ru.kazanexpress.tests.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kazanexpress.tests.api.models.User;


import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.kazanexpress.tests.api.helpers.AllureRestAssuredFilter.withCustomTemplates;
import static ru.kazanexpress.tests.api.specs.Specs.*;


public class ApiTest {

    @Test
    @DisplayName("Запрос конкретного продукта \"Велосипедки\"")
    void requestProductIdTest() {
        given()
                .spec(request)
                .filter(withCustomTemplates())
                .when().log().all()
                .get("/v2/product/250186")
                .then().log().all()
                .spec(responseSpec200)
                .body("payload.data.id", is(250186))
                .body("payload.data.title", is("Велосипедки женские, шорты спортивные"));
    }

    @Test
    @DisplayName("Успешное открытие страницы \"FAQ\"")
    void faqOpenTest() {
        given()
                .spec(request)
                .filter(withCustomTemplates())
                .when().log().all()
                .get("/main/about/faq/")
                .then().log().all()
                .spec(responseSpec200)
                .statusCode(200)
                .body("payload.sections[0].items[0].title", equalTo("Как заказать?"));
    }

    @Test
    @DisplayName("Успешное открытие 'Осаго'")
    void osagoOpenTest() {
        given()
                .spec(request)
                .filter(withCustomTemplates())
                .when().log().all()
                .get("/main/promo-categories")
                .then().log().all()
                .spec(responseSpec200)
                .statusCode(200)
                .body("payload[0].title", equalTo("ОСАГО"));
    }
    @Test
    @DisplayName("Добавить товар")
    void addProduct() {

        User user = new User();
        User response = given()
                .spec(request)
                .filter(withCustomTemplates())
                .get("/v2/product/1069769")
                .then()
                .spec(responseSpec200)
                .log().body()
                .extract().as(User.class);

        assertEquals(response.getId(), user.getId());

    }
}

