package com.finance.Dashboard;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.lms.utilities.BaseTest;

public class DashboardTC extends BaseTest{
	
	
	
	@Test
	
	public void VerifyDashboardFunctionality() throws IOException, InterruptedException {
		
		//ReadPropertyFile();
	//	LoginFunctionality();
		LaunchBrowserChrome();
		Login();
		ReadPropertyFileDashboard();

		
   
//	driver.findElement(By.xpath("//*[@id=\"tags\"]")).sendKeys("Maruti Suzuki Alto 800 STD");
		driver.findElement(By.xpath(properties.getProperty("carfield"))).sendKeys("Maruti Suzuki Alto 800 STD");
	driver.findElement(By.xpath(properties.getProperty("carfield"))).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath(properties.getProperty("XpathSortByBankbutton"))).click();
	driver.findElement(By.xpath(properties.getProperty("XpathSortByBankbutton"))).click();
	Thread.sleep(1000);
	//Verify Filter Button is visible
	driver.findElement(By.xpath(properties.getProperty("XpathVarifyFilterbutton"))).isDisplayed();
	Thread.sleep(1000);
    String actualtext=driver.findElement(By.xpath(properties.getProperty("XpathTentativetext"))).getText();
	String expectedtext="Tentative Ex-Showroom Price -";
	Assert.assertEquals(actualtext, expectedtext);
	//Check that Showroom price is Visible
	Boolean showroomprice=driver.findElement(By.xpath(properties.getProperty("XpathShowRoomPricetext"))).isDisplayed();
	System.out.println("Visibility of Showroom price is "+showroomprice);
	//Check that Yes Bank row is visible
	Boolean YesBankRow=driver.findElement(By.xpath(properties.getProperty("XpathYesBankRow"))).isDisplayed();
	System.out.println("Visibility of Yes Bank Row is "+YesBankRow);
	Thread.sleep(1000);
	//Check that Apply button is working .
	//Click on HDFC APPLY button
	
	driver.findElement(By.xpath(properties.getProperty("XpathHDFCApplyButton"))).click();
	//Verify navigating to KYC form on Apply button click
   String actualtext1="Car Finance Application";
   String expectedtext1=driver.findElement(By.xpath(properties.getProperty("XpathCarFinApptextKYCForm"))).getText();
	Assert.assertEquals(actualtext1, expectedtext1);
	Thread.sleep(1000);
	driver.navigate().back();
	Thread.sleep(1000);
	driver.findElement(By.xpath(properties.getProperty("carfield"))).sendKeys(Keys.ENTER);
	Reporter.log("End of Dashboard Test");
	
	}
	
}
	
	

	



//	driver.findElement(By.id("ui-id-2")).click();
		
