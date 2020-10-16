package com.api.project;

import model.Address;
import model.FirstUser;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class PutApi {

    @Test
    public void putJsonPlaceholder() {

        Address address=new Address();

        address.setStreetAddress("St-hubert");
        address.setPhone(1234567);
       address.setEmail("t@yahoo.fr");

        FirstUser firstUser=new FirstUser();
        firstUser.setFirstName("Toto");
        firstUser.setLastName("Bret");
        firstUser.setAddressObject(address);

        given()
                .when()
                .body(firstUser)
                .put("https://jsonplaceholder.typicode.com/posts/1")
                .then().statusCode(200).log().all();
    }
}
