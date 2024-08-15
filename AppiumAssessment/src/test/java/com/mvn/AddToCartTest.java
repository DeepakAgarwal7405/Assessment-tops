package com.mvn;
import org.openqa.selenium.By;
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

public class AddToCartTest {

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
        addToCart(driver, true);
        generateReport(driver, "Add_To_Cart_With_Login_Result.png");
        addToCart(driver, false);
        generateReport(driver, "Add_To_Cart_Without_Login_Result.png");

        driver.quit();
    }

    public static void addToCart(AppiumDriver driver, boolean login) {
        try {
          
            if (login) {
               
                driver.findElement(AppiumBy.accessibilityId("com.amazon.mShop.android.shopping:id/sign_in_button")).click();

                driver.findElement(AppiumBy.accessibilityId("ap_email")).sendKeys("hemalpatil661@gmail.com");
                
                driver.findElement(AppiumBy.accessibilityId("ap_password")).sendKeys("Hemal0612");

     
                driver.findElement(AppiumBy.accessibilityId("signInSubmit")).click();

                Thread.sleep(5000);
            }
           
            driver.findElement(AppiumBy.accessibilityId("com.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("Shoes");
            
            driver.findElement(AppiumBy.accessibilityId("com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout")).click(); 
            
            driver.findElement(By.id("product_id")).click();
            
            driver.findElement(AppiumBy.accessibilityId("add_to_cart_button")).click();

        
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("Test case failed: " + e.getMessage());
        }
    }

    public static void generateReport(AppiumDriver driver, String filename) throws IOException {
       
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(filename);

        org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);

       
        if (driver.findElements(AppiumBy.accessibilityId("HemalPatil")).size() > 0) {
            System.out.println("Test case successful: Product added to cart!");
        } else {
            System.out.println("Test case failed: Product not added to cart!");
        }
    }
}
    
