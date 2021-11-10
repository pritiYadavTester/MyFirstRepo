package com.evs.Homepage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class CalssScreenShot {

	public static void main(String[] args) {
		CalssScreenShot shot=	new	CalssScreenShot();
		shot.launchBrwoser();

	}
	 WebDriver driver;
public   void launchBrwoser() {
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.get("http://localhost:8888");
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='Login']")).click();
	TakesScreenshot    scrren=(TakesScreenshot)driver;
	File getScrren=scrren.getScreenshotAs(OutputType.FILE);
	File  file=new File("priti.png");
	try {
		Files.copy(getScrren, file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
