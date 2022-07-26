package com.geico.qa.objects;

import static com.geico.qa.utils.DataMap.ZipCode;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geico.qa.common.CommonFunctions;
import com.geico.qa.utils.AutoData;

public class HomePage {

	CommonFunctions commons;
	
	public HomePage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}
	
	@FindBy(id = "ssp-service-zip")
	WebElement zipCodElement;
	@FindBy(xpath = "//div[@class='card' and @data-product='auto']|(//div[@class='product-cards']/div[@class='card'])[1]")
	WebElement autoProductElement;
	@FindBy(xpath = "(//div[@class='card' and @data-product='homeowners'])[1]")
	WebElement homeProductElement;
	@FindBy(xpath = "//div[@id='bundleModalBtn']/p/a")
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
		commons.jsExecutor("arguments[0].scrollIntoView(true);", startMyQuotElement);
		commons.click(startMyQuotElement);
		int totalHit = 10;
		int hit = 0;
		while(!continuElement.isDisplayed() && hit < totalHit) {
			commons.jsExecutor("arguments[0].click();", startMyQuotElement);
			hit++;
		}
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
	
	public void homepageAutoSteps(Map<String, String> map) {
		inputZipCode(map.get(ZipCode.getValue()));
		clickAuto();
		clickStartMyQuote();
		clickContinue();
	}
	
	public void homepageAutoSteps(AutoData autoData) {
		inputZipCode(autoData.getZipCode());
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
