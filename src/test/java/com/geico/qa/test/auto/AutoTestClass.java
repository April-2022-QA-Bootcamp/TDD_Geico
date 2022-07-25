package com.geico.qa.test.auto;

import org.testng.annotations.Test;

import com.geico.qa.base.BaseClass;

public class AutoTestClass extends BaseClass{

	@Test
	public void getAAutoQuote() {
		homePage.homepageSteps("11418");
		aboutYou.aboutYouSteps("About You", "https://sales.geico.com/quote");
	}
}
