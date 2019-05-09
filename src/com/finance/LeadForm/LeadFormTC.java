package com.finance.LeadForm;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.finance.loanapplication.LoanApplicationsPage;
import com.finance.login.LoginTC;
import com.lms.utilities.BaseTest.*;
import com.lms.utilities.Xls_Reader;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.lms.utilities.BaseTest;



public class LeadFormTC extends BaseTest {
 int j=2;
 //myeclipse
 
 //Testmine
 
	
	@Test

	  public void LeadFormSubmission() throws IOException, InterruptedException {
		userinput();
		LaunchBrowserChrome();
		LoginforLeadCreate();
		Reporter.log("Test case started");
		int MyBank2=MyBank;
		 ReadPropertyFile();
		
		 
		  driver.findElement(By.xpath(properties.getProperty("LoApp"))).click();
		  System.out.println("Loappp click");
		// System.out.println(driver.manage().getCookies());
		// System.out.println("cookie "+ driver.manage().getCookieNamed("XSRF-TOKEN"));
		 driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
			WebDriverWait wait=new WebDriverWait(driver, 10);

		 Xls_Reader x = new Xls_Reader("C:\\Users\\user\\Desktop\\Autoportal\\eclipse\\WorkspaceD\\LMS-Autoportal\\Files\\LoanData.xlsx");
		 
	//Code only for CC Small lead form
		 if(UserType==2 && FormType.equalsIgnoreCase("n")) {
			
		   
				driver.findElement(By.xpath(properties.getProperty("xpathCCAddLeadButtonHeader"))).click();

	        	
	        	WebElement element=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(properties.getProperty("IDCar")))));  //  
				driver.findElement(By.id(properties.getProperty("IDCar"))).sendKeys(x.getCellData("Sheet1","CarName" , j));
				Thread.sleep(1000);
				WebElement element2=wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(properties.getProperty("xpathCarnameclick"))))));  //  

				driver.findElement(By.xpath(properties.getProperty("xpathCarnameclick"))).click();
				for(int j=3;j <=3;j++) {
				
				// driver.findElement(By.name(properties.getProperty("FName"))).sendKeys(x.getCellData("Sheet1","FirstName" , j));
				driver.findElement(By.id(properties.getProperty("IDCCFname"))).sendKeys(manualfirstname);
				 driver.findElement(By.id(properties.getProperty("IDCCLastName"))).sendKeys(x.getCellData("Sheet1","LastName" , j));
				 driver.findElement(By.name(properties.getProperty("MNumName"))).sendKeys(x.getCellData("Sheet1","MobileNumber" , j));
				 Select State=new Select(driver.findElement(By.name(properties.getProperty("StateName"))));
					State.selectByVisibleText(properties.getProperty("Stateval"));
					
					Select City=new Select(driver.findElement(By.name(properties.getProperty("CityName"))));
					City.selectByVisibleText(properties.getProperty("CityVal"));
					Select Sourceoflead=new Select(driver.findElement(By.id(properties.getProperty("IDSouceforCC"))));
					Sourceoflead.selectByVisibleText(properties.getProperty("SourceValue"));
				 
				 driver.findElement(By.name(properties.getProperty("PinCodeName"))).sendKeys(x.getCellData("Sheet1","PinCode" , j));
				
				 driver.findElement(By.xpath(properties.getProperty("XpathCCformSubmitButton"))).click();
				 WebElement ConfirmButton=driver.findElement(By.id(properties.getProperty("ConfirmButtonID")));
				 wait.until(ExpectedConditions.visibilityOf(ConfirmButton));
				 ConfirmButton.click();
		  }
		
		 } 
		 //Above code CC Small form over here
		 
		 //Below Code will execute when User Type is CC/Dealer and form is OLD long form
		 
		 else {
	       	 
		 
			
			for(int j=3;j <=3;j++)
			{
		
		// Thread.sleep(2000);
	      driver.findElement(By.xpath(properties.getProperty("AddCust"))).click();
	      //driver.findElement(By.xpath(properties.getProperty("XpathSkiptoManuallink"))).click();

	      //MyBank2 variable is defined in Base Test. It is taking input from User for Bank which leads should be created.
	      
		   if(MyBank2==1)
			
			//if(x.getCellData("Sheet1","BankName" , j).equalsIgnoreCase("HDFC"))
			{
				
				Select bank=new Select(driver.findElement(By.name(properties.getProperty("Bankname"))));
				bank.selectByVisibleText("HDFC");
				Thread.sleep(1000);
				
			}
			
			else if(MyBank2==3)
				//if(x.getCellData("Sheet1","BankName" , j).equalsIgnoreCase("Magma"))
				
			{
				Select bank=new Select(driver.findElement(By.name(properties.getProperty("Bankname"))));
				bank.selectByVisibleText("Magma");
				
				Thread.sleep(1000);
				
				
			}
			
			else if(MyBank2==2)
				//if(x.getCellData("Sheet1","BankName" , j).equalsIgnoreCase("Yes Bank"))
			{
				
				Select bank=new Select(driver.findElement(By.name(properties.getProperty("Bankname"))));
				bank.selectByVisibleText("YES BANK");
				Thread.sleep(1000);

				
			}
			Thread.sleep(500);
			if(UserType==2) {
				Select Sourceoflead=new Select(driver.findElement(By.id(properties.getProperty("IDSouceforCC"))));
				Sourceoflead.selectByVisibleText(properties.getProperty("SourceValue"));
				
			}
			WebElement element=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(properties.getProperty("IDCar")))));  //  
			driver.findElement(By.id(properties.getProperty("IDCar"))).sendKeys(x.getCellData("Sheet1","CarName" , j));
			Thread.sleep(1000);
			WebElement element2=wait.until(ExpectedConditions.visibilityOf((driver.findElement(By.xpath(properties.getProperty("CarXpath"))))));  //  

			driver.findElement(By.xpath(properties.getProperty("CarXpath"))).click();
			
			driver.findElement(By.id(properties.getProperty("LoanAmID"))).sendKeys(x.getCellData("Sheet1","LoanAmount" , j));
			// driver.findElement(By.name(properties.getProperty("FName"))).sendKeys(x.getCellData("Sheet1","FirstName" , j));
			driver.findElement(By.name(properties.getProperty("FName"))).sendKeys(manualfirstname);
			 driver.findElement(By.name(properties.getProperty("LName"))).sendKeys(x.getCellData("Sheet1","LastName" , j));
			 driver.findElement(By.name(properties.getProperty("MNumName"))).sendKeys(x.getCellData("Sheet1","MobileNumber" , j));
			 Select State=new Select(driver.findElement(By.name(properties.getProperty("StateName"))));
				State.selectByVisibleText(properties.getProperty("Stateval"));
				
				Select City=new Select(driver.findElement(By.name(properties.getProperty("CityName"))));
				City.selectByVisibleText(properties.getProperty("CityVal"));
			 
			 driver.findElement(By.name(properties.getProperty("PinCodeName"))).sendKeys(x.getCellData("Sheet1","PinCode" , j));
			//|| x.getCellData("Sheet1","BankName" , j).equalsIgnoreCase("HDFC")  )
			
			 if(MyBank2==3) {
				
				
				try {
					driver.findElement(By.name(properties.getProperty("DOBName"))).click();

					driver.findElement(By.xpath(properties.getProperty("DOBvalueXpath"))).click();
					
					driver.findElement(By.xpath(properties.getProperty("DOB2"))).click();
					 
					driver.findElement(By.xpath(properties.getProperty("DOB3"))).click();
					 
					 driver.findElement(By.xpath(properties.getProperty("DOB3"))).click();
					 
					driver.findElement(By.xpath(properties.getProperty("DOB41990"))).click();
					 
					driver.findElement(By.xpath(properties.getProperty("DOB5Feb"))).click();
					
					driver.findElement(By.xpath(properties.getProperty("DOB61feb"))).click();
					Select Tenure=new Select(driver.findElement(By.name(properties.getProperty("EMITenureName"))));
					Tenure.selectByVisibleText(properties.getProperty("TenureVal30"));
					driver.findElement(By.id(properties.getProperty("IDAltrnateNo"))).sendKeys("8888777744");

					driver.findElement(By.id(properties.getProperty("IDLocation"))).sendKeys("Dwarka");

					driver.findElement(By.id(properties.getProperty("IDSubLocation"))).sendKeys("Dwarka Sec-8");
					driver.findElement(By.id(properties.getProperty("FathNameID"))).sendKeys(x.getCellData("Sheet1","FatherName" , j));
					 driver.findElement(By.name(properties.getProperty("PanName"))).sendKeys(x.getCellData("Sheet1","PANCard" , j));



					driver.findElement(By.id(properties.getProperty("IDRequirementDate"))).click();

					driver.findElement(By.xpath(properties.getProperty("XpathReqDate"))).click();
					
					driver.findElement(By.xpath(properties.getProperty("MagmaHDFCSubmitButtonXpath"))).click();


						}
				
				catch(Exception E) {}
				
				}
			
			 //Below code is for Yes Bank
			if(MyBank2==2 || MyBank2==1 )
			// if(MyBank2==1)
			
			{	 
			
			
			
			 Thread.sleep(2000);
	        
			//driver.findElement(By.id(properties.getProperty("IDCar"))).sendKeys(properties.getProperty("Carname"));
			
			Select Tenure=new Select(driver.findElement(By.name(properties.getProperty("EMITenureName"))));
			Tenure.selectByVisibleText(properties.getProperty("TenureVal30"));
			Select Gendre=new Select(driver.findElement(By.name(properties.getProperty("GendreName"))));
			Gendre.selectByVisibleText(properties.getProperty("GendreValMal"));
			driver.findElement(By.name(properties.getProperty("DOBName"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(properties.getProperty("YesDOBvalueXpath"))).click();
			
			driver.findElement(By.xpath(properties.getProperty("YesDOB2"))).click();
			 
			driver.findElement(By.xpath(properties.getProperty("YesDOB3"))).click();
			 
			 driver.findElement(By.xpath(properties.getProperty("YesDOB3"))).click();
			 
			driver.findElement(By.xpath(properties.getProperty("YesDOB41990"))).click();
			 
			driver.findElement(By.xpath(properties.getProperty("YesDOB5Feb"))).click();
			
			driver.findElement(By.xpath(properties.getProperty("YesDOB61feb"))).click();
			 Thread.sleep(1000);
			Select Residence=new Select(driver.findElement(By.name(properties.getProperty("ResidenceName"))));
			Residence.selectByVisibleText(properties.getProperty("ResVal"));
			Select LivingSince=new Select(driver.findElement(By.name(properties.getProperty("LivingSinceName"))));
			LivingSince.selectByVisibleText(properties.getProperty("LivSinceval"));
			Select State1=new Select(driver.findElement(By.name(properties.getProperty("StateName"))));
			State.selectByVisibleText(properties.getProperty("Stateval"));
			
			Select City1=new Select(driver.findElement(By.name(properties.getProperty("CityName"))));
			City.selectByVisibleText(properties.getProperty("CityVal"));
			driver.findElement(By.id(properties.getProperty("Address3ID"))).sendKeys(x.getCellData("Sheet1","Address3" , j));
			driver.findElement(By.id(properties.getProperty("CustLandID"))).sendKeys(x.getCellData("Sheet1","Landmark" , j));
			driver.findElement(By.id(properties.getProperty("FathNameID"))).sendKeys(x.getCellData("Sheet1","FatherName" , j));
			
			Select MarStatus=new Select(driver.findElement(By.name(properties.getProperty("MarStatID"))));
			MarStatus.selectByVisibleText(properties.getProperty("MarStaVal"));
			driver.findElement(By.id(properties.getProperty("PlaceOBID"))).sendKeys(x.getCellData("Sheet1","Placeofbirth" , j));
			driver.findElement(By.id(properties.getProperty("MotherMNid"))).sendKeys(x.getCellData("Sheet1","MotherName" , j));
			driver.findElement(By.id(properties.getProperty("OffAddID"))).sendKeys(x.getCellData("Sheet1","OffAdd1" , j));
			driver.findElement(By.id(properties.getProperty("OffAdd2ID"))).sendKeys(x.getCellData("Sheet1","OffAdd2" , j));
			driver.findElement(By.id(properties.getProperty("OffLandID"))).sendKeys(x.getCellData("Sheet1","OffLand" , j));
			driver.findElement(By.id(properties.getProperty("OffPinCode"))).sendKeys(x.getCellData("Sheet1","OffPincode" , j));
			Select Offstat=new Select(driver.findElement(By.name(properties.getProperty("OffStatename"))));
			Offstat.selectByVisibleText(properties.getProperty("OffStatevalue"));
			Select CityName=new Select(driver.findElement(By.id(properties.getProperty("OffCityID"))));
			CityName.selectByVisibleText(properties.getProperty("OffCityvalue"));
			Select Religion=new Select(driver.findElement(By.id(properties.getProperty("RelID"))));
			Religion.selectByVisibleText(properties.getProperty("RelValue"));
			Select Cast=new Select(driver.findElement(By.id(properties.getProperty("CastID"))));
			Cast.selectByVisibleText(properties.getProperty("CastVal"));
			Select ProfessQualification=new Select(driver.findElement(By.id(properties.getProperty("ProfQual1ID"))));
			ProfessQualification.selectByVisibleText(properties.getProperty("ProdQualValue"));
			Select NoOfInde=new Select(driver.findElement(By.id(properties.getProperty("NoOfIndID"))));
			NoOfInde.selectByVisibleText(properties.getProperty("NOInValue"));
			//Reference 1 Details
			driver.findElement(By.id(properties.getProperty("Ref1FNID"))).sendKeys(x.getCellData("Sheet1","Ref1FirstName" , j));
			driver.findElement(By.id(properties.getProperty("Ref1LNID"))).sendKeys(x.getCellData("Sheet1","Ref1LastName" , j));
			driver.findElement(By.id(properties.getProperty("Ref1RelaID"))).sendKeys(x.getCellData("Sheet1","Ref1Relation" , j));
			driver.findElement(By.id(properties.getProperty("Ref1MobID"))).sendKeys(x.getCellData("Sheet1","Ref1Mobile" , j));
			
			//Reference 2 Details
			driver.findElement(By.id(properties.getProperty("Ref2FNID"))).sendKeys(x.getCellData("Sheet1","Ref2FirstName" , j));
			driver.findElement(By.id(properties.getProperty("Ref2LNID"))).sendKeys(x.getCellData("Sheet1","Ref2LastName" , j));
			driver.findElement(By.id(properties.getProperty("Ref2RelaID"))).sendKeys(x.getCellData("Sheet1","Ref3Relation" , j));
		
			
			
			
			
			
			
			
			
			
			
			 driver.findElement(By.name(properties.getProperty("EmailName"))).sendKeys(x.getCellData("Sheet1","EmailID" , j));
			 driver.findElement(By.name(properties.getProperty("Address1Name"))).sendKeys(x.getCellData("Sheet1","AddressLine1" , j));
			 driver.findElement(By.name(properties.getProperty("Address2Name"))).sendKeys(x.getCellData("Sheet1","AddressLine2" , j));
			
			//Read from Excel File
		   
			
			//If Profession Type is Salaried
			
			//if(x.getCellData("Sheet1","ProfessionType" , j).equalsIgnoreCase("Salaried"))
			 if(typeofcustomer.equalsIgnoreCase("s"))
			{
			
				Select ProType=new Select(driver.findElement(By.id(properties.getProperty("ProTypeID"))));
				ProType.selectByVisibleText(properties.getProperty("ProfVal"));
				Select IndType=new Select(driver.findElement(By.name(properties.getProperty("IndType"))));
				IndType.selectByVisibleText(properties.getProperty("IndVal"));
				Select ExistAccID=new Select(driver.findElement(By.id(properties.getProperty("ExistAccID"))));
				ExistAccID.selectByVisibleText(properties.getProperty("ExistingVal"));
				int rcount=x.getRowCount("Sheet1");
				 
					 
				 driver.findElement(By.name(properties.getProperty("ExperienceName"))).sendKeys(x.getCellData("Sheet1","Experience" , j));
				 driver.findElement(By.name(properties.getProperty("CompName"))).sendKeys(x.getCellData("Sheet1","CompanyName" , j));
				 driver.findElement(By.name(properties.getProperty("MonSalaID"))).sendKeys(x.getCellData("Sheet1","MonthlySalary" , j));
				 driver.findElement(By.name(properties.getProperty("PanName"))).sendKeys(x.getCellData("Sheet1","PANCard" , j));
					
			}
			
			//If Profession Type is Self Employed
			else if(typeofcustomer.equalsIgnoreCase("se"))
			{
				Select ProType=new Select(driver.findElement(By.id(properties.getProperty("ProTypeID"))));
				ProType.selectByVisibleText(properties.getProperty("ProfVal2"));
				Select ITRAudited=new Select(driver.findElement(By.id(properties.getProperty("ITRAuditedID"))));
				ITRAudited.selectByVisibleText(properties.getProperty("ITRVal"));
				
				Thread.sleep(1000);
				Select Profession=new Select(driver.findElement(By.id(properties.getProperty("ProfessionID1"))));
				Profession.selectByVisibleText(properties.getProperty("ProfessionVal"));
				
				Select ExistAccID2=new Select(driver.findElement(By.id(properties.getProperty("ExistAccSelfID"))));
				ExistAccID2.selectByVisibleText(properties.getProperty("ExistingVal"));
			
			
					 driver.findElement(By.name(properties.getProperty("OperatingMonthsName"))).sendKeys(x.getCellData("Sheet1","OperatingSince" , j));
					 driver.findElement(By.name(properties.getProperty("FirmName"))).sendKeys(x.getCellData("Sheet1","FirmName" , j));
					 
					 driver.findElement(By.id(properties.getProperty("NetMonthIncID"))).sendKeys(x.getCellData("Sheet1","NetMonthlyIncome" , j));
					 driver.findElement(By.id(properties.getProperty("PreYearProfID"))).sendKeys(x.getCellData("Sheet1","LastYearProfit" , j));
					 driver.findElement(By.name(properties.getProperty("LastYearProfID"))).sendKeys(x.getCellData("Sheet1","LastYearAfterProfit" , j));
					 driver.findElement(By.name(properties.getProperty("PanName"))).sendKeys(x.getCellData("Sheet1","PANCard" , j));
				
							 
			
			 }
			driver.findElement(By.id(properties.getProperty("Ref2MobID"))).sendKeys(x.getCellData("Sheet1","Ref2Mobile" , j));
			
			//Upload File
			driver.findElement(By.xpath(properties.getProperty("UploadNowPanxpath"))).click();
			 Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\Test.exe");
			 Thread.sleep(3000);
			 try {
		    driver.findElement(By.xpath(properties.getProperty("UploadNowSalxpath"))).click();
			 Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\Test.exe");
			 Thread.sleep(3000);
			 
			
			 driver.findElement(By.xpath(properties.getProperty("UploadNowSalxpath"))).click();
			 Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\Test.exe");
			 Thread.sleep(3000);
			 
			 driver.findElement(By.xpath(properties.getProperty("UploadNowSalxpath"))).click();
			 Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\Test.exe");
			 Thread.sleep(3000);
			 }
			 catch(Exception B) {
				 
				 System.out.println("No Sal");
			 }
			 JavascriptExecutor js = (JavascriptExecutor) driver;  
			 js.executeScript("window.scrollBy(0,900)");
			 try {
            driver.findElement(By.xpath(properties.getProperty("UploadNowFormxpath"))).click();
			 Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\Test.exe");
			 Thread.sleep(3000);
			 }
			 catch(Exception E)
			 {
				 System.out.println(E);
			 }
			 
			 driver.findElement(By.xpath(properties.getProperty("UploadNowAccountxpath"))).click();
			 Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\Test.exe");
			 Thread.sleep(3000);
			
			 
			 js.executeScript("window.scrollBy(0,900)");
			 Thread.sleep(3000);
			 try {
				 driver.findElement(By.xpath(properties.getProperty("UploadNowComputationXpath"))).click();
				 Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\Test.exe");
				 Thread.sleep(3000);
				 }
				 catch(Exception E)
				 {
					 System.out.println(E);
				 }
			
			 Select AddType=new Select(driver.findElement(By.id(properties.getProperty("AddressTypeID"))));
			 AddType.selectByVisibleText(properties.getProperty("AddressTypeVal"));
			 js.executeScript("window.scrollBy(0,800)");
			
			 driver.findElement(By.xpath(properties.getProperty("UploadNowAddressxpath"))).click();
			 Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\Test.exe");
			 Thread.sleep(3000);
			
			
			// if(x.getCellData("Sheet1","ProfessionType" , j).equalsIgnoreCase("Salaried"))
			 if(MyBank==2 && typeofcustomer.equalsIgnoreCase("s"))
			 {
				 driver.findElement(By.xpath(properties.getProperty("Saveasdraftxpath"))).click();
				 
			 }
			}
			 Thread.sleep(1000);
			 try {
			 driver.findElement(By.xpath(properties.getProperty("YesSubmitButtonXpath"))).click();
			 }
			 catch(Exception a) {
				 
				 System.out.println("Error in Submit Button");
			 }
			 
			 WebElement ConfirmButton=driver.findElement(By.id(properties.getProperty("ConfirmButtonID")));
			 wait.until(ExpectedConditions.visibilityOf(ConfirmButton));
			 ConfirmButton.click();
			 Reporter.log("Test End");
			
			
			
			 
			}
		 }
			}


		 
	 }

	
	
	

