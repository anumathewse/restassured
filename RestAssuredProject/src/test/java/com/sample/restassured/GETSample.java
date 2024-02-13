package com.sample.restassured;

import org.testng.annotations.Test;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GETSample {

	@Test
	public void GetBDDStyle() {

		baseURI = "https://reqres.in/api";
		given().get("users?page=2").then().statusCode(200);

	}

	@Test
	public void GetAPISample() {

		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println("status:" + response.getStatusCode());
		System.out.println("Body" + response.getBody().asString());

		Assert.assertEquals(response.getStatusCode(), 200);

	}

}