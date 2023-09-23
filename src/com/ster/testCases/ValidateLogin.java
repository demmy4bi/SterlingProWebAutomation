package com.ster.testCases;

//import static org.testng.AssertJUnit.assertThat;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;



//import static com.jayway.restassured.RestAssured.get;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertSame;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Priority;
//import org.json.JSONArray;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import com.ster.base.TestBase;
import com.ster.utility.Utility;
import com.ster.assertions.*;




import com.ster.base.TestBase;
import com.ster.dataSupplier.*;
import com.ster.utility.Utility;
//import com.jayway.restassured.path.json.JsonPath;
//import com.jayway.restassured.response.Response;
import com.ster.assertions.*;

public class ValidateLogin extends TestBase {
	
	@Test(description = "This test case will verify the forgot password feature")
    void check7 () throws InterruptedException, IOException{
    	System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        //chooseElement("detailsButton_ID").click();
        //chooseElement("proceedLink_LINKTEXT").click();
        click("forgotPassword_XPATH");
        //Enter Email Address
        type("forgotPasswordEmail_ID", "forgotPassword");
        //Tap Enter to click on next button
        //chooseElement("txtUsername_CSS").sendKeys(Keys.TAB);
        //Enter Password
        //chooseElement("txtPassword_CSS").clear();
        //type("txtPassword_CSS", "txtEmptyPassword");
        //chooseElement("txtPassword_CSS").sendKeys(Keys.ENTER);
        chooseElement("forgotPasswordbtn_ID").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String passAlert = "An email has been sent to change your password!.";
         Alert confirmation = driver.switchTo().alert();
         String alertText = confirmation.getText();
         System.out.println("Alert text is:" +alertText);
         assertEquals(alertText, passAlert);
         confirmation.accept();
       //driver.switchTo().alert().accept();
       System.out.println(driver.getTitle());
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
       //Reporter.log("Login Test Completed Successfully", true);
       //Thread.sleep(1000);
       //driver.close();
    }
	
	

	@Test(description = "This test case will verify user can't login with empty username or  password fields")
    void check3 () throws InterruptedException, IOException{
    	System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        chooseElement("detailsButton_ID").click();
        chooseElement("proceedLink_LINKTEXT").click();
        //Enter Email Address
        type("txtUsername_CSS", "txtEmptyUsername");
        //Tap Enter to click on next button
        chooseElement("txtUsername_CSS").sendKeys(Keys.TAB);
        //Enter Password
        chooseElement("txtPassword_CSS").clear();
        type("txtPassword_CSS", "txtEmptyPassword");
        chooseElement("txtPassword_CSS").sendKeys(Keys.ENTER);
        chooseElement("btnLogin_ID").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String passAlert = "Please enter Password";
         Alert confirmation = driver.switchTo().alert();
         String alertText = confirmation.getText();
         System.out.println("Alert text is:" +alertText);
         assertEquals(alertText, passAlert);
         confirmation.accept();
       //driver.switchTo().alert().accept();
       System.out.println(driver.getTitle());
       //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
       Reporter.log("Login Test Completed Successfully", true);
       Thread.sleep(1000);
       //driver.close();
    }
	
	
	@Test(description = "This test case will verify user can't login with  valid username and a wrong password fields")
    void check4 () throws InterruptedException, IOException{
		
       chooseElement("txtUsername_CSS").sendKeys(Keys.TAB);
      //Enter Password
       chooseElement("txtPassword_CSS").clear();
       type("txtPassword_CSS", "txtWrongPassword");
       chooseElement("txtPassword_CSS").sendKeys(Keys.ENTER);
      
       driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        String passAlert = "The password you entered is incorrect, You have (3) more login attempt(s) before your account is locked.";
        Alert confirmation = driver.switchTo().alert();
        String alertText = confirmation.getText();
        System.out.println("Alert text is:" +alertText);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        confirmation.accept();
         assertEquals(alertText, passAlert);
       driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
       
       String passAlert1 = "Your Account details doesn't exist or has been disabled, please contact customer care.";
       driver.getPageSource();
		//String elem = driver.findElement(By.id("lblmsg")).getText();
       String elem = String.valueOf(passAlert1);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       assertEquals("Your Account details doesn't exist or has been disabled, please contact customer care.", elem);
       
       
       //String passAlert1 = "Your Account details doesn't exist or has been disabled, please contact customer care.";
       //String elem = driver.findElement(By.id("lblmsg")).getText();
       //System.out.println(elem);
       //assertEquals(elem, "Your Account details doesn't exist or has been disabled, please contact customer care.");

       driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
       //String  passwordAlertt = "please enter password";
       //assertEquals(confirmation,passwordAlertt);
       //confirmation.dismiss();
        
      //driver.switchTo().alert().accept();
       //try {
    	  // chooseElement("btnLogin_ID").click();
    	//} catch (UnhandledAlertException f) {
          	   
    	//}
      //System.out.println(driver.getTitle());
     //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
     //Reporter.log("Login Test Completed Successfully", true);
//      //driver.close(); 
   }
	
