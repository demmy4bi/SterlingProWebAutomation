package com.ster.testCases;


import static com.jayway.restassured.RestAssured.get;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



import com.jayway.restassured.path.json.JsonPath;
import com.ster.base.TestBase;
import com.ster.utility.Utility;

public class BanKTransfer  extends TestBase{
	@Test(description = "This TestCase will perform intrabank transfers between accounts")
    public void intrabankAccounts() throws InterruptedException, IOException {
		System.out.println(driver.getTitle());
//		chooseElement("detailsButton_ID").click();
//		chooseElement("proceedLink_LINKTEXT").click();
		//Enter Email Address
		//type("txtUsername_CSS", "txtUsername");
		//Tap Enter to click on next button
		//chooseElement("txtUsername_CSS").clear();
		//Enter Email Address
		//type("txtUsername_CSS", "txtUsername");
		//chooseElement("txtUsername_CSS").sendKeys(Keys.TAB);
		//Enter Password
		//chooseElement("txtPassword_CSS").clear();
		//type("txtPassword_CSS", "txtUserPassword");
		//chooseElement("txtPassword_CSS").sendKeys(Keys.ENTER);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//VIEW ACCOUNT SUMMARY
		//chooseElement("viewAccount_XPATH").click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//SELECT LOCAL TRANSFERS
		chooseElement("txtTransferNav_CSS").click();

		//SELECT TRANSFER TO OWN ACCOUNT
		chooseElement("txtTransferOwnAcct_ID").click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//TestBase.selectDropdowntByVisibleText("0004928112",  );
		//           WebElement v = driver.findElement(By.name("ctl00$middleContent$drpSourceAccount"));
		//           Select s = new Select(v);
		//           s.selectByValue("val1");

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
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.wait(100);



		String passAlert = "To";
		driver.getPageSource();
		//String elem = driver.findElement(By.id("lblmsg")).getText();
		String elem = String.valueOf(passAlert);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		assertEquals("To", elem);


		WebElement TO = driver.findElement(By.id("middleContent_drpDestination"));
		{
			Select s2 = new Select(TO);
			//option by value
			s2.selectByValue("0080048296");
			//get option with text
			String optvalue = s2.getFirstSelectedOption().getText();
			System.out.println("Value selected: : " + optvalue);

		}

		driver.findElement(By.id("middleContent_txtAmount")).click();
		driver.findElement(By.id("middleContent_txtAmount")).sendKeys("10,000");
		driver.findElement(By.id("middleContent_txtnarrationdesc")).click();
		driver.findElement(By.id("middleContent_txtnarrationdesc")).sendKeys("fund");
		driver.findElement(By.id("middleContent_btnTransfer")).click();


		String passAlert2 = "Fund transfer has been sent for approval";
		Alert confirmation2 = driver.switchTo().alert();
		String alertText = confirmation2.getText();
		System.out.println("Alert text is:" +alertText);
		assertEquals(alertText, passAlert2);
		confirmation2.accept();
		
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,88)");  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
	    driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
	        
	   //chooseElement("logout_XPATH").click();


		
	}
	

	
	
	
	@Test(description = "This TestCase will perform tests on intrabank entry features ")
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
		driver.findElement(By.linkText("Dashboard")).click();
	    driver.findElement(By.cssSelector("#TransferLink p")).click();
	    driver.findElement(By.id("A6")).click();
	    
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.wait(100);



		String passAlert = "To";
		driver.getPageSource();
		//String elem = driver.findElement(By.id("lblmsg")).getText();
		String elem = String.valueOf(passAlert);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("To", elem);


		WebElement TO = driver.findElement(By.id("middleContent_drpDestination"));
		{
			Select s2 = new Select(TO);
			//option by value
			s2.selectByValue("0080048296");
			//get option with text
			String optvalue = s2.getFirstSelectedOption().getText();
			System.out.println("Value selected: : " + optvalue);

		}

	    
	    
	    driver.findElement(By.id("middleContent_txtAmount")).click();
	    driver.findElement(By.id("middleContent_txtAmount")).sendKeys("-1");
	    driver.findElement(By.id("middleContent_txtAmount")).clear();
	    driver.findElement(By.id("middleContent_txtAmount")).sendKeys("0");
	    driver.findElement(By.id("middleContent_txtAmount")).clear();
	    driver.findElement(By.id("middleContent_txtAmount")).sendKeys("1,000.00");
	    driver.findElement(By.id("middleContent_txtnarrationdesc")).click();
	    driver.findElement(By.id("middleContent_txtnarrationdesc")).sendKeys("fund");
	    driver.findElement(By.id("middleContent_btnTransfer")).click();
	    
	    String passAlert2 = "Fund transfer has been sent for approval";
		Alert confirmation2 = driver.switchTo().alert();
		String alertText = confirmation2.getText();
		System.out.println("Alert text is:" +alertText);
		assertEquals(alertText, passAlert2);
		confirmation2.accept();
		
	    ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,88)");    
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
	    driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
	        
	   //chooseElement("logout_XPATH").click();
	   
	   
	  }
	
		
	
	}
//	
//	@Test (description = "This would check if account is restricted")
//	void getAccountInfo() {
//	Response resp = null;
//	try {
	//getting FioranoUrl from config and concatenating with variable holding the account number
//	resp =  get(((String) Utility.fetchProperty("fioranoAccInfo")).concat("0072433114") );
//	} catch (IOException e) {
	// TODO Auto-generated catch block
//	e.printStackTrace();
//	}
//	JsonPath jsonPath = resp.jsonPath();
//	String response = jsonPath.get("BankAccountFullInfo.REST_FLAG");
//	System.out.println(response);
//	Assert.assertEquals(response, "FALSE"); }
	
//}

//driver.findElement(By.id("middleContent_drpSourceAccount")).click();
//{
//  WebElement dropdown = driver.findElement(By.id("middleContent_drpSourceAccount"));
//  dropdown.findElement(By.xpath("//option[. = '0078903828 -- CROATIA COLLECTION --- NGN {1,999,999,999.95}']")).click();
//}
//driver.findElement(By.id("middleContent_drpDestination")).click();
//{
//  WebElement dropdown = driver.findElement(By.id("middleContent_drpDestination"));
//  dropdown.findElement(By.xpath("//option[. = '0080048296 -- TACTICAL ALPHA SOLUTIONS LIMITED --- NGN {119,239.59}']")).click();
//}
