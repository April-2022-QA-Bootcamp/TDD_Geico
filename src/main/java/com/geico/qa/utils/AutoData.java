package com.geico.qa.utils;

public class AutoData {

	private String zipCode;
	private String expectedTitle;
	private String expectedUrl;
	private String expectedSubTitle1;
	private String dob;
	private String firstName;
	private String lastName;
	private String expectedSubtitle2;
	
	public AutoData(String zipCode, String expectedTitle, String expectedUrl, String expectedSubTitle1, String dob,
			String firstName, String lastName, String expectedSubtitle2) {
		this.zipCode = zipCode;
		this.expectedTitle = expectedTitle;
		this.expectedUrl = expectedUrl;
		this.expectedSubTitle1 = expectedSubTitle1;
		this.dob = dob;
		this.firstName = firstName;
		this.lastName = lastName;
		this.expectedSubtitle2 = expectedSubtitle2;
	}
	
	public String getZipCode() {
		return zipCode;
	}

	public String getExpectedTitle() {
		return expectedTitle;
	}

	public String getExpectedUrl() {
		return expectedUrl;
	}

	public String getExpectedSubTitle1() {
		return expectedSubTitle1;
	}

	public String getDob() {
		return dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getExpectedSubtitle2() {
		return expectedSubtitle2;
	}
}