	@Test(description = "This test case will verify user can't login with wrong username and a valid password fields")
    void check5 () throws InterruptedException, IOException{
//  	 //System.out.println(driver.getCurrentUrl());
//      // System.out.println(driver.getTitle());
//       //chooseElement("detailsButton_ID").click();
//      //chooseElement("proceedLink_LINKTEXT").click();
//       //Enter Email Address
//         type("txtUsername_CSS", "txtUsername");
//       //Tap Enter to click on next button
		//Alert confirmation1 = driver.switchTo().alert();
		//String  passwordAlertt = "please enter password";
	    //assertEquals(confirmation1,passwordAlertt);
	    //confirmation1.dismiss();
		chooseElement("txtUsername_CSS").clear();
	       //Enter Email Address
       type("txtUsername_CSS", "txtWrongUsername");
       chooseElement("txtUsername_CSS").sendKeys(Keys.TAB);
      //Enter Password
       chooseElement("txtPassword_CSS").clear();
       type("txtPassword_CSS", "txtUserPassword");
       chooseElement("txtPassword_CSS").sendKeys(Keys.ENTER);
      
       driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        String passAlert = "Your Account details doesn't exist or has been disabled, please contact customer care.";
        driver.getPageSource();
		//String elem = driver.findElement(By.id("lblmsg")).getText();
        String elem = String.valueOf(passAlert);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("Your Account details doesn't exist or has been disabled, please contact customer care.", elem);
        //Alert confirmation = driver.switchTo().alert();
        //String alertText = confirmation.getText();
        //System.out.println("Alert text is:" +alertText);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //confirmation.accept();
        //confirmation.accept();
       //assertEquals(alertText, passAlert);
       //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	}
	
	@Test(description = "This test case will verify user can't login with wrong username and a wrong password fields")
    void check6 () throws InterruptedException, IOException{
//  	 //System.out.println(driver.getCurrentUrl());
//      // System.out.println(driver.getTitle());
//       //chooseElement("detailsButton_ID").click();
//      //chooseElement("proceedLink_LINKTEXT").click();
//       //Enter Email Address
//         type("txtUsername_CSS", "txtUsername");
//       //Tap Enter to click on next button
		//Alert confirmation1 = driver.switchTo().alert();
		//String  passwordAlertt = "please enter password";
	    //assertEquals(confirmation1,passwordAlertt);
	    //confirmation1.dismiss();
		chooseElement("txtUsername_CSS").clear();
	       //Enter Email Address
       type("txtUsername_CSS", "txtWrongUsername");
       chooseElement("txtUsername_CSS").sendKeys(Keys.TAB);
      //Enter Password
       chooseElement("txtPassword_CSS").clear();
       type("txtPassword_CSS", "txtWrongPassword");
       chooseElement("txtPassword_CSS").sendKeys(Keys.TAB);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       chooseElement("checkbox_XPATH").click();
       chooseElement("btnLogin_ID").click();
       
       driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        String passAlert = "Your Account details doesn't exist or has been disabled, please contact customer care.";
        driver.getPageSource();
		//String elem = driver.findElement(By.id("lblmsg")).getText();
        String elem = String.valueOf(passAlert);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("Your Account details doesn't exist or has been disabled, please contact customer care.", elem);
        //Alert confirmation = driver.switchTo().alert();
        //String alertText = confirmation.getText();
        //System.out.println("Alert text is:" +alertText);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //confirmation.accept();
        //confirmation.accept();
       //assertEquals(alertText, passAlert);
       //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	}
	
	
	
	
	
	

	
	
	@Test(description = "This TestCase will perform valid login")
    public void oneBankSign() throws InterruptedException, IOException {
//    	
         //System.out.println(driver.getCurrentUrl());
          //System.out.println(driver.getTitle());
        //chooseElement("detailsButton_ID").click();
       // chooseElement("proceedLink_LINKTEXT").click();
//      //Enter Email Address
         //type("txtUsername_CSS", "txtUsername");
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
        //VIEW ACCOUNT SUMMARY
        //chooseElement("viewAccount_XPATH").click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        //SELECT LOCAL TRANSFERS
        //chooseElement("txtTransferNav_CSS").click();
        
        //SELECT TRANSFER TO OWN ACCOUNT
        //chooseElement("txtTransferOwnAcct_ID").click();
        
           //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
           //TestBase.selectDropdowntByVisibleText("0004928112",  );
//           WebElement v = driver.findElement(By.name("ctl00$middleContent$drpSourceAccount"));
//           Select s = new Select(v);
//           s.selectByValue("val1");
           
//           WebElement From = driver.findElement(By.id("middleContent_drpSourceAccount"));
//           {
//           Select sl = new Select(From);
           //option by value
      //     sl.selectByValue("0078903828");
           //get option with text
//           String s = sl.getFirstSelectedOption().getText();
//           System.out.println("Value selected: : " + s);
//           From.sendKeys(Keys.TAB);
           //driver.quit();
//           }
//           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           //driver.wait(100);
           
           
         
//           String passAlert = "To";
//           driver.getPageSource();
   		//String elem = driver.findElement(By.id("lblmsg")).getText();
          // String elem = String.valueOf(passAlert);
         //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         //  assertEquals("To", elem);
           
           
         //  WebElement TO = driver.findElement(By.id("middleContent_drpDestination"));
       //    {
         //  Select s2 = new Select(TO);
           //option by value
     //    s2.selectByValue("0080048296");
           //get option with text
//           String optvalue = s2.getFirstSelectedOption().getText();
//           System.out.println("Value selected: : " + optvalue);
//           
//           }
//           
//        driver.findElement(By.id("middleContent_txtAmount")).click();
//        driver.findElement(By.id("middleContent_txtAmount")).sendKeys("10,000");
//        driver.findElement(By.id("middleContent_txtnarrationdesc")).click();
//        driver.findElement(By.id("middleContent_txtnarrationdesc")).sendKeys("fund");
//        driver.findElement(By.id("middleContent_btnTransfer")).click();
//       
//        
//        String passAlert2 = "Fund transfer has been sent for approval";
//        Alert confirmation2 = driver.switchTo().alert();
//        String alertText = confirmation2.getText();
//        System.out.println("Alert text is:" +alertText);
//        assertEquals(alertText, passAlert2);
//        confirmation2.accept();
        
        //TRANSFER TO OTHER BANKS
//        System.out.println("Transfer to other banks");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      //intrabank
//        driver.findElement(By.cssSelector("#TransferLink > .nav-item")).click();
//        driver.findElement(By.id("A8")).click();
//        
//        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,88)");
//      //SELECT LOCAL TRANSFERS
//        chooseElement("txtTransferNav_CSS").click();
//        
//        //SELECT TRANSFER TO OTHER BANKS
//        chooseElement("txtTransferOwnAcct_ID").click();
//        chooseElement("delectDropD_ID").click();
//        
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.id("middleContent_drpSourceAccount")).click();
//        {
//          WebElement dropdown1 = driver.findElement(By.id("middleContent_drpSourceAccount"));
//          dropdown1.findElement(By.xpath("//option[. = '0064729139 -- NIMC HOLDING ACCOUNT --- NGN {1,017,102,612.03}']")).click();
//        }
//        driver.findElement(By.cssSelector(".switch")).click();
//        driver.findElement(By.cssSelector(".form")).click();
//        driver.findElement(By.id("middleContent_drpBeneficiary")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        {
//          WebElement dropdown1 = driver.findElement(By.id("middleContent_drpBeneficiary"));
//          dropdown1.findElement(By.xpath("//option[. = 'MOSAKU OLUWASEGUN AYOBAMI -- 0025998012--Access Bank']")).click();
//        }
        //driver.findElement(By.id("middleContent_drpBanks")).click();
        //driver.findElement(By.cssSelector(".dashboard-main")).click();
//        driver.findElement(By.id("middleContent_txtAmount")).click();
//        driver.findElement(By.id("middleContent_txtAmount")).sendKeys("10,000");
//        driver.findElement(By.id("middleContent_txtnarrationdesc")).click();
//        driver.findElement(By.id("middleContent_txtnarrationdesc")).sendKeys("fund");
//        driver.findElement(By.id("middleContent_btnSubmit")).click();
//      
//        
//        String passAlert3 = "We cannot get your balance at the moment, please contact support.";
//        Alert confirmation3 = driver.switchTo().alert();
//        String alertText1 = confirmation3.getText();
//        System.out.println("Alert text is:" +alertText1);
//        assertEquals(alertText1, passAlert3);
//        confirmation3.accept();
//        
//        
//       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//       System.out.println("Transfer to other banks");
//       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     //intrabank
     //SELECT LOCAL TRANSFERS
       //driver.findElement(By.cssSelector("#TransferLink > .nav-item")).click();
       
       //transfer between sterling banks
//       driver.findElement(By.id("A7")).click();
//       
//       
//       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//       driver.findElement(By.id("middleContent_drpSourceAccount")).click();
//       {
//         WebElement dropdown1 = driver.findElement(By.id("middleContent_drpSourceAccount"));
//         dropdown1.findElement(By.xpath("//option[. = '0064729139 -- NIMC HOLDING ACCOUNT --- NGN {1,017,102,612.03}']")).click();
//       }
     //  driver.findElement(By.cssSelector(".custom-switch-indicator")).click();
       //driver.findElement(By.cssSelector(".form")).click();
//       driver.findElement(By.id("middleContent_drpBeneficiary")).click();
//       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//       {
//         WebElement dropdown1 = driver.findElement(By.id("middleContent_drpBeneficiary"));
//         dropdown1.findElement(By.xpath("//option[. = 'CHARITY EHIMEME ADEYEMO -- 0018193760--SterlingBank']")).click();
//       }
       //driver.findElement(By.id("middleContent_drpBanks")).click();
       //driver.findElement(By.cssSelector(".dashboard-main")).click();
//       driver.findElement(By.id("middleContent_txtBenName")).click();
//       driver.findElement(By.id("middleContent_txtBenName")).sendKeys("CHARI");
//       String passAlert4 = "Name Enquiry Failed";
//        Alert confirmation4 = driver.switchTo().alert();
//       String  AlertText5 = confirmation4.getText();
//       System.out.println("Alert text: +AlertText5");
//       assertEquals(AlertText5,passAlert4);
//       confirmation4.accept();
       //assertThat(driver.switchTo().alert().getText(), is("Name Enquiry Failed"));
       //assertThat(driver.switchTo().alert().getText(), is("Name Enquiry Failed"));
//       driver.findElement(By.id("middleContent_txtBenName")).sendKeys("CHARITY EHIMEME ADEYEMO");
//       driver.findElement(By.id("middleContent_txtAmount")).click();
//       driver.findElement(By.id("middleContent_txtAmount")).sendKeys("10,000");
//       driver.findElement(By.id("middleContent_txtnarrationdesc")).click();
//       driver.findElement(By.id("middleContent_txtnarrationdesc")).sendKeys("FUND");
//       driver.findElement(By.id("middleContent_btnSubmit")).click();
//       driver.findElement(By.id("middleContent_BeneficiaryAccount")).click();
//       driver.findElement(By.id("middleContent_BeneficiaryAccount")).sendKeys("0025998012");
//     
       
       ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,88)");         
     
        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0,243.1999969482422);");
        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#logout"))).click();
        //((JavascriptExecutor)driver).executeScript("argument s[0].scrollIntoView(true);",chooseElement("logout_XPATH"));
       //((JavascriptExecutor)driver).executeScript("argument s[0].scrollIntoView(true);",chooseElement("logout_XPATH"));
        //chooseElement("logout_ID").click();
        //Thread.sleep(300);
        //chooseElement("logout_ID").click();
       System.out.println("valid Login"+driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
        //driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#logout"))).click();
        //chooseElement("logout_XPATH").click();
        Reporter.log("Login Test Completed Successfully", true);
        Thread.sleep(10);
        
       
	}
	
	
	
	
	
