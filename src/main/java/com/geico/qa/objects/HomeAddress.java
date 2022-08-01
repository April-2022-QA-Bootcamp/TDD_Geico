package com.geico.qa.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.geico.qa.common.CommonFunctions;

public class HomeAddress {

	CommonFunctions commons;
	
	public HomeAddress(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}
	
	@FindBy(id = "AddressAutoCompleteField")
	WebElement addressElement;
	
	@FindBy(className = "f_Apt")
	WebElement unitNumberElement;
	
	@FindBy(xpath = "(//input[contains(@id, 'PropertyZip')])[1]")
	WebElement zipCodElement;
	
	@FindBy(id = "next")
	WebElement nextButtonElement;
	
	private void inputAddress(String address) {
		commons.inputValues(addressElement, address);
	}
	
	private void inputUnitNumber(String unit) {
		commons.inputValues(unitNumberElement, unit);
	}
	
	private void inputZipCode(String zipCode) {
		commons.clear(zipCodElement);
		commons.inputValues(zipCodElement, zipCode);
	}
	
	private void clickNextButton() {
		commons.click(nextButtonElement);
	}
	
	public void homeAddressSteps(String address, String unit, String zipCode) {
		inputAddress(address);
		inputUnitNumber(unit);
		inputZipCode(zipCode);
		clickNextButton();
	}
}
