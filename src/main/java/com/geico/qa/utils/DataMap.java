package com.geico.qa.utils;

public enum DataMap {

	ZipCode("Zip Code"), FirstName("First Name"), LastName("Last Name"), URL("URL"), Title("Title"),
	SubTitle1("Sub-title1"), SubTitle2("Sub-title2"), DOB("DOB");
	
	private String value;
	
	private DataMap(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
