package com.ster.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ster.utility.Utility;

import java.io.IOException;

public class Assertions {


    public static boolean validateURL1(WebDriver driver, String expURL) {
        boolean url = false;
        if (driver.getCurrentUrl().equalsIgnoreCase(expURL)) {
            url = true;
        }
        return url;

    }

    public static boolean validatePageTitle(WebDriver driver, String expTitle) {
        boolean title = false;
        if (driver.getTitle().equalsIgnoreCase(expTitle)) {
            title = true;
        }
        return title;
    }

    public static boolean validateErrorMsg(WebDriver driver, String expErrorMsg) {
        boolean errorMsg = false;
        
        if (driver.getPageSource().contains(expErrorMsg)) {
            errorMsg = true;
        }
        return errorMsg;
        ///
    }
    
    


}

