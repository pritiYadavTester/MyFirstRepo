package com.evs.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.Utility.Utility;

public class HomePage {
@FindBy(xpath = "//a[text()='Sales']]")
	private WebElement sale;
	
	
	
	
	Utility utill;
	
	public  HomePage(Utility utill){
		 this.utill=utill;
		 PageFactory.initElements(Utility.getDriver(), this);
	 }
	public void sale() {
		utill.moveToElement(sale);
		
	}
}
