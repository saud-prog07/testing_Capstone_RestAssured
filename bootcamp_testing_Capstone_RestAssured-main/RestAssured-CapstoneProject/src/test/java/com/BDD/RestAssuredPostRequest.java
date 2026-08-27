package com.BDD;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RestAssuredPostRequest {

	public static void main(String args[]) {

		String requestBody = "{" + "\"firstname\":\"Pranay\"," + "\"lastname\":\"Matri\"," + "\"totalprice\":15000,"
				+ "\"depositpaid\":true," + "\"bookingdates\":{" + "\"checkin\":\"2026-08-22\","
				+ "\"checkout\":\"2026-08-25\"" + "}," + "\"additionalneeds\":\"Breakfast\"" + "}";

		Response response = given().header("Accept", "application/json").header("Content-Type", "application/json")
				.body(requestBody)

				.when().post("https://restful-booker.herokuapp.com/booking")

				.then().statusCode(200).contentType("application/json").extract().response();

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