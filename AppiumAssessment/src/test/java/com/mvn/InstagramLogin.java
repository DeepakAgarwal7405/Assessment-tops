package com.mvn;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;


	public class InstagramLogin extends BaseDemo {

	    public static void main(String[] args) throws IOException {
	        
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("platformVersion", "11.0");
	        caps.setCapability("deviceName", "Xiaomi Redmi Note 5 Pro");
	        caps.setCapability("appPackage", "com.instagram.android");
	        caps.setCapability("appActivity", "com.miui.instagram.inst.InstagramActivity");

	        
	        AppiumDriver driver = null;
	        try {
	            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }

	        // Perform login with valid credentials
	        login(driver, "valid_user", "valid_password");

	        // Generate report for the result
	        generateReport(driver, "Valid_Login_Result.png");

	        // Perform login with invalid credentials
	        login(driver, "invalid_user", "invalid_password");

	        // Generate report for the result
	        generateReport(driver, "Invalid_Login_Result.png");

	        // Quit the driver
	        driver.quit();
	    }

	    public static void login(AppiumDriver driver, String username, String password) {
	        try {
	            
	            driver.findElement(AppiumBy.accessibilityId("com.instagram.android:id/log_in_button")).click();

	            driver.findElement(AppiumBy.accessibilityId("hemalpatil")).sendKeys(username);
	            driver.findElement(AppiumBy.accessibilityId("hemal0612")).sendKeys(password);
	            driver.findElement(AppiumBy.accessibilityId("login_button")).click();

	            
	            Thread.sleep(5000);
	        } catch (Exception e) {
	            System.out.println("Login failed: " + e.getMessage());
	        }
	    }

	    public static void generateReport(AppiumDriver driver, String filename) throws IOException {
	        
	        TakesScreenshot screenshot = (TakesScreenshot) driver;

	        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);	       
	        File destFile = new File(filename);
	        org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);

	     
	        if (driver.findElements(By.id("com.instagram.android:id/log_in_button")).size() > 0) {
	            System.out.println("Login successful!");
	        } else {
	            System.out.println("Login failed!");
	        }
	    }	
}

