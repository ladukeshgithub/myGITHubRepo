package com.palindrome.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.palindrome.pages.BaseClass;
import com.palindrome.pages.PalindromePage;

public class TestPalindromeApp extends BaseClass {
	
	@Test
	public void testPalindrome() throws IOException{
	
		PalindromePage m_PalindromePage = PageFactory.initElements(driver, PalindromePage.class);
		String palindromeResult = m_PalindromePage.enterTextToPalindromebox(excel.getStringData(0, 0, 0));
		Assert.assertTrue(palindromeResult.contains(config.getPropertyValue("palindromeExpectedResult")));
		
	}
	
	@Test
	public void testAnagram() {
		PalindromePage m_PalindromePage = PageFactory.initElements(driver, PalindromePage.class);
		String anagramResult = m_PalindromePage.enterTextToAnagrambox(excel.getStringData(0, 1, 0));
		Assert.assertTrue(anagramResult.contains(config.getPropertyValue("anagramExpectedResult")));
	}
}
