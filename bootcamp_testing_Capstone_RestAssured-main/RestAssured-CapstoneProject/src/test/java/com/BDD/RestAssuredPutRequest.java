package com.BDD;

import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;

public class RestAssuredPutRequest {

    public static void main(String args[]) {

        JSONObject requestBody = new JSONObject();

        requestBody.put("id", 1);
        requestBody.put("title", "Updated RestAssured");
        requestBody.put("body", "Updated PUT request");
        requestBody.put("userId", 1);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())

                .when()
                .put("https://jsonplaceholder.typicode.com/posts/1")

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