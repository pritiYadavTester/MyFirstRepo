package com.evs.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.io.Files;

public class Utility {

	static  WebDriver driver;
	 
	 public static WebDriver getDriver() {
		 return driver;
	 }

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=	new ChromeDriver();
	}	
	public void openUrl(String url) {
		driver.get(url);	
	}
	public void getElement(String locator,String path) {
		
		if(locator.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(path));
		}else if(locator.equalsIgnoreCase("id")) {
			driver.findElement(By.id(path));
		}else if(locator.equalsIgnoreCase("name")) {
			driver.findElement(By.name(path));
		}else if(locator.equalsIgnoreCase("parcialLinkText")) {
			driver.findElement(By.partialLinkText(path));
		}else if(locator.equalsIgnoreCase("tagName")){
			driver.findElement(By.tagName(path));
		}
	}
		

	public void sendkeys( WebElement we ,String sendkeys) {

		we.sendKeys(sendkeys);
	}
	public void  click(WebElement we) {
		we.click();
	}

	public void getCurrentUrl() {
		driver.getCurrentUrl();
	}
	public void close() {
		driver.close();
	}
	public void Quiet() {
		driver.quit();
	}
	public void selecIndex(WebElement we,int num ) {
		Select index=	new Select(we);
		index.selectByIndex(num);
	}
	public void selectByValue(WebElement we,String str) {
		Select value=new Select(we);
		value.selectByValue(str);
	}

	public void selectByVisualText(WebElement we,String str) {
		Select value=new Select(we);
		value.selectByValue(str);


	}
	public void takeScreenShot() {


		TakesScreenshot screen=(TakesScreenshot)driver;
		File file=screen.getScreenshotAs(OutputType.FILE);
		File  file2= new File("priti.png");
		try {
			Files.copy(file, file2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void windowHandle(String exptitle) {
		Set<String>	 handles=driver.getWindowHandles();
		for(String handle:handles) {
			driver.switchTo().window(handle);
			String actitle=	driver.getTitle();
			if(actitle.equalsIgnoreCase(exptitle)) {
				driver.close();
			}
		}


	}
	public void verifyGetAttributename(WebElement we,String attributeName) {
String str=	we.getAttribute(attributeName);
Assert.assertEquals(str,true);
}
	
	
	public void moveToElement(WebElement we) {
	Actions act=	new Actions(driver);
	act.moveToElement(we).build().perform()	;
	}
	public void dragAndDrop(WebElement target,WebElement source) {
		Actions act=	new Actions(driver);
act.dragAndDrop(source, target).build().perform();

}

public void doubleClick(WebElement we) {
	Actions act=	new Actions(driver);
	act.doubleClick().build().perform();
}
public void verifyIsEleabled(WebElement we) {
	boolean   web=we.isEnabled();
	Assert.assertEquals(web, true);
}

public void verifyIsSelected(WebElement we) {
	boolean   web=we.isSelected();
	Assert.assertEquals(web, true);
}
public void verifyIsDisplayed(WebElement we) {
	boolean   web=we.isDisplayed();
	Assert.assertEquals(web, true);

}
public Workbook getWorkbook(String filePath) {
String[] filePathArr=	filePath.split("//.");
String   extention =filePathArr[1];

Workbook workbook = null;
if(extention.equalsIgnoreCase("xlsx")) {
workbook =new XSSFWorkbook();
}else if(extention.equalsIgnoreCase("xls")){
	workbook =new HSSFWorkbook();
}else {
	System.out.println("extention is wrong");
}
return workbook;
}

public Sheet getSheet(String sheet,Workbook workbook ) {
	
Sheet sheetObj =workbook.getSheet(sheet);
return sheetObj;
}

public Row getRow(Sheet sheet,int num ) {
	Row rowObj=sheet.getRow(num);
	return rowObj;
}
public void getCellNumByCellName(Row rowObj, String expCellVal) {
	int cellNum =-1;
 int cellCount=  rowObj.getLastCellNum();
 for(int i= 0;i< cellCount;i++) {
	Cell cellObj= rowObj .getCell(i);
	String   cellvalue  =cellObj.getStringCellValue();
	if(cellvalue.equalsIgnoreCase(expCellVal)) {
	cellNum=i;	
	}
 }
}
}