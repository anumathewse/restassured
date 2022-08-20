package com.sample.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test01_GET 
{

	@Test
	void test_01() 
	{
	
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());		
	}
	
	@Test
	void test_02() 
	{
		RestAssured.given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
	}
	
	@Test
	void test_03() 
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=1");
	    Assert.assertEquals(response.getStatusCode(), 200);		
	}
}