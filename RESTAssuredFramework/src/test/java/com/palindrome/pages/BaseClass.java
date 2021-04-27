package com.palindrome.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.palindrome.utility.BrowserFactory;
import com.palindrome.utility.ConfigDataProvider;
import com.palindrome.utility.ExcelDataProvider;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	@BeforeSuite
	public void setUpSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}
	
	@BeforeClass
	public void setUp(){
		driver = BrowserFactory.startBrowser(driver, config.getPropertyValue("Browser"), config.getPropertyValue("qaURL"));
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
}
