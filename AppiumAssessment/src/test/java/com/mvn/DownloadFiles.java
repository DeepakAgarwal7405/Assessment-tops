package com.mvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadFiles {

	@Test
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Xiaomi Redmi Note 5 Pro");
        caps.setCapability("appPackage", "com.Tops.android");
        caps.setCapability("appActivity", "com.miui.Top.TopsActivity");

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        
        login(driver, "9879969052", "Hemal@0612");

        navigateToAssignmentsAndProjects(driver);
        
        downloadFiles(driver);
       
        driver.quit();
    }

    public static void login(AppiumDriver driver, String username, String password) {
       
    }

    public static void navigateToAssignmentsAndProjects(AppiumDriver driver) {
        
    }

    public static void downloadFiles(AppiumDriver driver) throws InterruptedException {
        
        driver.findElement(AppiumBy.accessibilityId("assignment_download_button")).click();
       
        Thread.sleep(5000);
        
        File downloadedAssignment = new File("/path/to/downloaded/assignment");
        
        File destinationAssignment = new File("/path/to/proper/location/assignment");
        
        downloadedAssignment.renameTo(destinationAssignment);
        
        driver.findElement(AppiumBy.accessibilityId("project_download_button")).click();
        Thread.sleep(5000);
        
        File downloadedProject = new File("/path/to/downloaded/project");
        
        File destinationProject = new File("/path/to/proper/location/project");
        
        downloadedProject.renameTo(destinationProject);
    }


}


