package com.ster.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ster.base.TestBase;

public class BillsPayment extends TestBase {
	@Test(description = "This TestCase will allow user view list of beneficiaries")
	public void intrabankAccounts() throws InterruptedException, IOException {
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
	    driver.findElement(By.id("utilityRpt")).click();
//	    driver.findElement(By.id("middleContent_drpSourceAccount")).click();
//	    {
//	      WebElement dropdown = driver.findElement(By.id("middleContent_drpSourceAccount"));
//	      dropdown.findElement(By.xpath("//option[. = '0064729139 -- NIMC HOLDING ACCOUNT --- NGN {1,017,102,612.03}']")).click();
//	    }
	    WebElement From = driver.findElement(By.id("middleContent_drpSourceAccount"));
		{
			Select sl = new Select(From);
			//option by value
			sl.selectByValue("0064729139");
			//get option with text
			String s = sl.getFirstSelectedOption().getText();
			System.out.println("Value selected: : " + s);
			From.sendKeys(Keys.TAB);
			//driver.quit();
		}
	    
	    
	    
	    
	    
//	    driver.findElement(By.id("middleContent_drpCategory")).click();
//	    {
//	      WebElement dropdown = driver.findElement(By.id("middleContent_drpCategory"));
//	      dropdown.findElement(By.xpath("//option[. = 'International Airtime']")).click();
//	    }
	    
		 WebElement cat = driver.findElement(By.id("middleContent_drpCategory"));
			{
				Select sl = new Select(cat);
				//option by value
				sl.selectByValue("International Airtime");
				//get option with text
				String s = sl.getFirstSelectedOption().getText();
				System.out.println("Value selected: : " + s);
				From.sendKeys(Keys.TAB);
				//driver.quit();
			}
		
		
	    
	    
	    driver.findElement(By.id("middleContent_drpBiller")).click();
//	    driver.findElement(By.id("middleContent_drpBiller")).click();
//	    {
//	      WebElement dropdown = driver.findElement(By.id("middleContent_drpBiller"));
//	      dropdown.findElement(By.xpath("//option[. = 'China Telecom']")).click();
//	    }
			
			 WebElement biller = driver.findElement(By.id("middleContent_drpBiller"));
				{
					Select sl = new Select(cat);
					//option by value
					sl.selectByValue("China Telecom");
					//get option with text
					String s = sl.getFirstSelectedOption().getText();
					System.out.println("Value selected: : " + s);
					From.sendKeys(Keys.TAB);
					//driver.quit();
				}	
			
			
			
			
			
			
			
	    driver.findElement(By.id("middleContent_drpPackage")).click();
//	    driver.findElement(By.id("middleContent_drpPackage")).click();
//	    {
//	      WebElement dropdown = driver.findElement(By.id("middleContent_drpPackage"));
//	      dropdown.findElement(By.xpath("//option[. = '200CNY Top up']")).click();
//	    }
	    
		 WebElement pckge = driver.findElement(By.id("middleContent_drpPackage"));
			{
				Select sl = new Select(pckge);
				//option by value
				sl.selectByValue("200CNY Top up");
				//get option with text
				String s = sl.getFirstSelectedOption().getText();
				System.out.println("Value selected: : " + s);
				From.sendKeys(Keys.TAB);
				//driver.quit();
			}
	    
	    
	    
	    
	    driver.findElement(By.id("middleContent_txtAmount")).click();
	    driver.findElement(By.id("middleContent_txtAmount")).sendKeys("1,000");
	    driver.findElement(By.id("middleContent_txtCaption")).click();
	    driver.findElement(By.id("middleContent_txtCaption")).sendKeys("08059310239");
	    driver.findElement(By.id("middleContent_btnSubmit")).click();

	}

}
