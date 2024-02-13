package com.sample.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class POSTSample {

	@Test
	public void PrintPayload() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "John");
		map.put("JOB", "Manager");

		System.out.println(map);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void POSTTest() {

		// Convert payload inJson format
		// Map<String, Object> map = new HashMap<String, Object>();

		JSONObject request = new JSONObject();

		request.put("name", "John");
		request.put("JOB", "Manager");

		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/";
		given().body(request.toJSONString()).when().post("/api/users").then().statusCode(201).log().all();

	}
}
