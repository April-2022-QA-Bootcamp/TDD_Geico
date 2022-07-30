package com.geico.qa.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geico.qa.common.Commons;

public class AboutYou {

	WebDriver driver;
	Commons commons;
	
	public AboutYou(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}
	
	@FindBy(tagName = "h4")
	WebElement titlElement;
	
	@FindBy(tagName = "h3")
	WebElement subTitle;
	
	@FindBy(className = "date")
	WebElement dobElement;
	
	@FindBy(xpath = "//button[contains(.,'Next')]")
	WebElement nextButtonWebElement;
	
	@FindBy(xpath = "//input[@data-formotivid='FirstName']")
	WebElement firstNamElement;
	
	@FindBy(xpath = "//input[@data-formotivid='LastName']")
	WebElement lastNamElement;
	
	@FindBy(xpath = "(//div[@class='row']//p)[1]")
	WebElement errorMsgElement;
	
	private void getTitle(String expected) {
		assertEquals(expected, commons.getText(titlElement));
	}
	
	private void getCurrentUrl(String expectedUrl) {
		assertEquals(expectedUrl, commons.getCurrentUrl(driver));
	}
	
	private void getSubTitle(String expectedSubTitle) {
		assertEquals(expectedSubTitle, commons.getText(subTitle));
	}
	
	private void inputDOB(String dob) {
		commons.inputValues(dobElement, dob);
	}
	
	private void clickNext() {
		commons.click(nextButtonWebElement);
	}
	
	private void inputFirstName(String firstName) {
		commons.inputValues(firstNamElement, firstName);
	}
	
	private void inputLastName(String lastName) {
		commons.inputValues(lastNamElement, lastName);
	}
	
	private void getErrorMsg(String expectedError) {
		assertEquals(expectedError, commons.getText(errorMsgElement));
	}
	
	public void aboutYouSteps(String expected, String expectedUrl, String expectedSubTitle1, String dob, 
			String firstName, String lastName, String expectedSubTitle2, String errorMsg) {
		getTitle(expected);
		getCurrentUrl(expectedUrl);
		getSubTitle(expectedSubTitle1);
		inputDOB(dob);
		clickNext();
		inputFirstName(firstName);
		inputLastName(lastName);
		getSubTitle(expectedSubTitle2);
		clickNext();
		getErrorMsg(errorMsg);
	}
}
