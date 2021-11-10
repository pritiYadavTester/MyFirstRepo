package com.evs.Login;

import org.testng.annotations.Test;

import com.evs.LoginPage.Login;
import com.evs.testBase.TestBasePage;

public class TestLogin extends TestBasePage{
@Test


public void testLogin () {
	Login  log=new Login(utill);
	log.validLogin();
	

}
	

}
