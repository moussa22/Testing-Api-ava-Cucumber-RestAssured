package com.isacof.stepdefs;

import com.util.ResponseHelper;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.CustomerPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CustomerStepDefinition {

    CustomerPojo customer=new CustomerPojo();
    private RequestSpecification request;
    private Response response;
    @Given("^I have the data to create customer with \"([^\"]*)\", \"([^\"]*)\",  \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_have_the_data_to_create_customer_with(String firstName, String lastName, String phone, String address1, String address2) {

        ArrayList<String>addresses=new ArrayList<String>();
        addresses.add(address1);
        addresses.add(address2);
        customer.setFirstName("firstName");
        customer.setLastName(lastName);
        customer.setPhone("phone");
        customer.setAddresses(addresses);

    }

    @Given("^I use the customer header$")
    public void i_use_the_customer_header() throws Throwable {
        request=given().header("Content-Type","application/json")
                       .header("Accept-Charset","UTF-8")
                       .log().headers();

    }

    @When("^I create post request to create customer$")
    public void i_create_post_request_to_create_customer() throws Throwable {
        response=request.when().body(customer)
                .log()
                .body()
                .post("https://jsonplaceholder.typicode.com/users");


    }

    @Then("^I get status code (\\d+) from database$")
    public void i_get_status_code_from_database(int statusCode) {
        response.then().statusCode(statusCode).log().all();

    }

    @Then("^response body should contain$")
    public void response_body_should_contain(List<String> responseMap) throws Throwable {

        ResponseHelper.responseValidation(response,responseMap);

    }
    @When("^I create get request to get new  customer$")
    public void i_create_get_request_to_get_new_customer() throws Throwable {

        response=request.when().get("https://jsonplaceholder.typicode.com/users/1");

    }

    @When("^I create delete request to delete new  customer$")
    public void i_create_delete_request_to_delete_new_customer() throws Throwable {
        response=request.when().delete("https://jsonplaceholder.typicode.com/users/1");

    }

}
