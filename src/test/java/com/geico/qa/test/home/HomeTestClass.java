package com.geico.qa.test.home;

import org.testng.annotations.Test;

import com.geico.qa.base.BaseClass;

public class HomeTestClass extends BaseClass{
	
	@Test
	public void getAHomeQuote() {
		homePage.homepageHomeSteps("11418");
		homeAddress.homeAddressSteps("87-88 Lefferts Boulevard", "2C", "11418");
		homeownerAboutYou.homeOwnersAboutYouSteps("Nosimon");
	}

}
