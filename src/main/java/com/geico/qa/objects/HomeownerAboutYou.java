package com.geico.qa.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.geico.qa.common.CommonFunctions;

public class HomeownerAboutYou {

	/*
	 * input email
	 * assert title
	 */
	CommonFunctions commons;

	public HomeownerAboutYou(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}

	@FindBy(xpath = "//section[@id='CustomerProfileFrame']//h2")
	WebElement titlElement1;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstNamElement;

	@FindBy(xpath = "//input[contains(@id, 'LastName')]")
	WebElement lastNamElement;

	@FindBy(id = "next")
	WebElement nextElement;

	@FindBy(xpath = "//div[@class='ShowQuestion']/span/input[contains(@id,'DateOfBirth')]")
	WebElement dobElement;

	@FindBy(xpath = "//section[@id='DOBFrame']/h2")
	WebElement titlElement2;
	
	@FindBy(className = "f_Email")
	WebElement emailElement;

	@FindBy(xpath = "//section[@id='EmailFrame']/h2[@class='breakdownQuestionHeader']")
	WebElement titlElement3;
	
	private void inputFirstName(String firstName) {
		commons.inputValues(firstNamElement, firstName);
	}

	private void inputLastName(String lastName) {
		commons.inputValues(lastNamElement, lastName);
	}

	private void getTitle1(String expectedTitle) {
		assertEquals(commons.getText(titlElement1), expectedTitle);
	}

	private void clickNext() {
		commons.click(nextElement);
	}

	private void inputDOB(String dob) {
		commons.inputValues(dobElement, dob);
	}

	private void getTitle2(String expectedTitle2) {
		assertEquals(commons.getText(titlElement2), expectedTitle2);
	}

	private void inputEmail(String email) {
		commons.inputValues(emailElement, email);
	}
	
	private void getTitle3(String expectedTitle3) {
		assertEquals(commons.getText(titlElement3), expectedTitle3);
	}
	
	public void homeOwnersAboutYouSteps(String firstName, String lastName, String expectedTitle1,
			String dob, String expectedTitle2, String email, String expectedTitle3) {
		inputFirstName(firstName);
		inputLastName(lastName);
		getTitle1(expectedTitle1);
		clickNext();
		inputDOB(dob);
		getTitle2(expectedTitle2);
		clickNext();
		inputEmail(email);
		getTitle3(expectedTitle3);
		clickNext();
	}
}
