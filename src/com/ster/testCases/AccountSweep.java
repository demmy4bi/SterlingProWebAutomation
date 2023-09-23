package com.ster.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ster.base.TestBase;

public class AccountSweep extends TestBase {
	@Test(description = "This TestCase will perform intrabank transfers between accounts")
    public void Sweep() throws InterruptedException, IOException {
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
		
	//driver.findElement(By.xpath("//li[@id='LiquidationMgt']/span/p")).click();
		driver.findElement(By.cssSelector("#LiquidationMgt p")).click();
	    driver.findElement(By.id("A28")).click();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    
	    WebElement element = driver.findElement(By.linkText("Setup Sweep"));
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-100);", element);
		Actions actions = new Actions(driver);
	    actions.moveToElement(element).click().perform();
	    driver.navigate().to("https://10.0.41.188:442/LiquidationManagement/IntraSweeping");
	    Thread.sleep(2*60*1000);
		//element.click();
	    //driver.getPageSource().matches("Setup Sweep");
	    //driver.findElement(By.id("Setup Sweep"));
	   // Point p = new Point(0,10000);
	    //driver.manage().window().setPosition(p);
	    //Thread.sleep(10000);
	    //driver.get("https://10.0.41.188:442/LiquidationManagement/AutomatedIntraSweeping");
	    //driver.findElement(By.linkText("Setup Sweep")).click();
	    //WebElement element = driver.findElement(By.linkText("Setup Sweep"));
	    //Actions actions = new Actions(driver);
	    //actions.moveToElement(element).click().perform();
	    
//	    WebElement add = driver.findElement(By.cssSelector(".button-default"));
//	    Actions actions = new Actions(driver);
//	    actions.moveToElement(add).click().perform();
//	    driver.navigate().to("https://10.0.41.188:442/LiquidationManagement/IntraSweeping");
//	    
	    
	    //this works just ends that session
//	    String old = driver.getWindowHandle();
//	    String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
//	    driver.findElement(By.linkText("Setup Sweep")).sendKeys(selectLinkOpeninNewTab);
//	    String hd = driver.getWindowHandle();
//	    System.out.println("new window is" + hd);
//	    Thread.sleep(100);
//	    driver.switchTo().window(hd);
	    
	    
	    
	    //this works too
//	    String tb = Keys.chord(Keys.CONTROL,Keys.ENTER);
//	      driver.findElement(By.xpath("//a[contains(@href, 'IntraSweeping.aspx')][2]")).sendKeys(tb);
//	      Thread.sleep(10000);
	      // store window ids in array list
//	      ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
	      //switch to active tab
//	      driver.switchTo().window(wid.get(1));
//	      System.out.println("Page title of active tab: " + driver.getTitle());
//	      WebDriver newTb;
		//switch to parent
	      //driver.switchTo().window(newTb.get(0));
//	      System.out.println("Page title of parent window: " + driver.getTitle());
	    
	    
	 // store window handle ids
	      //ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
	      //switch to open tab
	      //driver.switchTo().window(w.get(1));
	      //System.out.println("New tab title: " + driver.getTitle());
	      //switch to first tab
	      //driver.switchTo().window(w.get(0));
	      //System.out.println("First tab title: " + driver.getTitle());
	      
	      
	    //SearchButton = driver.find_element_by_css_selector('input.add1')
	   // Hover = ActionChains(driver).move_to_element(add);
	    //Hover.click().build().perform()
	   // Thread.sleep(100);
	    //driver.findElement(By.xpath("//a[contains(@href, 'IntraSweeping.aspx')).click();

	    //driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
	   // driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
	   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //chooseElement("SWEEP3_CSS").click();
	    //driver.findElement(By.linkText("Setup Sweep")).click();
	    //driver.get("https://10.0.41.188:442/LiquidationManagement/IntraSweeping");
	    driver.findElement(By.id("middleContent_txtSchname")).sendKeys("scheduler1");
	    driver.findElement(By.id("middleContent_drpSourceAccount")).click();
	    new Select(driver.findElement(By.id("middleContent_drpSourceAccount"))).selectByVisibleText("0004928112 -- VF GLOBAL SERVICES NIGERIA LTD --- NGN {100,943,126,188.01}");
	    driver.findElement(By.id("middleContent_drpDestination")).click();
	    new Select(driver.findElement(By.id("middleContent_drpDestination"))).selectByVisibleText("0064729139 -- NIMC HOLDING ACCOUNT --- NGN {1,017,102,612.03}");
	    driver.findElement(By.id("middleContent_txtAmount")).click();
	    driver.findElement(By.id("middleContent_txtAmount")).clear();
	    driver.findElement(By.id("middleContent_txtAmount")).sendKeys("100");
	    driver.findElement(By.id("middleContent_txtnarrationdesc")).click();
	    driver.findElement(By.id("middleContent_txtnarrationdesc")).clear();
	    driver.findElement(By.id("middleContent_txtnarrationdesc")).sendKeys("fund");
	    //driver.findElement(By.id("middleContent_txtSchname")).click();
	    //driver.findElement(By.id("middleContent_txtSchname")).clear();
	    //driver.findElement(By.id("middleContent_txtSchname")).sendKeys("scheduler");
	    driver.findElement(By.id("middleContent_optPermission_4")).click();
	    driver.findElement(By.id("middleContent_optPermission_5")).click();
	    driver.findElement(By.xpath("//span[@id='middleContent_DtFrom_Control']/img")).click();
	    driver.findElement(By.xpath("//div[@id='popupSuperContent0']/table/tbody/tr[5]/td[3]")).click();
	    driver.findElement(By.xpath("//span[@onclick='objPopCalList[0].dateSelected=22;objPopCalList[0].monthSelected=2;objPopCalList[0].yearSelected=2022;PopCalCloseCalendar(0);']")).click();
	  //  driver.findElement(By.id("middleContent_btnTransfer")).click();
	  //  driver.findElement(By.id("middleContent_txtSchname")).click();
	 //   driver.findElement(By.id("middleContent_txtSchname")).clear();
	  //driver.findElement(By.id("middleContent_txtSchname")).sendKeys("schedul");
	    driver.findElement(By.id("middleContent_btnTransfer")).click();
	   // driver.get("https://10.0.41.188:442/LiquidationManagement/ConfirmSweeping");
	  //driver.findElement(By.id("middleContent_btnTransfer")).click();
		
	
	}
}
