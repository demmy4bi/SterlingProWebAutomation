package com.ster.testCases;

import static org.testng.Assert.assertEquals;
//import static org.testng.AssertJUnit.assertThat;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ster.base.TestBase;

public class Beneficiaries extends TestBase {
	@Test(description = "This TestCase will allow user view list of beneficiaries")
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
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,88)"); 
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0,243.1999969482422);");
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//p[contains(.,'Settings')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		element.click();
		//((JavascriptExecutor)driver).executeScript("window.scrollTo(0,30)"); 
		//driver.findElement(By.cssSelector(".nav-item-block:nth-child(13) p")).click();
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0,243.1999969482422);");
	    driver.findElement(By.id("manage")).click();
	    driver.findElement(By.cssSelector(".table-row:nth-child(2) .item-delete")).click();
	    String passAlert3 = "Do you want to delete ?";
        Alert confirmation3 = driver.switchTo().alert();
        String alertText1 = confirmation3.getText();
        System.out.println("Alert text is:" +alertText1);
        assertEquals(alertText1, passAlert3);
        confirmation3.accept();
         
	    //assertThat(driver.switchTo().alert().getText(), is("Do you want to delete ?"));
	    driver.switchTo().alert().dismiss();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0,243.1999969482422);");
		driver.close();
	}


}
