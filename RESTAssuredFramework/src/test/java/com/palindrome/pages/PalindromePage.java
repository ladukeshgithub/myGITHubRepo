package com.palindrome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PalindromePage {

	WebDriver driver;

	public PalindromePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//*[@id='originalWord']/ancestor::p")	WebElement palindromeTextboxHeader;
	@FindBy(id = "originalWord")	WebElement palindromeTextbox;
	@FindBy(id = "button1")	WebElement palindromeSubmitButton;
	@FindBy(id = "palindromeResult")	WebElement palindromeResult;
	@FindBy(xpath = "//*[@id='anagramWord']//preceding-sibling::br")	WebElement anagramTextboxHeader;
	@FindBy(id = "anagramWord")	WebElement anagramTextbox;
	@FindBy(id = "button2")	WebElement anagramSubmitButton;
	@FindBy(id = "anagramResult")	WebElement anagramResult;

	public String enterTextToPalindromebox(String palindromeText) {
		palindromeTextbox.sendKeys(palindromeText);
		palindromeSubmitButton.click();
		return palindromeResult.getText();
	}

	public String enterTextToAnagrambox(String anagramText) {
		anagramTextbox.sendKeys(anagramText);
		anagramSubmitButton.click();
		return anagramResult.getText();
	}
}
