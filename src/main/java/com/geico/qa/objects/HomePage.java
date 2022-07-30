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
	@FindBy(xpath = "(//div[@class='card' and @data-product='homeowners'])[1]")
	WebElement homeProductElement;
	@FindBy(xpath = "//a[text()='Start My Quote']")
	WebElement startMyQuotElement;
	@FindBy(id = "submitBtn")
	WebElement startMyHomeQuotElement;
	@FindBy(xpath = "(//input[@value='Continue'])[1]")
	WebElement continuElement;
	
	private void inputZipCode(String value) {
		commons.inputValues(zipCodElement, value);
	}
	
	private void clickAuto() {
		commons.click(autoProductElement);
	}
	
	private void clickHome() {
		commons.click(homeProductElement);
	}
	
	private void clickStartMyQuote() {
		commons.click(startMyQuotElement);
	}
	
	private void clickStartMyHomeQuote() {
		commons.click(startMyHomeQuotElement);
	}
	
	private void clickContinue() {
		commons.click(continuElement);
	}
	
	public void homepageAutoSteps(String value) {
		inputZipCode(value);
		clickAuto();
		clickStartMyQuote();
		clickContinue();
	}
	
	public void homepageHomeSteps(String value) {
		inputZipCode(value);
		clickHome();
		clickStartMyHomeQuote();
	}
}
