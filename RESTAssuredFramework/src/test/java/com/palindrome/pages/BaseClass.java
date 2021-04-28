package com.palindrome.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.palindrome.utility.BrowserFactory;
import com.palindrome.utility.ConfigDataProvider;
import com.palindrome.utility.ExcelDataProvider;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public String token;
	
	@BeforeSuite (enabled=false)
	public void setUpSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}
	
	@BeforeClass (enabled=false)
	public void setUp(){
		driver = BrowserFactory.startBrowser(driver, config.getPropertyValue("Browser"), config.getPropertyValue("qaURL"));
	}
	
	@AfterClass (enabled=false)
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@BeforeMethod
	public void generateToken() {
		String username = "tenant1@kkm00das.foo";
		String password = "Prima123Vera";
		String scope = "http://cegbu-mum-551.snbomprshared1.gbucdsint02bom.oraclevcn.com/api";
		String xPrimeTenantCode = "tenant1";
		Header header = new Header("Content-Type", "application/x-www-form-urlencoded");
		Response response = RestAssured.given().auth().preemptive().basic(username, password).header(header)
				.formParam("scope", scope).formParam("x-prime-tenant-code", xPrimeTenantCode)
				.post("https://cegbu-mum-551.snbomprshared1.gbucdsint02bom.oraclevcn.com/primediscovery/apitoken/request");
		System.out.println(response.getStatusCode());
		// access_token
		token =  response.path("accessToken").toString();
	}	
}
