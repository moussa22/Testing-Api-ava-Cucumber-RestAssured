package com.api.project;

import model.FirstUser;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PatchApi {

    @Test
    public void patchJsonPlaceholder() {

        FirstUser firstUser=new FirstUser();
        firstUser.setFirstName("Toto");
        firstUser.setLastName("Bret");


        given()
                .when()
                .body(firstUser)
                .patch("https://jsonplaceholder.typicode.com/posts/1")
                .then().statusCode(200).log().all();
    }
}
