package com.sample.restassured;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class Test01_GET 
{

	@Test
	void test_01() 
	{
	
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());	
		
		
		for (Header header : response.getHeaders()) {
		
			System.out.println("==> " +header.getName() + " : " + header.getValue());
			
		}
		
		
		long responseTime = response.getTime();
		
		System.out.println(responseTime);	
		
		// Validating response time is less than or equals (in Milliseconds) 
		//Assert.assertTrue(responseTime <= 1000);
					
		// Validating response time is less than or equals (in Seconds) with custom message
		//Assert.assertTrue(TimeUnit.MILLISECONDS.toSeconds(responseTime) <= 1, "Valid service response time : less than 1 second");
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