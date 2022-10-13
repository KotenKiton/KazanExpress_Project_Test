package ru.kazanexpress.tests.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.is;
import static ru.kazanexpress.tests.api.helpers.AllureRestAssuredFilter.withCustomTemplates;
import static ru.kazanexpress.tests.api.spec.Specs.*;


public class ApiTest {


    @Test
    @DisplayName("Запрос конкретного продукта \"Велосипедки\"")
    void requestProductIdTest() {
        given()
                .spec(request)
                .filter(withCustomTemplates())
                .when()
                .log().all()
                .get("/v2/product/250186")
                .then()
                .log().all()
                .spec(responseSpec200)
                .body("payload.data.id", is(250186))
                .body("payload.data.title", is("Велосипедки женские, шорты спортивные"));
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    void addProduct() {

        given()
                .spec(request)
                .filter(withCustomTemplates())
                .get("/v2/product/1252204")
                .then()
                .spec(responseSpec200)
                .log().body();
        // дописать
    }

    @Test
    @DisplayName("Успешная авторизация")
    void successfulAuthorization() {

        given()
                .spec(request)
                .filter(withCustomTemplates())
                .when()
                .post("/oauth/token")
                .then()
                .spec(responseSpec401)
                .log();
        // дописать

    }

    @Test
    @DisplayName("Неудачная авторизация")
    void unsuccessfulAuthorization() {
      given()
                .spec(request)
                .filter(withCustomTemplates())
                .when()
                .post("/oauth/token")
                .then()
                .spec(responseSpec401)
                .log().body();
        // дописать

    }

}

