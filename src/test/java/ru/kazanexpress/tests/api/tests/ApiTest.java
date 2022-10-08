package ru.kazanexpress.tests.api.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kazanexpress.tests.web.tests.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;



public class ApiTest extends TestBase {

    @Test
    @DisplayName("200test")
    void postRegisterUserSuccess() {
        String body = "{\"id\": \"250186\", \"title\": \"Велосипедки женские, шорты спортивные\" }";

        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .pathParam("TOVAR",250186 )
                .get("https://api.kazanexpress.ru/api/v2/product/{TOVAR}")
                .then().log().all()
                .statusCode(200)
                .body("payload.data.id",is(250186));
    }
}

//    @Test
//    @DisplayName("getStatusCode404")
//    void getUserNotFound() {
//
//        get("https://reqres.in/api/users/23")
//                .then()
//                .statusCode(404);
//    }


//    @Test
//    @DisplayName("201test")
//    void postNameAndJobValues() {
//        String body = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";
//
//        given()
//                .body(body)
//                .contentType(JSON)
//                .when()
//                .log().all() // Раскроет всё тело запроса
//                .post("https://reqres.in/api/users")
//                .then()
//                .log().all()
//                .statusCode(201)
//                .body("name", is("morpheus"))
//                .body("job", is("leader"));
//    }
//
//    @Test
//    @DisplayName("NullValue200")
//    void putUpdatedAtNotNull() {
//        String body = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";
//
//        given()
//                .body(body)
//                .contentType(JSON)
//                .when()
//                .log().all() // Раскроет всё тело запроса
//                .put("https://reqres.in/api/users/2")
//                .then()
//                .log().all() // Раскроет всё тело ответа
//                .statusCode(200)
//                .body("updatedAt", notNullValue());
//    }
//
//    @Test
//    @DisplayName("MissingPassword400")
//    void postMissingPassword() {
//        String body = "{ \"email\": \"sydney@fife\" }";
//
//        given()
//                .body(body)
//                .contentType(JSON)
//                .when()
//                .log().all() // Раскроет всё тело запроса
//                .post("https://reqres.in/api/register")
//                .then()
//                .log().all() // Раскроет всё тело ответа
//                .statusCode(400)
//                .body("error", is("Missing password"));
//    }
//}
