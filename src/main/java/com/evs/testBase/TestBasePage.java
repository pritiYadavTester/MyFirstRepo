package com.evs.testBase;

import org.testng.annotations.BeforeMethod;

import com.evs.Utility.Utility;

public class TestBasePage {

	protected Utility  utill= new Utility();
	@BeforeMethod
	public void launchBrowser() {
		
		utill.launchBrowser();
		utill.openUrl("http://localhost:8888");
	}
	
}
