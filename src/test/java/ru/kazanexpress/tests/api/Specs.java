package ru.kazanexpress.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class Specs { @Test
@DisplayName("200test")
void postRegisterUserSuccess() {
    String body = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }";

    given()
            .body(body)
            .contentType(JSON)
            .when()
            .log().all() // Раскроет всё тело запроса
            .post("https://reqres.in/api/register")
            .then()
            .log().all()
            .statusCode(200)
            .body("id", is(4))
            .body("token", is(notNullValue()));
}

    @Test
    @DisplayName("NullValue200")
    void putUpdatedAtNotNull() {
        String body = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";

        given()
                .body(body)
                .contentType(JSON)
                .when()
                .log().all() // Раскроет всё тело запроса
                .put("https://reqres.in/api/users/2")
                .then()
                .log().all() // Раскроет всё тело ответа
                .statusCode(200)
                .body("updatedAt", notNullValue());
    }
}
