package com.mvn;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class UploadReviewImages {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Xiaomi Redmi Note 5 Pro");
        caps.setCapability("appPackage", "com.Tops.android");
        caps.setCapability("appActivity", "com.miui.Top.TopsActivity");
        
        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        driver.get("https://careercenter.tops-int.com/");

        uploadGoogleReviewImage(driver);

        
        uploadFacebookReviewImage(driver);

        driver.quit();
    }

    public static void uploadGoogleReviewImage(AppiumDriver driver) {
        
        driver.findElement(AppiumBy.accessibilityId("google_review_upload_button")).click();

        
    }

    public static void uploadFacebookReviewImage(AppiumDriver driver) {
        
        driver.findElement(AppiumBy.accessibilityId("facebook_review_upload_button")).click();

       
    }
}

	