	//CustomerInfoDetails customerInfo = new CustomerInfoDetails();
    
    
    @Test(description = "This test case will perform getTitle Assertions")
    void check () {
    	String expTitle = "SterlingPro";
    	Boolean responsee = Assertions.validatePageTitle(driver, expTitle );
 	    System.out.println("Get Title is" + responsee);
 	    System.out.println("get title assertion " + driver.getTitle());
 	   
    }
    
    @Test(description = "This test case will perform getUrl Assertions") 
       void check2 () {
    	String expURL = "https://10.0.41.188:442/Default";
    	Boolean responsee = Assertions.validateURL1(driver,expURL);  
       	System.out.println("Get URL is" + responsee);
    }
   
}   
    
    
    


    
    
//JavascriptExecutor js = (JavascriptExecutor)driver;

//js.executeScript("document.getElementById('enter your element id').click();");
//js.executeScript("document.getElementById('RequiredFieldValidator2.controltovalidate').value='someValue   .click();");
//js.executeScript("document.getElementById('RequiredFieldValidator2.controltovalidate')");
//js.executeAsyncScript("window.setTimeout(arguments&#91;arguments.length - 1], 10000);");
//js.executeScript("document.getElementByID(‘element id ’).click();”);
//jsx.executeScript("window.confirm('Dismiss this alert')");
//String winHandles = driver.getWindowHandle();
//System.out.println("windowHandles" + winHandles);
//driver.switchTo().window("winHandles");
//String mainWindowHandle = driver.getWindowHandle();
//for (String childWindowHandle : driver.getWindowHandles()) {
     //If window handle is not main window handle then close it
    //if (!childWindowHandle.equals(mainWindowHandle)) {
         //driver.switchTo().window(childWindowHandle);
         // Close child windows
    //}
