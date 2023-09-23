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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.ster.base.TestBase;
import com.ster.utility.Utility;

public class LocalBankTransfers extends TestBase{
	
	
	@Test (description = "This would check if account is restricted")
	void getAccountInfo() {
		Response resp = null;
		try {
			//getting FioranoUrl from config and concatenating with variable holding the account number
			resp = get(((String) Utility.fetchProperty("fioranoAccInfo")).concat("0064729139") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonPath jsonPath = resp.jsonPath();
		String response = jsonPath.get("BankAccountFullInfo.REST_FLAG");
		System.out.println(response);
		Assert.assertEquals(response, "FALSE");
	}

	
	@Test(description = "This TestCase will perform intrabank transfers between Sterling accounts")
    public void intrabankSterling() throws InterruptedException, IOException {
		  System.out.println(driver.getTitle());
          chooseElement("detailsButton_ID").click();
          chooseElement("proceedLink_LINKTEXT").click();
          //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
        driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
        driver.navigate().refresh();
        //VIEW ACCOUNT SUMMARY
        //chooseElement("viewAccount_XPATH").click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        //TRANSFER TO OTHER BANKS
        System.out.println("Transfer to other banks");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      //intrabank
        //SELECT LOCAL TRANSFERS
        driver.findElement(By.cssSelector("#TransferLink > .nav-item")).click();
        
        //transfer between sterling banks
        driver.findElement(By.id("A7")).click();
        

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
		
		driver.findElement(By.cssSelector(".custom-switch-indicator")).click();
		driver.findElement(By.cssSelector(".form")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
		WebElement TO = driver.findElement(By.id("middleContent_drpBeneficiary"));
		{
			Select s2 = new Select(TO);
			//option by value
			s2.selectByValue("0068632620");
			//get option with text
			String optvalue = s2.getFirstSelectedOption().getText();
			System.out.println("Value selected: : " + optvalue);

		}
        
	
        
        Thread.sleep(100);
        //assertThat(driver.switchTo().alert().getText(), is("Name Enquiry Failed"));
        //assertThat(driver.switchTo().alert().getText(), is("Name Enquiry Failed"));
        //driver.findElement(By.id("middleContent_txtBenName")).sendKeys("CHARITY EHIMEME ADEYEMO");
        driver.findElement(By.id("middleContent_txtAmount")).click();
        driver.findElement(By.id("middleContent_txtAmount")).sendKeys("0");
        driver.findElement(By.id("middleContent_txtAmount")).clear();
        driver.findElement(By.id("middleContent_txtAmount")).sendKeys("-1");
        driver.findElement(By.id("middleContent_txtAmount")).clear();
        driver.findElement(By.id("middleContent_txtAmount")).sendKeys("10,000");
        driver.findElement(By.id("middleContent_txtnarrationdesc")).click();
        driver.findElement(By.id("middleContent_txtnarrationdesc")).sendKeys("FUND");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(100);
        driver.findElement(By.id("middleContent_btnSubmit")).click();
                 Reporter.log("Login Test Completed Successfully", true);
         Thread.sleep(10);
         
        
 		}

}





//driver.findElement(By.id("middleContent_drpBanks")).click();
//driver.findElement(By.cssSelector(".dashboard-main")).click();
//driver.findElement(By.id("middleContent_txtBenName")).click();
//driver.findElement(By.id("middleContent_txtBenName")).sendKeys("CHARI");
//String passAlert4 = "Name Enquiry Failed";
// Alert confirmation4 = driver.switchTo().alert();
//String  AlertText5 = confirmation4.getText();
//System.out.println("Alert text: +AlertText5");
//assertEquals(AlertText5,passAlert4);
//confirmation4.accept();

//driver.findElement(By.id("middleContent_BeneficiaryAccount")).click();
//driver.findElement(By.id("middleContent_BeneficiaryAccount")).sendKeys("0025998012");

//driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
// driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);



//((JavascriptExecutor)driver).executeScript("window.scrollTo(0,88)");         

 //((JavascriptExecutor) driver).executeScript("window.scrollTo(0,243.1999969482422);");
 //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#logout"))).click();
 //((JavascriptExecutor)driver).executeScript("argument s[0].scrollIntoView(true);",chooseElement("logout_XPATH"));
//((JavascriptExecutor)driver).executeScript("argument s[0].scrollIntoView(true);",chooseElement("logout_XPATH"));
 //chooseElement("logout_ID").click();
 //Thread.sleep(300);
 //chooseElement("logout_ID").click();
//System.out.println("valid Login"+driver.getTitle());
// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
 //driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
 //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#logout"))).click();
 //chooseElement("logout_XPATH").click();

//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//driver.findElement(By.id("middleContent_drpSourceAccount")).click();
//{
//  WebElement dropdown1 = driver.findElement(By.id("middleContent_drpSourceAccount"));
//  dropdown1.findElement(By.xpath("//option[. = '0064729139 -- NIMC HOLDING ACCOUNT --- NGN {1,017,102,612.03}']")).click();
//  
//}
////driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//driver.findElement(By.cssSelector(".custom-switch-indicator")).click();
////driver.findElement(By.cssSelector(".form")).click();
////driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//driver.findElement(By.id("middleContent_drpBeneficiary")).click();
//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//
//{
//  WebElement dropdown1 = driver.findElement(By.id("middleContent_drpBeneficiary"));
//  dropdown1.findElement(By.xpath("//option[. = 'CHARITY EHIMEME ADEYEMO -- 0018193760--SterlingBank']")).click();
//}
//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

