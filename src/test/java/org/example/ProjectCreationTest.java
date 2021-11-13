package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;

public class ProjectCreationTest {

    @Test
    public void userCanCreateAProjectTest(){

        RestAssured.baseURI = "https://api.todoist.com";
        RestAssured.basePath = "/rest/v1/";
        RestAssured.requestSpecification = RestAssured.given().header("Authorization","Bearer ae0654be57dc75b5165a7195a8763cbf5ed46f71")
                .contentType(ContentType.JSON);

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        String projectName = "PierwszyTest";

        RestAssured.given()
                .body(format("{\"name\": \"%s\"}", projectName))
                .when()
                .post("/projects")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name",equalTo(projectName))
                .header("Content-Type",equalTo("application/json"));

    }
}
