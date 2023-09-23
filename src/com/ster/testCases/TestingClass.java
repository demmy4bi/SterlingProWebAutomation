package com.ster.testCases;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.ster.base.TestBase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

public class TestingClass {
ValidateLogin validLogin = new ValidateLogin();
	void check () throws InterruptedException, IOException {
		validLogin.oneBankSign();
		
	}
	
	
}
