package com.geico.qa.test.auto;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.geico.qa.base.BaseClass;

public class AutoTestParameter extends BaseClass{

	@Parameters("zip")
	@Test(enabled = true)
	public void getAAutoQuote(String zip) {
		homePage.homepageAutoSteps(zip);
		aboutYou.aboutYouSteps("About You", "https://sales.geico.com/quote","Let’s get started.", "02/02/1988",
				"David", "Miller", "Tell us about yourself.", "There was a problem while processing the information you submitted.");
	}
}
