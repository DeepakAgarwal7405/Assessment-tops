package com.mvn;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseDemo 
{
public AndroidDriver driver;
	
	@BeforeMethod
	public void beforemethod() throws MalformedURLException, InterruptedException {
		
	UiAutomator2Options options=new UiAutomator2Options();
	
	options.setDeviceName("Hemal");
	
	options.setApp("D:\\apk\\ApiDemos-debug.apk");
	//options.setApp("D:\\apk\\facebook_lite_v321.0.0.13.113.apk");
	//options.setApp("D:\\apk\\General-Store.apk");
    //options.setApp("D:\\apk\\instagram-254-0-0-19-109.apk");
	//options.setApp(""https://careercenter.tops-int.com/"");

	driver=new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Thread.sleep(6000);
	
	}
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}

	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
			 
			    "direction", direction,
			    "percent", 0.15
			));	
	}
	public void dragNDrop(WebElement source) {
	((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) source).getId(),
		    "endX", 619,
		    "endY", 560
		));
	}
	public void aftermethod()
	{
		driver.quit();
	}
}
