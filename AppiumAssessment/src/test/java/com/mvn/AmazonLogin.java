package com.mvn;

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

public class AmazonLogin {

    public static void main(String[] args) throws IOException {
        
    	 DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("platformVersion", "11.0");
	        caps.setCapability("deviceName", "Xiaomi Redmi Note 5 Pro");
	        caps.setCapability("appPackage", "com.Amazon.android");
	        caps.setCapability("appActivity", "com.miui.Amazon.Amz.AmazonActivity");
        AppiumDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

       
        login(driver, "hemalpatil611@gmail.com", "Hemal@1212");

        generateReport(driver, "Valid_Login_Result.png");

        login(driver, "hemalpatil@gmail.com", "Hemal0111");

        generateReport(driver, "Invalid_Login_Result.png");

       
        driver.quit();
    }

    public static void login(AppiumDriver driver, String username, String password) {
        try {
            
            driver.findElement(AppiumBy.accessibilityId("com.amazon.mShop.android.shopping:id/sign_in_button")).click();

            driver.findElement(AppiumBy.accessibilityId("hemalpatil661@gmail.com")).sendKeys(username);
            driver.findElement(AppiumBy.accessibilityId("Hemal1212")).sendKeys(password);

     
            driver.findElement(AppiumBy.accessibilityId("signInSubmit")).click();

            
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

        if (driver.findElements(AppiumBy.accessibilityId("com.amazon.mShop.android.shopping:id/sign_in_button")).size() > 0) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}
