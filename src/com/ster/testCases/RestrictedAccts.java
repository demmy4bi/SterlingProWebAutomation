package com.ster.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.ster.base.TestBase;
import com.ster.utility.Utility;

import static com.jayway.restassured.RestAssured.get;
public class RestrictedAccts extends TestBase{
	@Test (description = "This would check if account is restricted")
	void getAccountInfo() {
	Response resp = null;
	try {
	//getting FioranoUrl from config and concatenating with variable holding the account number
	resp = get(((String) Utility.fetchProperty("fioranoAccInfo")).concat("0072433114") );
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	JsonPath jsonPath = resp.jsonPath();
	String response = jsonPath.get("BankAccountFullInfo.REST_FLAG");
	System.out.println(response);
	Assert.assertEquals(response, "FALSE"); }

}
