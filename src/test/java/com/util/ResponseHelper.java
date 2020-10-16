package com.util;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class ResponseHelper {

    public static void responseValidation(Response response, List<String> responseElements){

        for (String check:responseElements){
            Assert.assertNotNull(response.then().extract().path(check));
        }

    }
}
