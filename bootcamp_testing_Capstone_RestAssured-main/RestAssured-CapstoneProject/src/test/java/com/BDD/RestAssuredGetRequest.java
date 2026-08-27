package com.BDD;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RestAssuredGetRequest {

    public static void main(String args[]) {

        Response response = given()
                .header("Accept", "application/json")

                .when()
                .get("https://restful-booker.herokuapp.com/booking")

                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract()
                .response();

        System.out.println("Status Code :" + response.getStatusCode());

        System.out.println("Complete Response :");
        System.out.println(response.asPrettyString());

        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());

        System.out.println("Status Line :" + response.getStatusLine());

        System.out.println("Content Type :" + response.getContentType());

        System.out.println("Response Time :" + response.getTime() + "ms");
    }
}