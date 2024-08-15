package com.mvn;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
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
import java.util.concurrent.TimeUnit;

	public class InstagramRegistration extends BaseDemo
	{

	    public static void main(String[] args) throws IOException, InterruptedException {
	        
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("platformVersion", "11.0");
	        caps.setCapability("deviceName", "Xiaomi Redmi Note 5 Pro");
	        caps.setCapability("appPackage", "com.instagram.android");
	        caps.setCapability("appActivity", "com.miui.instagram.inst.InstagramActivity");

	        Capabilities cap = null;
			AppiumDriver driver=new AppiumDriver(new URL("http://127.0.0.1:4723/"),cap);
	   	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   	    Thread.sleep(2000);
	        
	        registerOnInstagram(driver);

	        takeScreenshot(driver, "registration_success.png");

	        driver.quit();
	    }

	    public static void registerOnInstagram(AppiumDriver driver) {
	        try {
	            // Click on "Sign up with email or phone number"
	            driver.findElement(MobileBy.id("com.instagram.android:id/sign_up_with_email_or_phone_number")).click();

	            // Enter email, username, and password
	            driver.findElement(AppiumBy.accessibilityId("com.instagram.android:id/email_or_phone")).sendKeys("hemalpatil165@gmail.com");
	            driver.findElement(AppiumBy.accessibilityId("com.instagram.android:id/full_name")).sendKeys("HemalPatil661");
	            driver.findElement(AppiumBy.accessibilityId("com.instagram.android:id/password")).sendKeys("Hemal@1212");

	         
	            driver.findElement(AppiumBy.accessibilityId("com.instagram.android:id/next_button")).click();
	            Thread.sleep(10000);

	            System.out.println("Registration successful!");
	        } catch (Exception e) {
	            System.out.println("Registration failed: " + e.getMessage());
	        }
	    }

	    public static void takeScreenshot(AppiumDriver driver, String filename) throws IOException {
	        
	        TakesScreenshot screenshot = (TakesScreenshot) driver;

	        
	        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

	        
	        File destFile = new File(filename);

	        // Copy file at destination
	        org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);
	    }
	}

