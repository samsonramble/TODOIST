package org.example;

import io.restassured.RestAssured;
import org.junit.Test;

public class AppTest {

    @Test
    public void helloWorldTest(){
        System.out.println("Hello World!");

        RestAssured
                .given().baseUri("http://numbersapi.com")
                .log().all()
                .when().get("/1410/year")
                .then()
                .log().all();
    }
}
