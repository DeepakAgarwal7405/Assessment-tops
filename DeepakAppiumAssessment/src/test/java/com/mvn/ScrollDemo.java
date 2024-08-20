package com.mvn;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {
	@Test
	public void Scroll() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		Thread.sleep(3000);
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView"
						+ "(text(\"WebView\"));")).click();
		Thread.sleep(1000);
	}

}
