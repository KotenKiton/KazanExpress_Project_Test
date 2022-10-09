package ru.kazanexpress.tests.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kazanexpress.tests.api.spec.Specs;


import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.notNullValue;
import static ru.kazanexpress.tests.api.helpers.AllureRestAssuredFilter.withCustomTemplates;
import static ru.kazanexpress.tests.api.spec.Specs.responseSpec200;


public class ApiTest  {

    @Test
    @DisplayName("200test")
    void postRegisterUserSuccess() {

        given()
                .spec(Specs.request)
                .filter(withCustomTemplates())
                .when()
                .log().all()
                .get("/v2/product/250186")
                .then()
                .log().all()
                .spec(responseSpec200)
                .body("payload", notNullValue());
    }
}

