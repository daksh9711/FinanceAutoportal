package com.finance.SignUp;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.xml.LaunchSuite;

import com.lms.utilities.BaseTest;
import com.lms.utilities.Xls_Reader;

public class SignUp extends BaseTest{
	int j=2;
	
	
	@Test
	public void SingupFunctionality() throws InterruptedException, IOException {
		
		LaunchBrowserChrome();
		ReadPropertyFileSignUp();
		
		
		  Xls_Reader g=new Xls_Reader(System.getProperty("user.dir")+"\\Files\\SignUpData.xlsx");
		
		//Click on Signup link present on Login page
		  driver.findElement(By.xpath(properties.getProperty("XpathSignUpLink"))).click();
		  
		//Send Data in Organisation name field
	      driver.findElement(By.name(properties.getProperty("NameOrgname"))).sendKeys(g.getCellData("Sheet1","OrganisationName", j));

		 //Send Data in Address field
		  driver.findElement(By.name(properties.getProperty("Nameaddress"))).sendKeys(g.getCellData("Sheet1","Address", j));
		  
		  //Send Data in Locality field
		  driver.findElement(By.name(properties.getProperty("NameLocality"))).sendKeys(g.getCellData("Sheet1","Locality", j));
		  
		  //Select value from State Dropdown
		  Select State=new Select(driver.findElement(By.name(properties.getProperty("NameState"))));
		  
		  State.selectByVisibleText("Delhi");
		  Thread.sleep(1000);
		  
		  //Select value from City dropdown
		  Select City=new Select(driver.findElement(By.name(properties.getProperty("NameCity"))));
		  
		  City.selectByVisibleText(("New Delhi"));
		  
		  //Send Data in Pan No. field
		  driver.findElement(By.name(properties.getProperty("NamePanno"))).sendKeys(g.getCellData("Sheet1","Panno", j));
		  
		  //Click on Pan no. doc upload field.
		  driver.findElement(By.name(properties.getProperty("NamePandoc"))).click();
		  
		  //Uploading doc
		  Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\Test.exe");
		  Thread.sleep(3000);
		  
		  //Send Data in GST no. field
		  driver.findElement(By.name(properties.getProperty("NameGSTno"))).sendKeys(g.getCellData("Sheet1","GSTno", j));
		  Thread.sleep(3000);
		  
		  //Click on GST doc upload link
		  driver.findElement(By.name(properties.getProperty("NameGSTDoc"))).click();
		  
		  //Uploading Doc
		  Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\Test.exe");
		  Thread.sleep(1000);
		  
		  //Send Data in Certificate no. field
		  driver.findElement(By.name(properties.getProperty("NameCertificateNo"))).sendKeys(g.getCellData("Sheet1","Certficateno", j));
		  
		  //Click on Certificate doc upload link
		  driver.findElement(By.name(properties.getProperty("NameBusineesDoc"))).click(); 
		  Thread.sleep(3000);
		  
		  //Uploading Doc
		  Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\Test.exe");
		  Thread.sleep(1000);
		  
		  //Click on Next button
		  WebElement element =driver.findElement(By.xpath(properties.getProperty("XpathFirstStageNextbutt"))); 
		  JavascriptExecutor js= (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click();", element); 
		  Thread.sleep(2000);
		  
		  //Send data in Signing Authority Name field
		  driver.findElement(By.name(properties.getProperty("NameSignAutName"))).sendKeys(g.getCellData("Sheet1","GMName", j));
		  
		  //Send data in Mobile Field
		  driver.findElement(By.name(properties.getProperty("NameSignMobile"))).sendKeys(g.getCellData("Sheet1","GMMobileNo", j));
		  
		  //Send data in Email field
		  driver.findElement(By.name(properties.getProperty("NameSignAuthEmail"))).sendKeys(g.getCellData("Sheet1","GMEmail", j));
		  
		  //Send data in Finance Name field
		  driver.findElement(By.name(properties.getProperty("NameFinName"))).sendKeys(g.getCellData("Sheet1","FinName", j));
		  
		  //Send data in Mobile field
		  driver.findElement(By.name(properties.getProperty("NameFinMobile"))).sendKeys(g.getCellData("Sheet1","FinMobileNumber", j));
		  
		  //Send data in Email field
		  driver.findElement(By.name(properties.getProperty("NameFinEmail"))).sendKeys(g.getCellData("Sheet1","FinEmail", j));
		  
		  WebElement element2 = driver.findElement(By.xpath(properties.getProperty("XpathSecondStageProceedButt"))); 
		  
		  //CLick on Proceed button
		  JavascriptExecutor js2=(JavascriptExecutor) driver; js2.executeScript("arguments[0].click();",element2);
		  
		  //Send data in Account Holder Name field
		  driver.findElement(By.name(properties.getProperty("NameBankAccountHname"))).sendKeys(g.getCellData("Sheet1","AccountHolderName", j));
		  
		  //Select value from Bank Name dropdown
		  Select BankName=new Select(driver.findElement(By.name(properties.getProperty("NameBankname"))));
	       BankName.selectByVisibleText("Axis Bank");
	       
		  //Send data in Account no. field
		  driver.findElement(By.name(properties.getProperty("NameAccntNo"))).sendKeys(g.getCellData("Sheet1","AccountNo", j));
		  
		  //Send data in IFSC code field
		  driver.findElement(By.name(properties.getProperty("NameIFSCCode"))).sendKeys(g.getCellData("Sheet1","IFSCCode", j));
		  
		  //Send data in Branch field
		  driver.findElement(By.name(properties.getProperty("NameBranchAdd"))).sendKeys(g.getCellData("Sheet1","BranchAddress", j));
		 // driver.findElement(By.name(properties.getProperty("NameBranchAdd"))).sendKeys("test");
		  
		  //Click on Upload check doc link
		  driver.findElement(By.name(properties.getProperty("NameUploadCheckDOc"))).click();
		  Thread.sleep(3000);
		  
		  //Uploading Doc
		  Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\Test.exe");
          Thread.sleep(3000);
		  WebElement element3 =driver.findElement(By.xpath(properties.getProperty("XpathThirdStageSignUpButt"))); 
		  JavascriptExecutor js3= (JavascriptExecutor)driver; 
		  
		  //Click on Sign Up button
		  js3.executeScript("arguments[0].click();", element3);

		  //Verify ThankYou message is displayed after Sign up
		  driver.findElement(By.xpath(properties.getProperty("XpathThankYouMessage"))).isDisplayed();
		  
		 
		
		
		
		
		
	}

}
