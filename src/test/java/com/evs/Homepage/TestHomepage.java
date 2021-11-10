package com.evs.Homepage;

import org.testng.annotations.Test;

import com.evs.LoginPage.Login;
import com.evs.home.HomePage;
import com.evs.testBase.TestBasePage;

public class TestHomepage extends TestBasePage{
	@Test
public void homePage() {
Login log=	new Login(utill);
HomePage home=	new HomePage(utill);
	home.sale();
	
	
}
	
	
	
	
	
}
