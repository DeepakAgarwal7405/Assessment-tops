package com.mvn;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
	public class clockrealdevice {

	@Test
		public void alarmclock()throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName","realme RMX3151");
		cap.setCapability("udid","AMBQSWLVPVVWEAVK");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformverson","12.0");
		cap.setCapability("appPackage", "com.coloros.alarmclock");
		cap.setCapability("appActivity", "com.oplus.alarmclock.AlarmClock");
		cap.setCapability("automationName", "UIAutomator2");
		
		URL url=new URL("http://127.0.0.1:4723/");
		
		AppiumDriver driver=new AppiumDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 Thread.sleep(2000);
			
		 driver.findElement(AppiumBy.accessibilityId("Add Alarm")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(AppiumBy.accessibilityId("Confirm")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(AppiumBy.accessibilityId("Add Alarm")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"AM\"));")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(AppiumBy.accessibilityId("Confirm")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView")).click();
		 Thread.sleep(2000);
		 
	     driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[4]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView")).click();
	     Thread.sleep(2000);
	     
		 driver.quit();		 
		}
	}


