package com.mvn;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import org.openqa.selenium.By;
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

public class AmazonAddToCart {

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

        searchAndAddToCart(driver, "iPhone");

        driver.quit();
    }

    public static void searchAndAddToCart(AppiumDriver driver, String productName) {
        try {
            
            driver.findElement(AppiumBy.accessibilityId("com.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys(productName);
            
            driver.findElement(AppiumBy.accessibilityId("com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout")).click();

            driver.findElement(AppiumBy.accessibilityId("Shoes")).click();
   
            driver.findElement(AppiumBy.accessibilityId("add_to_cart_button")).click();

            Thread.sleep(5000);

           
            takeScreenshot(driver, "Cart.png");
        } catch (Exception e) {
            System.out.println("Failed to add product to cart: " + e.getMessage());
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
