package com.geico.qa.test.home;

import org.testng.annotations.Test;

import com.geico.qa.base.BaseClass;

public class HomeTestClass_AllSteps extends BaseClass{
	
	@Test(enabled = false)
	public void getAHomeQuoteWithRecentlyMoved() {
		homePage.homepageHomeSteps("11418");
		homeAddress.homeAddressSteps("87-88 Lefferts Boulevard", "2C", "11418");
		homeownerAboutYou.homeOwnersAboutYouSteps("Nosimon", "Bibi", "What is your name?", "02/02/1970",
				"When were you born? ?", "test@test.com", "What is your email address? ?", "Are you currently in the process of buying this home?",
				true, true, "08/05/2022", false, null);
	}
	
	@Test(enabled = false)
	public void getAHomeQuoteFirstTimeBuyer() {
		homePage.homepageHomeSteps("11418");
		homeAddress.homeAddressSteps("87-88 Lefferts Boulevard", "2C", "11418");
		homeownerAboutYou.homeOwnersAboutYouSteps("Nosimon", "Bibi", "What is your name?", "02/02/1970",
				"When were you born? ?", "test@test.com", "What is your email address? ?", "Are you currently in the process of buying this home?",
				false, false, null, false, "03");
	}
	
}
