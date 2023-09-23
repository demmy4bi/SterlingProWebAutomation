package com.ster.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ster.base.TestBase;

public class BulkUpload extends TestBase {
	@Test(description = "This TestCase will enable user carry out multiple transaction payments")
	public void MultipleTransactionPayment() throws InterruptedException, IOException {
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
      
      //navigate to bulk upload
      driver.findElement(By.xpath("//li[@id='TransferLink']/span/p")).click();
      
      driver.findElement(By.id("bulk")).click();
      driver.get("https://10.0.41.188:442/Fundstransfer/bulkpayment");
      driver.findElement(By.xpath("//form[@id='form1']/div[3]/div[2]/div[2]/div[3]/div/div/button")).click();
//      driver.findElement(By.id("middleContent_drpSourceAccount")).click();
//      new Select(driver.findElement(By.id("middleContent_drpSourceAccount"))).selectByVisibleText("0004928112 -- VF GLOBAL SERVICES NIGERIA LTD --- NGN {192,360,198.26}");
      WebElement From = driver.findElement(By.id("middleContent_drpSourceAccount"));
		{
			Select sl = new Select(From);
			//option by value
			sl.selectByValue("0004928112");
			//get option with text
			String s = sl.getFirstSelectedOption().getText();
			System.out.println("Value selected: : " + s);
			From.sendKeys(Keys.TAB);
			//driver.quit();
		}
		
		
		//C:\Users\Somto\Downloads
      
      WebElement element = driver.findElement(By.id("middleContent_FileUpload1"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		//element.click();
      //driver.findElement(By.id("middleContent_FileUpload1")).clear();
      driver.findElement(By.id("middleContent_FileUpload1")).sendKeys("C:/users/Somto/Downloads/TestUpload.xlsx");
      driver.findElement(By.id("middleContent_drpModeDebit")).click();
      new Select(driver.findElement(By.id("middleContent_drpModeDebit"))).selectByVisibleText("Multiple Debit");
      driver.findElement(By.id("middleContent_btnUpload")).click();

  }
}
