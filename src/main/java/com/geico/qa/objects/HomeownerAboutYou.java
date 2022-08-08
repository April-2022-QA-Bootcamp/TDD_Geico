package com.geico.qa.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.geico.qa.common.CommonFunctions;

public class HomeownerAboutYou {

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
	
	@FindBy(xpath = "//section[@id='PurchasingFrame']/h2")
	WebElement titlElement4;
	
	@FindBy(xpath = "//input[contains(@id, 'Purchasing_False')]/following-sibling::label")
	WebElement purchasingFalsElement;
	
	@FindBy(xpath = "//input[contains(@id, 'Purchasing_True')]/following-sibling::label")
	WebElement purchasingTrueElement;
	
	@FindBy(xpath = "//input[contains(@id, 'HomeClosing_True')]/following-sibling::label")
	WebElement homeClosingTruElement;
	
	@FindBy(xpath = "//input[contains(@id, 'HomeClosing_False')]/following-sibling::label")
	WebElement homeClosingFalsElement;
	
	@FindBy(xpath = "//input[contains(@id, 'ClosingDate')]")
	WebElement closingDatElement;
	
	By notSurElement = By.xpath("//h2[contains(text(),'not sure.')]");
	
	@FindBy(xpath = "//input[contains(@id,'MovedRecently_True')]/following-sibling::label")
	WebElement movedRecentlyElement;
	
	@FindBy(xpath = "//input[contains(@id,'MovedRecently_False')]/following-sibling::label")
	WebElement moreThanTwoYearsElement;
	
	@FindBy(xpath = "//select[contains(@id,'CurrentlyInsured')]")
	WebElement doYouCurrentlyHavePropertyInsurancElement;
	
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
	
	private void getTitle4(String expectedTitle4) {
		assertEquals(commons.getText(titlElement4), expectedTitle4);
	}
	
	private void isHomeClosing(boolean isHomeClosing, String closingDate) {
		if(isHomeClosing) {
			commons.click(homeClosingTruElement);
			commons.inputValues(closingDatElement, closingDate);
		}else {
			commons.click(homeClosingFalsElement);
			if(!commons.isPresent(notSurElement)) {
				commons.failText();
			}
		}
	}
	
	private void movedRecently(boolean movedRecently) {
		if(movedRecently) {
			commons.click(movedRecentlyElement);
		}else {
			commons.click(moreThanTwoYearsElement);
		}
	}
	
	private void isPurchasing(boolean isPurchasing) {
		if(isPurchasing) {
			commons.click(purchasingTrueElement);
		}else {
			commons.click(purchasingFalsElement);
		}
	}
	
	//Nested
	private void isPurchasing(boolean isPurchasing, boolean isHomeClosing, String closingDate, 
			boolean movedRecently, String priorInsurance) {
		if(isPurchasing) {
			commons.click(purchasingTrueElement);
			isHomeClosing(isHomeClosing, closingDate);
			clickNext();
		}else {
			commons.click(purchasingFalsElement);
			if(movedRecently) {
				movedRecently(movedRecently);
			}else {
				movedRecently(movedRecently);
				clickNext();
				selectDoYouCurrentlyHavePropertyInsurance(priorInsurance);
			}
		}
	}
	
	private void selectDoYouCurrentlyHavePropertyInsurance(String value) {
		commons.selectDropdown(doYouCurrentlyHavePropertyInsurancElement, value);
	}
	
	public void homeOwnersAboutYouSteps(String firstName, String lastName, String expectedTitle1,
			String dob, String expectedTitle2, String email, String expectedTitle3, String expectedTitle4,
			boolean isPurchasing, boolean isHomeClosing, String closingDate, boolean movedRecently,
			String priorInsurence) {
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
		getTitle4(expectedTitle4);
		isPurchasing(isPurchasing, isHomeClosing, closingDate, movedRecently, priorInsurence);
	}
	
	public void homeOwnersAboutYouSteps_HomeOwnerMoreThanTwoYears(String firstName, String lastName, String expectedTitle1,
			String dob, String expectedTitle2, String email, String expectedTitle3, String expectedTitle4,
			boolean isPurchasing, boolean movedRecently, String priorInsurence) {
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
		getTitle4(expectedTitle4);
		isPurchasing(isPurchasing);
		movedRecently(movedRecently);
		clickNext();
		selectDoYouCurrentlyHavePropertyInsurance(priorInsurence);
		clickNext();
	}
	
	public void homeOwnersAboutYouSteps_HomeOwnerLessThanTwoYears(String firstName, String lastName, String expectedTitle1,
			String dob, String expectedTitle2, String email, String expectedTitle3, String expectedTitle4,
			boolean isPurchasing, boolean movedRecently) {
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
		getTitle4(expectedTitle4);
		isPurchasing(isPurchasing);
		movedRecently(movedRecently);
		clickNext();
	}
	
	public void homeOwnersAboutYouSteps_BuyerWithOrWithoutClosingDate(String firstName, String lastName, String expectedTitle1,
			String dob, String expectedTitle2, String email, String expectedTitle3, String expectedTitle4,
			boolean isPurchasing, boolean isHomeClosing, String closingDate) {
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
		getTitle4(expectedTitle4);
		isPurchasing(isPurchasing);
		isHomeClosing(isHomeClosing, closingDate);
		clickNext();
	}
}
