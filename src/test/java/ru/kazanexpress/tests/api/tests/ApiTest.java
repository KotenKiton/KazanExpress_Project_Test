package ru.kazanexpress.tests.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kazanexpress.tests.api.spec.Specs;


import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.is;
import static ru.kazanexpress.tests.api.helpers.AllureRestAssuredFilter.withCustomTemplates;
import static ru.kazanexpress.tests.api.spec.Specs.responseSpec200;


public class ApiTest  {

    @Test
    @DisplayName("Запрос конкретного продукта \"Велосипедки\"")
    void requestProductIdTest() {
        given()
                .spec(Specs.request)
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
}

