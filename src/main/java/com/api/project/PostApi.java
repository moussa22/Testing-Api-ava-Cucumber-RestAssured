package com.api.project;

import io.restassured.http.ContentType;
import model.Address;
import model.FirstUser;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
/* Created by Cheick
* {

    "name": "Toto",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
      "street": "Kulas Light",
      "suite": "Apt. 556",
      "city": "Gwenborough",
      "zipcode": "92998-3874",
      "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
      }
*
*
*
* */

public class PostApi {

    @Test
    public void postJsonPlaceholder() {

        Address address=new Address();
        address.setStreetAddress("St-hubert");
        address.setPhone(1234567);
        address.setEmail("t@yahoo.fr");

        FirstUser firstUser=new FirstUser();
        firstUser.setFirstName("Toto");
        firstUser.setLastName("Bret");
        firstUser.setAddressObject(address);


        given()
                .contentType(ContentType.JSON)
                .when()
                .body(firstUser)
                .post("https://jsonplaceholder.typicode.com/users/")
                .then().statusCode(201)
                .log()
                .all();

    }
}