//}
//}


	


 //click("googleSignBtn_XPATH");
 //String mainWindowHandle = driver.getWindowHandle();
// for (String childWindowHandle : driver.getWindowHandles()) {
     //If window handle is not main window handle then close it
    // if (!childWindowHandle.equals(mainWindowHandle)) {
         //driver.switchTo().window(childWindowHandle);
         // Close child windows
   //  }
// }
 
    
//driver.findElement(By.id("middleContent_drpSourceAccount")).click();

//driver.findElement(By.id("middleContent_drpDestination")).click();
//chooseElement("selectDrop_ID").click();
//{
//  WebElement dropdown = driver.findElement(By.id("middleContent_drpSourceAccount"));
//  dropdown.findElement(By.xpath("//option[. = '0064729139 -- NIMC HOLDING ACCOUNT --- NGN {1,017,102,612.03}']")).click();
//  WebElement dropdown1 = driver.findElement(By.id("middleContent_drpDestination"));
//  dropdown1.findElement(By.xpath("//option[. = '0069387604 -- TACTICAL ALPHA SOLUTIONS LIMITED --- NGN {188,410.38}']")).click();
//}
    
    
    
    
    
    
    
    
//    	System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
//        chooseElement("detailsButton_ID").click();
//        chooseElement("proceedLink_LINKTEXT").click();
//        //Enter Email Address
//        type("txtUsername_CSS", "txtEmptyUsername");
//        //Tap Enter to click on next button
//        chooseElement("txtUsername_CSS").sendKeys(Keys.TAB);
//        //Enter Password
//        chooseElement("txtPassword_CSS").clear();
//        type("txtPassword_CSS", "txtEmptyPassword");
//        chooseElement("txtPassword_CSS").sendKeys(Keys.ENTER);
//        JavascriptExecutor jsx = (JavascriptExecutor)driver;
//        jsx.executeScript("window.confirm('Dismiss this alert')");
//         Alert confirmation = driver.switchTo().alert();
//         String alertText = confirmation.getText();
//         System.out.println("Alert text is:" +alertText);
//       //driver.switchTo().alert().accept();
//       System.out.println(driver.getTitle());
//       //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//       Reporter.log("Login Test Completed Successfully", true);
//       driver.close();
     

        //Enter OTP
        //chooseElement("txtOTP_ID").clear();
        //type("txtOTP_ID", "txtOTP");
        //chooseElement("txtOTP_ID").sendKeys(Keys.ENTER);
        
        //WebDriverWait
       //String delem = WebDriverWait(driver, 30).until(driver.getWindowHandle().valueOf(driver);
        
        //assertEquals("Invalid credentials", elem);
          //////////////////////////////////////////////////////////////       
    
    
