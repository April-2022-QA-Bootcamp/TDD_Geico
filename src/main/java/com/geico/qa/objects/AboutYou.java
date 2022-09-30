package com.geico.qa.objects;

import static com.geico.qa.utils.DataMap.*;
import static org.testng.Assert.assertEquals;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.geico.qa.common.CommonFunctions;
import com.geico.qa.utils.AutoData;

public class AboutYou {

	WebDriver driver;
	CommonFunctions commons;
	
	public AboutYou(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}
	
	@FindBy(id = "labelForNo")
	WebElement noThanksElement;
	
	By noThanksBy = By.id("labelForNo");
	
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
	
	private void clickNoThanks() {
		if(commons.isPresent(noThanksBy)) {
			commons.click(noThanksElement);
			clickNext();
		}
	}
	
	private void getTitle(String expected) {
		assertEquals(commons.getText(titlElement), expected);
	}
	
	private void getCurrentUrl(String expectedUrl) {
		assertEquals(commons.getCurrentUrl(driver), expectedUrl);
	}
	
	private void getSubTitle(String expectedSubTitle) {
		assertEquals(commons.getText(subTitle), expectedSubTitle);
	}
	
	private void getTitle() {
		commons.getTitle();
	}
	
	private void inputDOB(String dob, String expectedSubTitle1) {
		commons.inputValues(dobElement, dob);
		getSubTitle(expectedSubTitle1);
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
		//assertEquals(commons.getText(errorMsgElement), expectedError);
	}
	
	public void aboutYouSteps(String expected, String expectedUrl, String expectedSubTitle1, String dob, 
			String firstName, String lastName, String expectedSubTitle2, String errorMsg) {
		clickNoThanks();
		getTitle(expected);
		getCurrentUrl(expectedUrl);
		getTitle();
		inputDOB(dob, expectedSubTitle1);
		clickNext();
		clickNext();
		inputFirstName(firstName);
		inputLastName(lastName);
		getSubTitle(expectedSubTitle2);
		clickNext();
		clickNext();
		getErrorMsg(errorMsg);
	}
	
	public void aboutYouSteps(String expected, String expectedUrl, String expectedSubTitle1, String dob, 
			String firstName, String lastName, String expectedSubTitle2) {
		getTitle(expected);
		getCurrentUrl(expectedUrl);
		inputDOB(dob, expectedSubTitle1);
		clickNext();
		clickNext();
		inputFirstName(firstName);
		inputLastName(lastName);
		getSubTitle(expectedSubTitle2);
		clickNext();
	}
	
	public void aboutYouSteps(Map<String, String> map) {
		getTitle(map.get(Title.name()));
		getCurrentUrl(map.get(URL.name()));
		inputDOB(map.get(DOB.name()), map.get(SubTitle1.getValue()));
		clickNext();
		clickNext();
		inputFirstName(map.get(FirstName.getValue()));
		inputLastName(map.get(LastName.getValue()));
		getSubTitle(map.get(SubTitle2.getValue()));
		clickNext();
	}
	
	public void aboutYouSteps(AutoData autoData) {
		getTitle(autoData.getExpectedTitle());
		getCurrentUrl(autoData.getExpectedUrl());
		inputDOB(autoData.getDob(), autoData.getExpectedSubTitle1());
		clickNext();
		clickNext();
		inputFirstName(autoData.getFirstName());
		inputLastName(autoData.getLastName());
		getSubTitle(autoData.getExpectedSubtitle2());
		clickNext();
	}
}
