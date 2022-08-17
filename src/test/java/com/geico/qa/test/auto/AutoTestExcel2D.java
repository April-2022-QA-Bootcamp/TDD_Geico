package com.geico.qa.test.auto;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.geico.qa.base.BaseClass;
import com.geico.qa.utils.ExcelUtil;

public class AutoTestExcel2D extends BaseClass{

	@DataProvider(name = "autoData2DExcel")
	public Object[][] autoData(){
		String pathString = configuration.get("excelPath");
		String sheetNameString = configuration.get("excelSheet");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		return excelUtil.dataObjects();
	}
	
	@Test(enabled = true, dataProvider = "autoData2DExcel")
	public void getAAutoQuote(String zipCode, String expected, String expectedUrl, String expectedSubTitle1,
			String dob, String firstName, String lastName, String expectedSubTitle2) {
		homePage.homepageAutoSteps(zipCode);
		aboutYou.aboutYouSteps(expected, expectedUrl,expectedSubTitle1, dob,
				firstName, lastName, expectedSubTitle2);
	}
}
