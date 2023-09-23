package com.ster.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ster.base.TestBase;

public class Airtime extends TestBase{
	@Test(description = "Verify Airtime transfer is successful")
    public void EntryFields() throws InterruptedException, IOException {
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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("#PaymentLink p")).click();
	    driver.findElement(By.id("A21")).click();
//	    driver.findElement(By.id("middleContent_drpSourceAccount")).click();
//	    {
//	      WebElement dropdown = driver.findElement(By.id("middleContent_drpSourceAccount"));
//	      dropdown.findElement(By.xpath("//option[. = '0078903828 -- CROATIA COLLECTION --- NGN {1,999,999,999.95}']")).click();
//	    }
	    
	    WebElement From = driver.findElement(By.id("middleContent_drpSourceAccount"));
		{
			Select sl = new Select(From);
			//option by value
			sl.selectByValue("0078903828");
			//get option with text
			String s = sl.getFirstSelectedOption().getText();
			System.out.println("Value selected: : " + s);
			From.sendKeys(Keys.TAB);
			//driver.quit();
		}
	    
		 WebElement TO = driver.findElement(By.id("middleContent_drpBiller"));
			{
				Select sl = new Select(TO);
				//option by value
				sl.selectByValue("4");
				//get option with text
				String s = sl.getFirstSelectedOption().getText();
				System.out.println("Value selected: : " + s);
				From.sendKeys(Keys.TAB);
				//driver.quit();
			}
	    
//	    driver.findElement(By.id("middleContent_drpBiller")).click();
//	    {
//	      WebElement dropdown = driver.findElement(By.id("middleContent_drpBiller"));
//	      dropdown.findElement(By.xpath("//option[. = 'GLO']")).click();
//	    }
		
		
	    driver.findElement(By.id("middleContent_txtAmount")).click();
	    driver.findElement(By.id("middleContent_txtAmount")).sendKeys("100");
	    driver.findElement(By.id("middleContent_txtCaption")).click();
	    driver.findElement(By.id("middleContent_txtCaption")).sendKeys("08059310239");
	    driver.findElement(By.id("middleContent_btnSubmit")).click();

	    
	    String passAlert2 = "Airtime payment sent for Approval.";
		Alert confirmation2 = driver.switchTo().alert();
		String alertText = confirmation2.getText();
		System.out.println("Alert text is:" +alertText);
		assertEquals(alertText, passAlert2);
		confirmation2.accept();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
	    driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
	    
	}
	

}
