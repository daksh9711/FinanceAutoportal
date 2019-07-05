package com.finance.login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.lms.utilities.BaseTest;

public class LoginPageObject extends BaseTest{
	
	@Test
	public void VerifyLoginPageUI() throws InterruptedException, IOException {
		
		LaunchBrowserChrome();
		ReadPropertyFile();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(properties.getProperty("CSSEmail"))).isDisplayed();
		
		driver.findElement(By.cssSelector(properties.getProperty("CSSPassword"))).isDisplayed();

		driver.findElement(By.xpath("//button[contains(.,'Login')]")).isDisplayed();
		
		driver.findElement(By.cssSelector(properties.getProperty("CSSForgotPass"))).isDisplayed();
		driver.findElement(By.cssSelector(properties.getProperty("CSSSignUpLink"))).isDisplayed();

		
		


	//	driver.findElement(By.cssSelector(properties.getProperty("")));

		//driver.findElement(By.cssSelector(properties.getProperty("")));

		
		
	

}}
