package com.ster.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ster.base.TestBase;

public class StatementGeneration extends TestBase{
	@Test(description = "This TestCase will allow user generate account statements")
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
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  

  
  driver.findElement(By.cssSelector(".nav-item-block:nth-child(12) p")).click();
  driver.findElement(By.cssSelector(".nav-item-block:nth-child(5) p")).click();
  driver.findElement(By.linkText("Dashboard")).click();
  driver.findElement(By.id("quickMultiBankStatementLink")).click();
  
  String passAlert2 = "This service allows only a maximum period of 12 months for each request!.";
	Alert confirmation2 = driver.switchTo().alert();
	String alertText = confirmation2.getText();
	System.out.println("Alert text is:" +alertText);
	assertEquals(alertText, passAlert2);
	confirmation2.accept();
	
	WebElement From = driver.findElement(By.id("middleContent_drpAccountNum"));
	{
		Select sl = new Select(From);
		//option by value
		sl.selectByValue("0064728527");
		//get option with text
		String s = sl.getFirstSelectedOption().getText();
		System.out.println("Value selected: : " + s);
		From.sendKeys(Keys.TAB);
		//driver.quit();
	}
	

	WebElement TO = driver.findElement(By.id("middleContent_drpStatementFormat"));
	{
		Select s2 = new Select(TO);
		//option by value
		s2.selectByValue("excel");
		//get option with text
		String optvalue = s2.getFirstSelectedOption().getText();
		System.out.println("Value selected: : " + optvalue);

	}

  
  
  driver.findElement(By.cssSelector("#middleContent_PopCalendarDOB_Control > img")).click();
  ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,243.1999969482422);");
  driver.findElement(By.xpath("//span[@onclick='objPopCalList[0].dateSelected=13;objPopCalList[0].monthSelected=2;objPopCalList[0].yearSelected=2022;PopCalCloseCalendar(0);']")).click();
  //TestBase.getDate1(".DayOverStyle").click();
  //driver.findElement(By.cssSelector(".DayOverStyle")).click();
  driver.findElement(By.cssSelector("#middleContent_PopCalendar2_Control > img")).click();
  //driver.findElement(By.cssSelector(".DayOverStyle")).click();
  driver.findElement(By.xpath("//span[@onclick='objPopCalList[1].dateSelected=13;objPopCalList[1].monthSelected=2;objPopCalList[1].yearSelected=2022;PopCalCloseCalendar(1);']")).click();
  driver.findElement(By.id("middleContent_btnSubmit")).click();
  driver.findElement(By.linkText("here")).click();
//  driver.findElement(By.id("middleContent_drpAccountNum")).click();
//  {
//    WebElement dropdown = driver.findElement(By.id("middleContent_drpAccountNum"));
//    dropdown.findElement(By.xpath("//option[. = '0064729139 -- NIMC HOLDING ACCOUNT --- NGN {1,017,102,612.03}']")).click();
//  }
  WebElement acct = driver.findElement(By.id("middleContent_drpAccountNum"));
  
  {
		Select s2 = new Select(acct);
		//option by value
		s2.selectByValue("0064729139");
		//get option with text
		String optvalue = s2.getFirstSelectedOption().getText();
		System.out.println("Value selected: : " + optvalue);

	}
  
  
  
  //driver.findElement(By.id("middleContent_drpAccountNum")).click();
//  driver.findElement(By.id("middleContent_drpAccountNum")).click();
//  {
//    WebElement dropdown = driver.findElement(By.id("middleContent_drpAccountNum"));
//    dropdown.findElement(By.xpath("//option[. = '0064728527 -- PREMIUM DRIVER LICENSE-COLLECTIONS --- NGN {1,000,000,397.55}']")).click();
//  }
  driver.findElement(By.id("middleContent_btnSubmit")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  //driver.findElement(By.cssSelector("tr:nth-child(6) > td:nth-child(5)")).click();
  driver.findElement(By.xpath("//table[@id='middleContent_grvTransactionList']/tbody/tr[3]/td[9]/a")).click();
  
}

  
  //VIEW ACCOUNT SUMMARY
  //chooseElement("viewAccount_XPATH").click();
  //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  //((JavascriptExecutor) driver).executeScript("window.scrollTo(0,243.1999969482422);");

}

//driver.findElement(By.id("middleContent_drpAccountNum")).click();
//{
//  WebElement dropdown = driver.findElement(By.id("middleContent_drpAccountNum"));
//  dropdown.findElement(By.xpath("//option[. = '0064728527 -- PREMIUM DRIVER LICENSE-COLLECTIONS --- NGN {1,000,000,397.55}']")).click();
//}
//driver.findElement(By.id("middleContent_drpStatementFormat")).click();
//{
//  WebElement dropdown = driver.findElement(By.id("middleContent_drpStatementFormat"));
//  dropdown.findElement(By.xpath("//option[. = 'Excel']")).click();
//}
