package com.finance.loanapplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.lms.utilities.BaseTest;

public class LoanApplicationPageObject extends BaseTest {
	
	
	public void VerifyLoanApplicationPageUI() throws InterruptedException, IOException {
		
	    //Verify Add Customer Coloumn is appearing
		driver.findElement(By.xpath(properties.getProperty("XpathAddCustIcon"))).isDisplayed();
		
		//Verify Created On Coloumn is appearing
		driver.findElement(By.xpath(properties.getProperty("XpathColCreatedOn"))).isDisplayed();
		
		//Verify Customer Details Coloumn is appearing
		driver.findElement(By.xpath(properties.getProperty("XpathColCustomerDetails"))).isDisplayed();
		
		//Verify Bank Name Coloumn is appearing
		driver.findElement(By.xpath(properties.getProperty("XpathBank"))).isDisplayed();
		
		//Verify Last Update Coloumn is appearing

		driver.findElement(By.xpath(properties.getProperty("XpathLast"))).isDisplayed();
		
		//Verify Follow Up Coloumn is appearing

		driver.findElement(By.xpath(properties.getProperty("XpathFolow"))).isDisplayed();
		
		//Verify Booking Date Coloumn is appearing

		driver.findElement(By.xpath(properties.getProperty("XpathBookingDate"))).isDisplayed();
		
		//Verify OTP Status Coloumn is appearing

		driver.findElement(By.xpath(properties.getProperty("XpathOTPStatus"))).isDisplayed();
		
		//Verify CashE Coloumn is appearing

		driver.findElement(By.xpath(properties.getProperty("XpathCaseE"))).isDisplayed();
		
		//Verify Status Coloumn is appearing
		driver.findElement(By.xpath(properties.getProperty("XpathStatus"))).isDisplayed();
		
		//Verify Agent Name Coloumn is appearing
		driver.findElement(By.xpath(properties.getProperty("XpathAgentName"))).isDisplayed();
		
		//Verify Link Sent on Coloumn is appearing
		driver.findElement(By.xpath(properties.getProperty("XpathLinkSentOn"))).isDisplayed();
		


		 
		
		
		
	}

}
