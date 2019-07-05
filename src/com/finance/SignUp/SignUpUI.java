package com.finance.SignUp;

import java.io.IOException;

import org.testng.annotations.Test;

import com.lms.utilities.BaseTest;

public class SignUpUI extends BaseTest {
	
	@Test
	public void SingupFunctionality() throws InterruptedException, IOException {
		
		LaunchBrowserChrome();
		ReadPropertyFileSignUp();
		

}}
