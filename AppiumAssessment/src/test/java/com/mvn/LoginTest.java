package com.mvn;

import java.sql.Driver;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {
	@Test

    public static void main(String[] args) throws IOException {
      
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Xiaomi Redmi Note 5 Pro");
        caps.setCapability("appPackage", "com.Tops.android");
        caps.setCapability("appActivity", "com.miui.Top.TopsActivity");


        AppiumDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        login(driver, "9879969052", "Hemal@0612");

        verifyLoginResult(driver);

        driver.quit();
    }

    public static void login(AppiumDriver driver, String username, String password) {
        try {
            
            driver.findElement(AppiumBy.accessibilityId("username_field")).sendKeys(username);

            
            driver.findElement(AppiumBy.accessibilityId("password_field")).sendKeys(password);

            driver.findElement(AppiumBy.accessibilityId("login_button")).click();

            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }

    public static void verifyLoginResult(AppiumDriver driver) throws IOException {
        
        if (driver.findElements(AppiumBy.accessibilityId("success_element")).size() > 0) {
            System.out.println("Login successful!");
           
            takeScreenshot(driver, "login_success.png");
        } else {
            System.out.println("Login failed! Error message: " + driver.findElement(AppiumBy.accessibilityId("error_message")).getText());
         
            takeScreenshot(driver, "login_error.png");
        }
    }

    public static void takeScreenshot(AppiumDriver driver, String filename) throws IOException {
       
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        
        File destFile = new File(filename);
        
        org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);

        System.out.println("Screenshot saved as " + filename);
    

	}

}
