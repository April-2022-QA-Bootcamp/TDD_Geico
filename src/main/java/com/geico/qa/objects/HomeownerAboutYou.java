package com.geico.qa.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.geico.qa.common.Commons;

public class HomeownerAboutYou {

	Commons commons;
	
	public HomeownerAboutYou(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstNamElement;
	
	private void inputFirstName(String firstName) {
		commons.inputValues(firstNamElement, firstName);
	}
	
	public void homeOwnersAboutYouSteps(String firstName) {
		inputFirstName(firstName);
	}
}
