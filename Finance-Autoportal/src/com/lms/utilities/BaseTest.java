package com.lms.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.text.Normalizer.Form;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest  {
	
	public String baseurl="http://stagelms.autoportal.com/";
	  static public WebDriver driver;
	  static  public  Properties properties;
	   String env;
	   String MyUserType;
	     protected int MyBank;
	     protected String manualfirstname;
	     protected String typeofcustomer; 
	     protected int UserType;
	     protected String FormType;
	
	   
  //@BeforeMethod
  
	     public void Reflection() throws ClassNotFoundException {
	    	 
	    	 Class clazz=Class.forName("com.finance.loanapplication.LoanApplicationsPage");
	    	 System.out.println(clazz.getSimpleName());

	    	 
	    	 
	     }
	     
	   //  @AfterMethod
	     
	     public void CLosewindow() {
	    	 
	    	 
	    	 driver.quit();
	     }
  
	/*@AfterMethod //AfterMethod annotation - This method executes after every test execution
	/*public void screenShot(ITestResult result){
	//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				// Call method to capture screenshot
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location 
				// result.getName() will return name of test case so that screenshot name will be same as test case name
				Class clazz=Class.forName("com.finance.loanapplication.LoanApplicationsPage");
				String classname=clazz.getSimpleName();
			//	String classname=result.getClass().getSimpleName();
				String methodname=result.getMethod().getMethodName();
				String filenamescreenshots=classname+"-"+methodname;
				System.out.println(methodname);
			//	FileUtils.copyFile(src, new File("D:\\"+result.getName()+".png"));

				FileUtils.copyFile(src, new File("C:\\Users\\user\\Desktop\\Autoportal\\eclipse\\Screenshots\\"+filenamescreenshots+".png"));
			
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
	}	
			}
		driver.quit();
		}*/
	     
	     public void userinput() {
	    	 
	    	 
	    	  Scanner input=new Scanner(System.in);
	    	  System.out.println("Enter 1 for Dealer and 2 for CC");
	    	  UserType=input.nextInt();
	    	  if(UserType==2) {
	    		  System.out.println("Enter n for new CC small form and o for Old Long Form");
	    		  FormType=input.next();
	    		  
	    	  }
	    	  if(UserType==1) {
	    	  System.out.println("Enter 1 for HDFC , 2 for Yes Bank ,3 for Magma and 4 for Axis");
	    	  MyBank=input.nextInt();
	    	  }
	    	  else if(UserType==2 && FormType.equals("o")) {
	    		  
	    		  System.out.println("Enter 1 for HDFC , 2 for Yes Bank ,3 for Magma and 4 for Axis");
	    		  MyBank=input.nextInt();
	    		  
	    	  }
	    	  
	    	  System.out.println("Enter First Name");
	    	  manualfirstname=input.next();
	    	  if(MyBank==2) {
	    	  System.out.println("Enter s for salary and se for Self Employed");
	    	  typeofcustomer=input.next();
	    	  }
	     }
	     
	     
	     public void ExcelReadUserInput() {
	    	 
	    	 int j=2;
	   	  Xls_Reader x=new Xls_Reader(System.getProperty("user.dir")+"\\Files\\UserInput.xlsx");
			 
			 UserType=Integer.parseInt(x.getCellData("Sheet1","Type1Or2" , j));
			 MyBank=Integer.parseInt(x.getCellData("Sheet1","NewOldForm(oORn)" , j));
			 manualfirstname=(x.getCellData("Sheet1","Name" , j));
			 typeofcustomer=(x.getCellData("Sheet1","SOrSe" , j));
			 
	    	 
	    	 
	    	 
	    	 
	     }
	     
	     
	    
  public void LaunchBrowserChrome() throws InterruptedException, IOException {
	  
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\mychrome\\chromedriver.exe");
	  System.out.println("Selenium started.....");
	  
	
 

	  
	  
	  driver=new ChromeDriver();
	 // FirefoxProfile ffprofile = new FirefoxProfile();
	//	ffprofile.setPreference("dom.webnotifications.enabled", false);
	  // driver=new FirefoxDriver(ffprofile);
	  ReadPropertyFile();
	 
	  

	   env=properties.getProperty("Environment");
	   MyUserType=properties.getProperty("User1");
	  
	   System.out.println(env);
	  if(env.equalsIgnoreCase("stage"))
	  {
		  baseurl="http://stagelms.autoportal.com/";  
		  
	  }
	  else if(env.equalsIgnoreCase("prod"))
	  {
		  baseurl="http://finance.autoportal.com/";  
		  
	  }
	  driver.get(baseurl);
	  driver.manage().window().maximize();
	  
	  
	 
	  
	  }
  
  public void InputSearchFunctionality() throws IOException {
	  
	  
	  
	  
  }
  
 
   public void Login() throws IOException, InterruptedException {
	   ReadPropertyFile();
	   System.out.println("MyUserType "+MyUserType);
	   
	   if((env.equalsIgnoreCase("stage")) && (MyUserType.equalsIgnoreCase("CC"))) {
		   System.out.println("1");
			driver.findElement(By.name(properties.getProperty("LoginEmail1"))).sendKeys(properties.getProperty("CCLoginEmail2"));
			driver.findElement(By.name(properties.getProperty("LoginPassword1"))).sendKeys(properties.getProperty("CCLoginPassordstage"));
			 }
			 
			 else if((env.equalsIgnoreCase("prod")) && (MyUserType.equalsIgnoreCase("CC"))){
				   System.out.println("2");

				 driver.findElement(By.name(properties.getProperty("LoginEmail1"))).sendKeys(properties.getProperty("CCLoginEmail2"));
					driver.findElement(By.name(properties.getProperty("LoginPassword1"))).sendKeys(properties.getProperty("CCLoginPassordprod"));
				 
			 }
	   
	   
	   if((env.equalsIgnoreCase("stage")) && (MyUserType.equalsIgnoreCase("Dealer"))){
		   System.out.println("3");
			driver.findElement(By.name(properties.getProperty("LoginEmail1"))).sendKeys(properties.getProperty("Email1stage"));
			driver.findElement(By.name(properties.getProperty("LoginPassword1"))).sendKeys(properties.getProperty("Password1stage"));
			 }
			 
			 else if((env.equalsIgnoreCase("prod")) && (MyUserType.equalsIgnoreCase("Dealer"))){
				   System.out.println("4");
				 driver.findElement(By.name(properties.getProperty("LoginEmail1"))).sendKeys(properties.getProperty("Email1prod"));
					driver.findElement(By.name(properties.getProperty("LoginPassword1"))).sendKeys(properties.getProperty("Password1prod"));
				 
			 }
	   driver.findElement(By.xpath(properties.getProperty("LogSubmitButt"))).click();
	   
	   
	   
   }
   
 public void LoginforLeadCreate() throws IOException, InterruptedException {
  	
	    ReadPropertyFile();

		if(UserType==1) {
		 if(env.equalsIgnoreCase("stage")) {
		driver.findElement(By.name(properties.getProperty("LoginEmail1"))).sendKeys(properties.getProperty("Email1stage"));
		driver.findElement(By.name(properties.getProperty("LoginPassword1"))).sendKeys(properties.getProperty("Password1stage"));
		 }
		 
		 else {
			 driver.findElement(By.name(properties.getProperty("LoginEmail1"))).sendKeys(properties.getProperty("Email1prod"));
				driver.findElement(By.name(properties.getProperty("LoginPassword1"))).sendKeys(properties.getProperty("Password1prod"));
			 
		 }
		}
		
		else if(UserType==2) {
			
			if(env.equalsIgnoreCase("stage")) {
				driver.findElement(By.name(properties.getProperty("LoginEmail1"))).sendKeys(properties.getProperty("CCLoginEmail2"));
				driver.findElement(By.name(properties.getProperty("LoginPassword1"))).sendKeys(properties.getProperty("CCLoginPassordstage"));
				 }
				 
				 else {
					 driver.findElement(By.name(properties.getProperty("LoginEmail1"))).sendKeys(properties.getProperty("CCLoginEmail2"));
						driver.findElement(By.name(properties.getProperty("LoginPassword1"))).sendKeys(properties.getProperty("CCLoginPassordprod"));
					 
				 }
			
			
		}
		driver.findElement(By.xpath(properties.getProperty("LogSubmitButt"))).click();
 }
  

 
   public void ReadPropertyFileLoanApplicationPage() throws IOException{
	 
	 FileInputStream fileInputStream=new FileInputStream("C:\\Users\\user\\Desktop\\Autoportal\\eclipse\\WorkspaceD\\Finance-Autoportal\\Property\\LoanApplication.Properties");
		
		properties=new Properties();
		properties.load(fileInputStream);

	 
	 
	 
	 
 }
 
 
 public void ReadPropertyFileSignUp() throws IOException{
	 
	 FileInputStream fileInputStream=new FileInputStream("C:\\Users\\user\\Desktop\\Autoportal\\eclipse\\WorkspaceD\\Finance-Autoportal\\Property\\Signup.Properties");
		
		properties=new Properties();
		properties.load(fileInputStream);

	 
	 
	 
	 
 }
 
 public void ReadPropertyFileDashboard() throws IOException
 
 
 {
	FileInputStream fileInputStream=new FileInputStream("C:\\Users\\user\\Desktop\\Autoportal\\eclipse\\WorkspaceD\\Finance-Autoportal\\Property\\Dashboard.Properties");
	
	properties=new Properties();
	properties.load(fileInputStream);
//	fileInputStream.close();
	
	}
 
   
  public void ReadPropertyFile() throws IOException
      
  
  {
	FileInputStream fileInputStream=new FileInputStream("C:\\Users\\user\\Desktop\\Autoportal\\eclipse\\WorkspaceD\\Finance-Autoportal\\Property\\Data.Properties");
	
	properties=new Properties();
	properties.load(fileInputStream);
//	fileInputStream.close();
	
	}
  
  public void  VerifyTitleCreateAccount() throws InterruptedException,IOException 
	{
		
		    String expec="Let's know for whom you are creating the profile?";
		    Thread.sleep(2000);
			String actual=driver.findElement(By.className(properties.getProperty("xCreateTitle"))).getText();
			Assert.assertEquals(actual, expec);
			System.out.println("We are on Create Account page");
			}
  
  public void XLSforLogin()
  
  {
	  Xls_Reader x=new Xls_Reader(System.getProperty("user.dir")+"\\Files\\Login.xlsx");
		 int rcount=x.getRowCount("Sheet1");
		 for(int i=2 ;i<=rcount ;i++)
			 {
			 
			 driver.findElement(By.cssSelector(properties.getProperty("CssEmailid"))).sendKeys(x.getCellData("Sheet1", "Email", i));
			 driver.findElement(By.cssSelector(properties.getProperty("CssPassid"))).sendKeys(x.getCellData("Sheet1", "Password", i));
		 }
  }
  
  
  public void VerifyUserNameAfterLogin() throws InterruptedException,IOException 
  {
	  
	  String expected2="Welcome Miss. Manisha";
	  String actual2=driver.findElement(By.xpath(properties.getProperty("xpexpectedNameforLogin"))).getText();
	  Assert.assertEquals(actual2, expected2);
		System.out.println("We are Logged in into our account");
	  
  }
  
  public void ActionBasic() throws IOException
  {
	  
	  Actions move= new Actions(driver);
	  ReadPropertyFile();
	  WebElement src= driver.findElement(By.xpath(properties.getProperty("xpSearchHeader")));
	  move.moveToElement(src).perform();
	//Click on Basic Search Link Text
	driver.findElement(By.xpath(properties.getProperty("xpBasicSearchHeader"))).click();
  }
  
  
  public void ActionEditProfile() throws IOException
  {
	  
	  Actions move= new Actions(driver);
	 
	  WebElement src= driver.findElement(By.xpath(("html/body/nav/div[2]/div[3]/div/ul/li[2]/ul/li[9]/a")));
	  move.moveToElement(src).perform();
	//Click on Basic Search Link Text
	driver.findElement(By.xpath(("html/body/nav/div[2]/div[3]/div/ul/li[2]/ul/li[9]/a"))).click();
  }
  public void ActionSearchByID() throws IOException
  {
	  
	  Actions move= new Actions(driver);
	  ReadPropertyFile();
	  WebElement src= driver.findElement(By.xpath(properties.getProperty("xpSearchHeader")));
	  move.moveToElement(src).perform();
	//Click on Basic Search Link Text
	driver.findElement(By.xpath(properties.getProperty("xpSearchByID"))).click();
  }


  
  
  
}
  
