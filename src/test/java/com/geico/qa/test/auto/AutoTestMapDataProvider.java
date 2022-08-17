package com.geico.qa.test.auto;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.geico.qa.base.BaseClass;
import static com.geico.qa.utils.DataMap.*;
import com.geico.qa.utils.ExcelUtil;

public class AutoTestMapDataProvider extends BaseClass{

	@DataProvider(name = "excelMap")
	public Object[][] mapData(){
		String pathString = configuration.get("excelPath");
		String sheetNameString = configuration.get("excelSheetMap");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		int size = excelUtil.dataMap().size();
		Object[][] objects2d = new Object[size][1];
		/*
		 * objects2d is an two-dimensional array
		 * Object[][] objects2d = new Object[size][1]
		 * define size = basically that many number of rows in dataMap
		 * 1 = is basically each dataMap index has one map
		 */
		for(int i = 0; i < size; i++) {
			objects2d[i][0] = excelUtil.dataMap().get(i);
		}
		return objects2d;
	}
	
	@Test(enabled = false, dataProvider = "excelMap")
	public void autoDataWithMapDataProvider(Map<String, String> map) {
		homePage.homepageAutoSteps(map.get("Zip Code"));
		aboutYou.aboutYouSteps(map.get("Title"), map.get("URL"),map.get("Sub-title1"), map.get("DOB"),
				map.get("First Name"), map.get("Last Name"), map.get("Sub-title2"));
		
	}
	
	
	@Test(enabled = false, dataProvider = "excelMap")
	public void autoDataWithMapDataProviderWithEnum(Map<String, String> map) {
		homePage.homepageAutoSteps(map.get(ZipCode.getValue()));
		aboutYou.aboutYouSteps(map.get(Title.name()), map.get(URL.name()),map.get(SubTitle1.getValue()), map.get(DOB.name()),
				map.get(FirstName.getValue()), map.get(LastName.getValue()), map.get(SubTitle2.getValue()));
		
	}
	
	@Test(enabled = true, dataProvider = "excelMap")
	public void autoDataWithMapDataProviderWithMap(Map<String, String> map) {
		homePage.homepageAutoSteps(map);
		aboutYou.aboutYouSteps(map);
		
	}
}
