package com.geico.qa.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geico.qa.common.Commons;

public class HomePage {

	Commons commons;
	
	public HomePage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}
	
	@FindBy(id = "ssp-service-zip")
	WebElement zipCodElement;
	@FindBy(xpath = "//div[@class='card' and @data-product='auto']")
	WebElement autoProductElement;
	@FindBy(xpath = "//a[text()='Start My Quote']")
	WebElement startMyQuotElement;
	@FindBy(xpath = "(//input[@value='Continue'])[1]")
	WebElement continuElement;
	
	private void inputZipCode(String value) {
		commons.inputValues(zipCodElement, value);
	}
	
	private void clickAuto() {
		commons.click(autoProductElement);
	}
	
	private void clickStartMyQuote() {
		commons.click(startMyQuotElement);
	}
	
	private void clickContinue() {
		commons.click(continuElement);
	}
	
	public void homepageSteps(String value) {
		inputZipCode(value);
		clickAuto();
		clickStartMyQuote();
		clickContinue();
	}
}
