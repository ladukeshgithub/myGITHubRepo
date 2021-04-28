package com.palindrome.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.palindrome.pages.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class ActivitiesAPITesting extends BaseClass{

	
	@Test
	public void methd1() {
		System.out.println("Token is " + token);
	}
	
	

}
