package com.mvn;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class GroceryStoreBaseFile {
	AndroidDriver driver;
	AppiumDriverLocalService service;
	@BeforeTest
//	@Test
	public void test() throws Exception{
		UiAutomator2Options opt=new UiAutomator2Options();
		opt.setDeviceName("Deepak");					
		opt.setApp("C:\\Users\\tops\\Workspace\\DeepakAppiumAssignment\\apk file\\General-Store.apk"); 
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), opt);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(2000);	
		
		
	}
	@Test
	public void functions() throws Exception {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("James Bond");
		Thread.sleep(2000);
		
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" + ".scrollIntoView(text(\"India\"));")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		File file=((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file,new File("Screenshot\\Addtocart.jpg"));
		
}

	@AfterTest
	public void closing() {
		
		driver.quit();
	}
}
