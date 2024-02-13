package com.sample.restassured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.*;
import org.json.simple.*;

/**
 * This class contains test methods for performing PUT, PATCH, and DELETE operations using RestAssured.
 * 
 * @autor: Anu Mathews
 */
public class PUTPATCHDELETESamples 
{
	/**
	 * This method demonstrates the usage of a PUT request to update user information.
	 * It sends a JSON payload containing the user's name and job to the specified API endpoint.
	 * The response status code is expected to be 200 (OK).
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void PUTSample()
	{
		JSONObject request = new JSONObject();
		request.put("name", "Tommy");
		request.put("JOB", "Worker");

		baseURI = "https://reqres.in/";
		given().body(request.toJSONString()).when().put("api/users/2").then().statusCode(200).log().all();

	}

	/**
	 * This method demonstrates the usage of the PATCH method in a REST API.
	 * It sends a PATCH request to update the user information with a new name and job.
	 * The request body contains a JSON object with the updated values.
	 * The base URI is set to "https://reqres.in/".
	 * The endpoint for updating a user is "api/users/2".
	 * The expected response status code is 200.
	 * The response is logged using the log().all() method.
	 */
	@Test
	public void PATCHSample() {
		JSONObject request = new JSONObject();
		request.put("name", "Tommy");
		request.put("JOB", "Worker");

		baseURI = "https://reqres.in/";
		given().body(request.toJSONString()).when().patch("api/users/2").then().statusCode(200).log().all();
	}

	/**
	 * This method tests the DELETE functionality by sending a request to delete a user.
	 * It sets the base URI to "https://reqres.in/" and sends a DELETE request to "api/users/2".
	 * The expected response status code is 204 (No Content).
	 */
	@Test
	public void DeleteSample() 
	{
		baseURI = "https://reqres.in/";
		when().delete("api/users/2").then().statusCode(204);
	}
}