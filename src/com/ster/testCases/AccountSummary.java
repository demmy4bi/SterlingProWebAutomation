package com.ster.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.ster.base.TestBase;

public class AccountSummary extends TestBase{
	@Test(description = "This TestCase will enable user view account summary")
	public void viewAccountSummary() throws InterruptedException, IOException {
		  System.out.println(driver.getTitle());
        chooseElement("detailsButton_ID").click();
        chooseElement("proceedLink_LINKTEXT").click();
      //Enter Email Address
       type("txtUsername_CSS", "txtUsername");
      //Tap Enter to click on next button
		chooseElement("txtUsername_CSS").clear();
	       //Enter Email Address
     type("txtUsername_CSS", "txtUsername");
     chooseElement("txtUsername_CSS").sendKeys(Keys.TAB);
     //Enter Password
      chooseElement("txtPassword_CSS").clear();
     type("txtPassword_CSS", "txtUserPassword");
      chooseElement("txtPassword_CSS").sendKeys(Keys.ENTER);
      //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      //VIEW ACCOUNT SUMMARY
      chooseElement("viewAccount_XPATH").click();
      
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,243.1999969482422);");
      Thread.sleep(1000);
      //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      //driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
      //driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
      //driver.close();
	}

}
