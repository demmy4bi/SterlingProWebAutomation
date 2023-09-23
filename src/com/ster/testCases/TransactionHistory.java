package com.ster.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.ster.base.TestBase;

public class TransactionHistory extends TestBase{
	@Test(description = "This TestCase will verify entry fields input")
	  public void Transactions() throws InterruptedException, IOException {
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
    
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    
    driver.findElement(By.linkText("Transaction Status")).click();
    driver.findElement(By.cssSelector("#Transactions .ts-content-card:nth-child(3) img")).click();
    driver.findElement(By.cssSelector(".tablinks:nth-child(2)")).click();
    Thread.sleep(100);
  
	}
}