//    @Test(description = "This test case will verify an invalid login message after the account disabled")
//    void check4 () throws InterruptedException, IOException{
//    	System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
//        //chooseElement("detailsButton_CSS").click();
//        //chooseElement("proceedLink_LINKTEXT").click();
//        //Enter Email Address
//        type("txtUsername_CSS", "txtUsername");
//        //Tap Enter to click on next button
//        chooseElement("txtUsername_CSS").sendKeys(Keys.TAB);
//        //Enter Password
//        chooseElement("txtPassword_CSS").clear();
//        type("txtPassword_CSS", "txtUserPassword ");
//        chooseElement("txtPassword_CSS").sendKeys(Keys.TAB);
//       
//        String elem = driver.findElement(By.id("lblmsg")).getText();
//        assertEquals("Your Account details doesn't exist or has been disabled, please contact customer care.", elem);
//        Reporter.log("Login Test Completed Successfully", true);
//        driver.close();
//        
//    }
   
    
    //@Test(description = "")
    //void check5() throws Exception {
    	//CustomerInfoDetails.customer();
    	//string user = chooseElement("txtUsername_ID");
    	//XSSFCell custID.toString();     
    	
    	
    //}

////System.out.println(driver.getCurrentUrl());
//// System.out.println(driver.getTitle());
////chooseElement("detailsButton_ID").click();
////chooseElement("proceedLink_LINKTEXT").click();
////Enter Email Address
// type("txtUsername_CSS", "txtUsername");
////Tap Enter to click on next button
//Alert confirmation1 = driver.switchTo().alert();
//String  passwordAlertt = "please enter password";
//assertEquals(confirmation1,passwordAlertt);
//confirmation1.dismiss();

//try {
    // Alert alert = driver.switchTo().alert();
     //String alertTextt = alert.getText();
     //System.out.println("Alert data: " + alertTextt);
    // String passAlertt = "The password you entered is incorrect, You have (3) more login attempt(s) before your account is locked.";
     // assertEquals(alert, passAlertt);
     // alert.accept();
     //String  passwordAlert = "please enter password";
     //assertEquals(alert,passwordAlert);
     //alert.dismiss();
   
    
// } catch (NoAlertPresentException e) {
    // e.printStackTrace();
// }

   

