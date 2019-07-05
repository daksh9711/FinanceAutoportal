package com.finance.loanapplication;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.hamcrest.core.IsEqual;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.finance.LeadForm.LeadFormPageObject;
import com.finance.login.LoginTC;
import com.lms.utilities.BaseTest;
import com.lms.utilities.Xls_Reader;


public class LoanApplicationsPage extends BaseTest {
	
	Alert alert;
	 int LeadCountInt;
	 String LeadCountString;
	 String strPending;
		

		String strCompleted;
		String strAppoint;
		String strLost;
		String Alpha;
		int j=2;
		//private int today;
		LoanApplicationPageObject objloanclass=new LoanApplicationPageObject();
	
		
		@Test
		
		   public void UpdateLeadFollowStatusFuncionality() throws InterruptedException, IOException {
			
			
			LaunchBrowserChrome();
			Login();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			WebDriverWait wait=new WebDriverWait(driver, 15);
            //Read Property File from BaseTest for Loan Application Page
			ReadPropertyFileLoanApplicationPage();
			//Click on Loan Application Link on Header
			driver.findElement(By.xpath(properties.getProperty("LoApp12"))).click();
			Thread.sleep(3000);
			//Click on Pending Application Tab
			driver.findElement(By.id(properties.getProperty("IDPendingApplicationTab"))).click();
			
			//Click on Missed tab of Pending Application tab
		driver.findElement(By.xpath(properties.getProperty("XpathPendingAppMissed"))).click();
			Thread.sleep(3000);
			//Verify UI of Loan Application page(From Pending Application tab  - Missed Tab)
			objloanclass.VerifyLoanApplicationPageUI();
			
			Thread.sleep(2000);
			//CLick on Edit Button under Last Update coloumn
		   driver.findElement(By.xpath(properties.getProperty("XpathEditButtonLaUpCol"))).click();
		   Thread.sleep(1000);
		   //Select Value from Sub status dropdown of Next Follow up pop up
			Select Substatus=new Select(driver.findElement(By.id(properties.getProperty("IDsubstatusdrop"))));
			//Click on CallBack value
			Substatus.selectByVisibleText(properties.getProperty("FollowupSubStatValue"));
			
			//Code to Take out current Date and splitting it into Day,Month and Year
			
			 Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
			 
	        //Get Current Day as a number
	        int day1 = calendar.get(Calendar.DAY_OF_MONTH);
	       int todayday=day1+1;
	        String day=Integer.toString(todayday);

	        int mon = calendar.get(Calendar.MONTH);
	        int month1=mon+1;
	        String currmonth=Integer.toString(month1);
	        
	        int curryear = calendar.get(Calendar.YEAR);
	        String CurrYear=Integer.toString(curryear);
	        String Mydate=CurrYear+"-0"+currmonth+"-"+day;
	        //Code of splitting date ends here
	        //Sending My Date in Calendar
	        driver.findElement(By.id(properties.getProperty("IDDateCalendar"))).sendKeys(Mydate);
	        Thread.sleep(1000);
	        //Click on Hours dropdown
	       driver.findElement(By.id("followup_hours")).click();
	       //Select value from Hour dropdown
	        Select Hour=new Select(driver.findElement(By.id(properties.getProperty("IDHourDrop"))));
	        //Select on 16 value
	        Hour.selectByVisibleText(properties.getProperty("HourValue"));
	        //Select value from Mint. dropdown
			Select Sec=new Select(driver.findElement(By.id(properties.getProperty("IDMindrop"))));
			//Select Minute value i.e 0
			Sec.selectByVisibleText(properties.getProperty("MinuteVaue"));
			//Send comment in comment box
			driver.findElement(By.id(properties.getProperty("IDcommentbox"))).sendKeys(properties.getProperty("CommentValue"));
			//Click on Submit button
			WebElement elemente =driver.findElement(By.xpath(properties.getProperty("XpathPopupSubmitButt"))); 
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", elemente); 
			Thread.sleep(10000);
			//Click on Missed Tab of Pending tab to check that pop up is removed
			driver.findElement(By.xpath(properties.getProperty("XpathPendingAppMissed"))).click();
			Thread.sleep(2000);
			
			//Test Case - Check that Send button of CashE is functional
			ReadPropertyFile();
			Xls_Reader x = new Xls_Reader("C:\\Users\\user\\Desktop\\Autoportal\\eclipse\\WorkspaceD\\LMS-Autoportal\\Files\\LoanData.xlsx");
			driver.findElement(By.xpath(properties.getProperty("xpathCCAddLeadButtonHeader"))).click();
			WebElement element=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(properties.getProperty("IDCar")))));  //  
			driver.findElement(By.id(properties.getProperty("IDCar"))).sendKeys(x.getCellData("Sheet1","CarName" , j));
			Thread.sleep(1000);
			WebElement element2=wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(properties.getProperty("xpathCarnameclick"))))));  //  

			driver.findElement(By.xpath(properties.getProperty("xpathCarnameclick"))).click();
			
			
			 driver.findElement(By.name(properties.getProperty("FName"))).sendKeys(x.getCellData("Sheet1","FirstName" , j));
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
			 ReadPropertyFileLoanApplicationPage();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath(properties.getProperty("XpathLeadsTomm"))).click();
			 Thread.sleep(3000);

			 driver.findElement(By.xpath(properties.getProperty("XpathSendButton"))).click();
			 Thread.sleep(2000);
			 driver.findElement(By.id(properties.getProperty("IDSendLinkButton"))).click();
			 
			 
				
			// Thread.sleep(8000);
			 
			// WebElement Resend=driver.findElement(By.xpath(properties.getProperty("XpathResendButton")));
			// wait.until(ExpectedConditions.visibilityOf(Resend));
			// wait.until(ExpectedConditions.elementToBeClickable(Resend));
			// WebElement Resend=driver.findElement(By.id("cashemodal"));
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cashemodal")));
			 
			 Thread.sleep(5000);
			 String expectedstring="Resend";
			 String actualstring1= driver.findElement(By.xpath(properties.getProperty("XpathResendButton"))).getText();
				System.out.println("my text" +actualstring1);
				Assert.assertEquals(actualstring1, expectedstring);
			 
			 driver.findElement(By.xpath(properties.getProperty("XpathResendButton"))).click();
			 Thread.sleep(2000);
			 driver.findElement(By.id(properties.getProperty("IDSendLinkButton"))).click();
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cashemodal")));
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(properties.getProperty("XpathLeadsTommInLeadTomm"))).click();

			 


		}
			
	
	@Test(enabled=false)
	public void DeleteNotSubmittedLeads() throws IOException, InterruptedException {
		
		LaunchBrowserChrome();
		 Login();
		 ReadPropertyFile();
		driver.findElement(By.xpath(properties.getProperty("LoApp"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[1]/div/div[7]/div/span/i")).click();
		 alert = driver.switchTo().alert();
		alert.accept();
		
			int i;
			for(i = 1;i<100;i++) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div[7]/div/span/i")).click();
			Thread.sleep(1000);
			 alert = driver.switchTo().alert();
			alert.accept();
			
			
			
		}
		
			
			
			
		
		
		
	}
	@Test(enabled=false)
	
	public void VerifySearchFunctionality() throws InterruptedException, IOException {
		
		
		LaunchBrowserChrome();
		Login();
		 ReadPropertyFile();
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		driver.findElement(By.xpath(properties.getProperty("LoApp"))).click();
		/*System.out.println("Enter keyword to be searched");
		Scanner myinput=new Scanner(System.in);
		String enterstring=myinput.next();
		driver.findElement(By.id(properties.getProperty("IDLoanAppSearchField"))).sendKeys(enterstring);*/

		
		driver.findElement(By.id(properties.getProperty("IDLoanAppSearchField"))).sendKeys("9711462947");
		driver.findElement(By.id(properties.getProperty("IDLoanAppSearchField"))).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	//	System.out.println(driver.findElement(By.id(properties.getProperty("IDLALostTab"))).getText());
		// Select Prospectdrop=new Select(driver.findElement(By.xpath(properties.getProperty("XpathProspect"))));
		// Prospectdrop.selectByVisibleText("sds");
		List<WebElement> list=driver.findElements(By.xpath(properties.getProperty("XpathProspect")));
		if(list.get(0).getText().equalsIgnoreCase("Prospects (0)")) {
			
			
			if(list.get(1).getText().equalsIgnoreCase("Sent to Bank (0)")) {
				
				
				System.out.println("Searched Value has no result in Database");
				Reporter.log("Result is not present of the searched value");
				
			}
			
			else {
				System.out.println("Result is present in Sent To Bank Tab of the searched value");
				Reporter.log("Result is present in Sent To Bank Tab of the searched value");
				
			}
			
			}
		
		
		else   {
			if(driver.findElement(By.id(properties.getProperty("IDLeads"))).getText().equalsIgnoreCase("Leads (0)"))
			{
				
				PendingTab();
				
			}
			
			else {
				
				
				//driver.findElement(By.id(properties.getProperty("IDLeads"))).click();
				String strlead=driver.findElement(By.id(properties.getProperty("IDLeads"))).getText();
				splitString(strlead);
				 strPending=driver.findElement(By.id(properties.getProperty("IDPendingApp"))).getText();

				 strCompleted=driver.findElement(By.id(properties.getProperty("IDApplied"))).getText();
				 strAppoint=driver.findElement(By.id(properties.getProperty("IDAppointment"))).getText();
				 strLost=driver.findElement(By.id(properties.getProperty("IDLALostTab"))).getText();
				 ForLoopForLeadTab(Alpha);
				PendingTab();
				
			}
			}}
	
	

	
	
	
	
	
	
	public void ForLoopForLeadTab(String TabName) throws InterruptedException {
			
			  int k=2;
			  String str4="";
			  String str2="";
			  
			
			for(int m=1;m<=LeadCountInt;m++) {
				
				String str1="/html/body/div[1]/div[3]/div[4]/div/div/div/div/div/div[";
				//String str2=a;
				 str2=Integer.toString(k);

					String str3="]/div[8]/a";
				 str4=str1+str2+str3;
				 
				
				Thread.sleep(1000);
				
				if(LeadCountInt >10 && m>10 ) {
					try {
					driver.findElement(By.xpath(properties.getProperty("Xpath2Pagination"))).click();
					}
					catch(Exception E) {
						
						
					}
					
				}

						driver.findElement(By.xpath(str4)).isDisplayed();

						k=k+2;
						Thread.sleep(1000);
						if(k>20) {
							
							k=2;
						}
						
						
			Thread.sleep(1000);
				
			}
			
			int l=k;

			String str31="/html/body/div[1]/div[3]/div[4]/div/div/div/div/div/div[";
			//String str2=a;
			 String str32=Integer.toString(l);

			String str33="]/div[8]/a";
			String str34=str31+str32+str33;
			 Boolean bool2;
			try { 
		 bool2=driver.findElement(By.xpath(str34)).isDisplayed();
		 System.out.println("Results does not Matched of "+TabName+" Tab");
			Reporter.log("Results does not Matched of "+TabName+" Tab");
		
		
			}
			catch(Exception P) {
				
				
				System.out.println("Results are Matched of "+TabName+" Tab");
				Reporter.log("Results are Matched of "+TabName+" Tab");
			}
			
			
		}
	
	public void ForLoopCommon(String TabName) throws InterruptedException {
		  int k=2;
		  String str4="";
		  String str2="";
		  
		
		for(int m=1;m<=LeadCountInt;m++) {
			
			String str1="/html/body/div[1]/div[3]/div[4]/div/div/div/div/div/div[";
			//String str2=a;
			 str2=Integer.toString(k);

			String str3="]/div[2]/a/span";
			 str4=str1+str2+str3;
			 
			
			
			
			if(LeadCountInt >10 && m>10 ) {
				try {
					
				driver.findElement(By.xpath(properties.getProperty("Xpath2Pagination"))).click();
				}
				catch(Exception E) {
					
					
				}
				
			}
			
			
					driver.findElement(By.xpath(str4)).isDisplayed();

					k=k+2;
					Thread.sleep(1000);
					if(k>20) {
						
						k=2;
					}
					
					
				
					
					
					
		
			
			
			
			Thread.sleep(1000);
			
		}
		
		int l=k;

		String str31="/html/body/div[1]/div[3]/div[4]/div/div/div/div/div/div[";
		//String str2=a;
		 String str32=Integer.toString(l);

		String str33="]/div[2]/a/span";
		String str34=str31+str32+str33;
		 Boolean bool2;
		try { 
	 bool2=driver.findElement(By.xpath(str34)).isDisplayed();
	 System.out.println(str34);
	 System.out.println("Results does not Matched of "+TabName+" Tab");
		Reporter.log("Results does not Matched of "+TabName+" Tab");
	
	
		}
		catch(Exception P) {
			
			
			System.out.println("Results are Matched of "+TabName+" Tab");
			Reporter.log("Results are Matched of "+TabName+" Tab");
		}
		
		

	}
	
	
	
	public void PendingTab() throws InterruptedException {
		
		if(driver.findElement(By.id(properties.getProperty("IDPendingApp"))).getText().equalsIgnoreCase("Pending Application (0)")) {
			
			CompletedTab();
			
			
		}
		else {
			Thread.sleep(1000);
			driver.findElement(By.id(properties.getProperty("IDPendingApp"))).click();
			System.out.println("In Pending");
			splitString(strPending);
			ForLoopCommon(Alpha);
			
			CompletedTab();
		}
		
	}
	
	public void CompletedTab() throws InterruptedException {
		
		if(driver.findElement(By.id(properties.getProperty("IDApplied"))).getText().equalsIgnoreCase("Completed Application (0)")) {
			
            AppointmentTab();
			
			
		}
		else {
			Thread.sleep(1000);
			driver.findElement(By.id(properties.getProperty("IDApplied"))).click();
			System.out.println("In Completed");
			splitString(strCompleted);
			ForLoopCommon(Alpha);
			AppointmentTab();
			
			
			
		}
	}
public void AppointmentTab() throws InterruptedException {
		
	if(driver.findElement(By.id(properties.getProperty("IDAppointment"))).getText().equalsIgnoreCase("Appointment(0)")) {
		
		LostTab();
	}
	else {
		Thread.sleep(1000);
		driver.findElement(By.id(properties.getProperty("IDAppointment"))).click();
		System.out.println("In Appointment");
		splitString(strAppoint);
		ForLoopCommon(Alpha);
		LostTab();
	}
		
		
		
	}

	
	public void LostTab() throws InterruptedException {
		
		if(driver.findElement(By.id(properties.getProperty("IDLALostTab"))).getText().equalsIgnoreCase("Lost/NI(0)")) {
			Thread.sleep(1000);
			driver.findElement(By.id(properties.getProperty("IDLALostTab"))).click();
			
		}
		else {
			Thread.sleep(1000);
			driver.findElement(By.id(properties.getProperty("IDLALostTab"))).click();
			System.out.println("In Lost");
			System.out.println(strLost);
			splitString(strLost);
			ForLoopCommon(Alpha);
		}
		
		
		
	}
		

		 
		
	public void splitString(String str) 
    { 
        StringBuffer alpha = new StringBuffer(),  
        num = new StringBuffer(), special = new StringBuffer(),space=new StringBuffer(); 
          
        for (int i=0; i<str.length(); i++) 
        { 
           if(Character.isDigit(str.charAt(i))) {
        	   
        	   num.append(str.charAt(i));
           }
        	   
        	   else if(Character.isAlphabetic(str.charAt(i))) {
        		   
        		   alpha.append(str.charAt(i));
        		   
        	   }
        	   else if(Character.isWhitespace(str.charAt(i))){
        		   
        		   space.append(str.charAt(i));
        		   
        	   }
        	   else {
        		   
        		   special.append(str.charAt(i));
        		   
        	   }
           
           }
         
         LeadCountString=num.toString();
         LeadCountInt = Integer.parseInt(num.toString());
          Alpha=alpha.toString();
    //    System.out.println(LeadCountInt);
        
    } 





}
