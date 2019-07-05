package com.finance.LeadForm;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.lms.utilities.BaseTest;

import junit.framework.Assert;

public class LeadFormPageObject extends BaseTest {
	
	@Test(enabled=false)
	public void VerifyLeadFormUI() throws InterruptedException, IOException {
		LaunchBrowserChrome();
		Login();
		ReadPropertyFile();
		
		
		//Verify Car Finance Application Heading is visible on page
		ReadPropertyFile();
		//Click on Loan Application Page
		  driver.findElement(By.xpath(properties.getProperty("LoApp"))).click();
		  //Click on Details button present on Lead Tab
		  driver.findElement(By.xpath(properties.getProperty("XpathLoanAppDetailButt"))).click();
		  Thread.sleep(2000);
		/*
		 * String actual="Car Finance Application"; String
		 * rel=driver.findElement(By.xpath(properties.getProperty("XpathLeadFormHeading"
		 * ))).getText(); assertEquals(actual, rel);
		 */
	//	driver.findElement(By.xpath(properties.getProperty("XpathLeadFormHeading"))).isDisplayed();
		
		//Verify Car Details Heading is visible on page

		driver.findElement(By.xpath(properties.getProperty("XpathLeadFormCarDetails"))).isDisplayed();

		
		
		
		
		
	}
   

}
