package com.mvn;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPressDemo extends BaseTest {
	@Test
	public void LongPress() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]"))
		.click();
		Thread.sleep(2000);
		
		// //class_value[@text='text_value']
	WebElement e1=	driver.
	findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
	longPressAction(e1);
	Thread.sleep(2000);


	String msg= driver.findElement(By.id("android:id/title")).getText();
	assertEquals(msg, "Sample menu");
	
		
		
	}

}
