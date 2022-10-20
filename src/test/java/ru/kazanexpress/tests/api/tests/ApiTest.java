package ru.kazanexpress.tests.api.tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kazanexpress.tests.api.models.User;
import ru.kazanexpress.tests.web.config.WebConfig;


import static io.restassured.RestAssured.given;


import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.kazanexpress.tests.api.helpers.AllureRestAssuredFilter.withCustomTemplates;
import static ru.kazanexpress.tests.api.specs.Specs.*;


public class ApiTest {

    WebConfig config = ConfigFactory.create(WebConfig.class);


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
    void addProductTest() {
        User response = given()
                .spec(request)
                .filter(withCustomTemplates())
                .when().log().all()
                .get("/v2/product/1252208")
                .then().log().all()
                .spec(responseSpec200)
                .extract().body().jsonPath().getObject("payload.data", User.class);

        assertEquals(1252208, response.getId());
        assertEquals("Монитор Xiaomi Mi Desktop Monitor 27\", черный (BHR4975EU)", response.getTitle());
    }

    @Test
    @DisplayName("Негативная проверка получения токенов(Access||Refresh)")
    void authTokensTest() {
        given()
                .spec(request)
                .formParam("grant_type", "password")
                .formParam("username", config.userLogin())
                .formParam("password", "123445")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("authorization", config.testHeaderAuthBasic())
                .when()
                .post("/oauth/token")
                .then().log().all()
                .statusCode(400)
                .body("errors[0].message", is("Bad request"));
    }

    @Test
    @DisplayName("Востановление пароля несуществующего пользователя")
    void passRecoveryNotUser() {
        given()
                .spec(request);

    }
}
