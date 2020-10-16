package com.api.project;

import io.restassured.response.Response;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetApi {

    @Test
    public void getJsonPlaceholder() {

        Response response= given().
                when().get("https://jsonplaceholder.typicode.com/users/1");
        System.out.println(response.body().asString());


    }
    @Test
    public void statusCode(){
        given()
                .when().get("https://jsonplaceholder.typicode.com/posts")
                .then().statusCode(200);
    }
}
