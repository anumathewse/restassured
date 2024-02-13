package com.sample.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;

/**
 * This class contains test methods for performing CRUD operations with a local server.
 * @autor: Anu Mathews
 */
public class CURDWithLocalServer 
{
	/**
	 * This method performs a GET request to a local server.
	 * It sets the base URI to "http://localhost:3000/" and sends a GET request to "/profile".
	 * It then verifies that the response status code is 200 and logs the response details.
	 */
	@Test
	public void GetwithLocal() 
	{

		baseURI = "http://localhost:3000/";
		given().get("/profile").then().statusCode(200).log().all();
	}

	/**
	 * Sends a POST request to a local server with the specified JSON payload.
	 * The request includes a "title" and "views" field in the JSON body.
	 * Expects a response with a status code of 201 (Created).
	 * Logs the response details.
	 */
	@Test
	public void POSTwithLocal() {

		JSONObject request = new JSONObject();
		request.put("title", "LocalPost");
		request.put("views", "250");

		baseURI = "http://localhost:3000";
		given().body(request.toJSONString()).when().post("/posts").then().statusCode(201).log().all();

	}

	/**
	 * Sends a PUT request to update a resource on the local server.
	 * The request body contains a JSON object with the updated title and views.
	 * Expects a response with status code 200 and logs the response details.
	 */
	@Test
	public void PUTwithLocal() 
	{

		JSONObject request = new JSONObject();
		request.put("title", "LocalUpdate");
		request.put("views", "300");

		baseURI = "http://localhost:3000";
		given().body(request.toJSONString()).when().put("/posts/1").then().statusCode(200).log().all();

	}

	/**
	 * This method performs a PATCH request with a local server.
	 * It sends a JSON object as the request body and updates the specified post.
	 * The base URI is set to "http://localhost:3000".
	 * The response status code is expected to be 200 (OK).
	 * The response details are logged.
	 */
	@Test
	public void PatchwithLocal() 
	{

		JSONObject request = new JSONObject();
		request.put("views", "350");

		baseURI = "http://localhost:3000";
		given().body(request.toJSONString()).when().patch("/posts/1").then().statusCode(200).log().all();

	}
}