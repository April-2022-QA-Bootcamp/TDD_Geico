package com.geico.qa.test.home;

import org.testng.annotations.Test;

import com.geico.qa.base.BaseClass;

public class HomeTestClass_Normalization extends BaseClass{
	
	@Test
	public void buyerWithClosingDate() {
		homePage.homepageHomeSteps("11418");
		homeAddress.homeAddressSteps("87-88 Lefferts Boulevard", "2C", "11418");
		homeownerAboutYou.homeOwnersAboutYouSteps_BuyerWithOrWithoutClosingDate("Nosimon", "Bibi", "What is your name?", "02/02/1970",
				"When were you born? ?", "test@test.com", "What is your email address? ?", "Are you currently in the process of buying this home?",
				true, true, "09/25/2022");
	}
	
	@Test
	public void buyerWithoutClosingDate() {
		homePage.homepageHomeSteps("11418");
		homeAddress.homeAddressSteps("87-88 Lefferts Boulevard", "2C", "11418");
		homeownerAboutYou.homeOwnersAboutYouSteps_BuyerWithOrWithoutClosingDate("Nosimon", "Bibi", "What is your name?", "02/02/1970",
				"When were you born? ?", "test@test.com", "What is your email address? ?", "Are you currently in the process of buying this home?",
				true, false, null);
	}
	
	@Test
	public void homeownerLessThanTwoYears() {
		homePage.homepageHomeSteps("11418");
		homeAddress.homeAddressSteps("87-88 Lefferts Boulevard", "2C", "11418");
		homeownerAboutYou.homeOwnersAboutYouSteps_HomeOwnerLessThanTwoYears("Nosimon", "Bibi", "What is your name?", "02/02/1970",
				"When were you born? ?", "test@test.com", "What is your email address? ?", "Are you currently in the process of buying this home?",
				true, true);
	}
	
	@Test
	public void homeownerMoreThanTwoYears() {
		homePage.homepageHomeSteps("11418");
		homeAddress.homeAddressSteps("87-88 Lefferts Boulevard", "2C", "11418");
		homeownerAboutYou.homeOwnersAboutYouSteps_HomeOwnerMoreThanTwoYears("Nosimon", "Bibi", "What is your name?", "02/02/1970",
				"When were you born? ?", "test@test.com", "What is your email address? ?", "Are you currently in the process of buying this home?",
				true, false, "04");
	}
}
