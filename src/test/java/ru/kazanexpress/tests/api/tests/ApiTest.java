package ru.kazanexpress.tests.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kazanexpress.tests.web.tests.TestBase;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static ru.kazanexpress.tests.api.spec.Specs.request;
import static ru.kazanexpress.tests.api.spec.Specs.responseSpec200;


public class ApiTest extends TestBase {

    @Test
    @DisplayName("200test")
    void postRegisterUserSuccess() {
        String body = "{\"id\": \"250186\", \"title\": \"Велосипедки женские, шорты спортивные\" }";

        given()
                .spec(request)
                .body(body)
                .when()
                .log().all()// Раскроет всё тело запроса
                .get("/v2/product/250186")
                .then()
                .log().all()
                .spec(responseSpec200)
                .body("id", is(250186));
    }

//https://api.kazanexpress.ru/api/v2/product/250186
    // "payload": {
    //        "data": {
    //            "id": 250186,
    //            "title": "Велосипедки женские, шорты спортивные",
    //            "category": {
    //                "id": 12279,
    //                "title": "Велосипедки",
    //                "productAmount": 131,
    //                "parent": {
    //                    "id": 2812,
    //                    "title": "Спортивная одежда",
    //                    "productAmount": 1456,
    //                    "parent": {
    //                        "id": 10116,
    //                        "title": "Женская одежда",
    //                        "productAmount": 36621,
    //                        "parent": {
    //                            "id": 10014,
    //                            "title": "Одежда",
    //                            "productAmount": 65462,
    //                            "parent": null
    //                        }
    //                    }
    //                }
    //            },

    @Test
    @DisplayName("getStatusCode404")
    void getUserNotFound() {

        get("https://reqres.in/api/users/23")
                .then()
                .statusCode(404);
    }


    @Test
    @DisplayName("201test")
    void postNameAndJobValues() {
        String body = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

        given()
                .body(body)
                .contentType(JSON)
                .when()
                .log().all() // Раскроет всё тело запроса
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"));
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

    @Test
    @DisplayName("MissingPassword400")
    void postMissingPassword() {
        String body = "{ \"email\": \"sydney@fife\" }";

        given()
                .body(body)
                .contentType(JSON)
                .when()
                .log().all() // Раскроет всё тело запроса
                .post("https://reqres.in/api/register")
                .then()
                .log().all() // Раскроет всё тело ответа
                .statusCode(400)
                .body("error", is("Missing password"));
    }
}
