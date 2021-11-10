package com.evs.LoginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.Utility.Utility;

public class Login  {

	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement userName;
	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement password;
	@FindBy(xpath = "//select[@name='login_theme']") 
	private WebElement color;
	@FindBy(xpath="//select[@name='login_language']")
	private WebElement language;
	@FindBy(xpath = "//input[@name='Login']")
	private WebElement log;
	
	Utility utill;


	public Login( Utility utill) {
		this.utill=utill;
		PageFactory.initElements(Utility.getDriver(), this);
	}
	public void  validLogin() {

		utill.sendkeys(userName, "admin");
		utill.sendkeys(password, "admin");
		utill.selecIndex(color, 0);
		utill.selecIndex(language, 0);
		utill.click(log);
	}


}
