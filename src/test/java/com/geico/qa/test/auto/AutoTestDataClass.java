package com.geico.qa.test.auto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.geico.qa.base.BaseClass;
import com.geico.qa.utils.AutoData;

public class AutoTestDataClass extends BaseClass{

	@DataProvider(name = "autoDataIterator")
	public Iterator<AutoData> autoDataIterator() {
		List<AutoData> list = new ArrayList<AutoData>();
		AutoData autoData1 = new AutoData("11419", "About You", "https://sales.geico.com/quote","Let’s get started.", "02/02/1988",
				"David", "Miller", "Tell us about yourself.");
		AutoData autoData2 = new AutoData("11418", "About You", "https://sales.geico.com/quote","Let’s get started.", "01/01/1978",
				"Andrew", "Russel", "Tell us about yourself.");
		list.add(autoData1);
		list.add(autoData2);
		return list.iterator();
	}
	
	@DataProvider(name = "autoDataObject")
	public Object[][] autoDataObject() {
		AutoData autoData1 = new AutoData("11419", "About You", "https://sales.geico.com/quote","Let’s get started.", "02/02/1988",
				"Tamim", "Iqbal", "Tell us about yourself.");
		AutoData autoData2 = new AutoData("11418", "About You", "https://sales.geico.com/quote","Let’s get started.", "01/01/1978",
				"Liton", "Das", "Tell us about yourself.");
		return new Object[][] {{autoData1}, {autoData2}};
	}
	
	@Test(enabled = true, dataProvider = "autoDataObject")
	public void getAAutoQuote(AutoData autoData) {
		homePage.homepageAutoSteps(autoData);
		aboutYou.aboutYouSteps(autoData);
	}
}
