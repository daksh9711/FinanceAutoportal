package com.database;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class DatabaseQueries  {
	 void Financedatabasequery() {
			
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://192.168.1.250:3306/ap_finance_live","qa_daksh","zh7QI0uUsiAXyIw4");  
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
			//	System.out.println(myleadid);
				//String myquery1="UPDATE `finance_customer` SET `otp_verified` = '1' WHERE";
				//int id=cutomerid;
				//ResultSet rs=stmt.executeQuery("select * from finance_customer order by id desc");  
			//	String string1="UPDATE `finance_customer` SET `otp_verified` = '1' WHERE id=";
				
				stmt.execute("UPDATE `finance_customer_otp` SET `otp_verified` = '1' WHERE customer_id=39491");  
				ResultSet rs=stmt.executeQuery("select * from finance_customer WHERE id=39491");
				
				while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getInt(51));  
				con.close();  
				}
			
			
			catch(Exception e)
			{ 
				System.out.println(e);
			}
		 }
		 
		 
			
		 void databasequeryforLMSnocheck() {
				
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://192.168.1.250:3306/lms_dev","qa_daksh","zh7QI0uUsiAXyIw4");  
					 Statement stmt=con.createStatement(); 
					 
					//Enter Mobile Number here 
					String  a="0";
					
					
					
					int length = a.length( );
					if(length >10)
					{
						System.out.println("More - Entered mobile number has more than 10 numbers");
					}
					else if(length <10) {
						System.out.println("Less - Entered mobile number has less than 10 numbers");
						
					}
					   
				    ResultSet rs=stmt.executeQuery("SELECT * FROM lms_lead_master WHERE phone ="+a);  
				    if (!rs.isBeforeFirst() ) {    
				        System.out.println("No data exist for this number"); 
				    }
				    else {
				    while(rs.next()) 
					System.out.println(rs.getInt(1)+"  "+rs.getString(8)+"  "+rs.getString(3)); 
				    }
					con.close();  
					}
				
				
				catch(Exception f)
				{ 
					System.out.println(f);
				}
			 }
				 
				
			
			
		
		public static void main(String args[])
		{ 
			
			DatabaseQueries connection=new DatabaseQueries();
		Scanner in = new Scanner(System.in); 
		        System.out.println("Press f for Finance and l for LMS");

	        String s = in.nextLine();
	        if(s.equals("f")) {
	        	connection.Financedatabasequery();
	        	
	        }
	        else if(s.equals("l")){
	  
	     
		//	
			connection.databasequeryforLMSnocheck();
	        }
	        
	        
	        System.out.println("One");
	        
	        // Storing console output to consoleStorage.
	        ByteArrayOutputStream consoleStorage = new ByteArrayOutputStream();
	        PrintStream newConsole = System.out;
	        System.setOut(new PrintStream(consoleStorage));
	     
	        // Here all System.out.println() calls will be stored in consoleStorage.
	        System.out.println("two");     // Note: The output "two" you see from the console 
	                                    //        doesn't come from this line but from the lines below(newConsole.println());
	     
	        newConsole.println(consoleStorage.toString());
	        newConsole.println(consoleStorage.toString());
	     
	        // Restore back the standard console output.
	        System.setOut(newConsole);
	     
	        // Print to console.
	        System.out.println("three");
	        System.out.println(consoleStorage.toString());
			
			                
			   
		}
}
