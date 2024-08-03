package com.mvn;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoqaWebtables {
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//to open a website
		driver.get("https://demoqa.com/webtables");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 450)");
		
		driver.findElement(By.id("edit-record-1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("age")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("age")).sendKeys("35");
		Thread.sleep(1000);
		driver.findElement(By.id("salary")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("salary")).sendKeys("25000");
		Thread.sleep(1000);
		
		driver.findElement(By.id("submit")).click();
		
		Thread.sleep(1000);
		File file=((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file,new File("Screenshot\\BeforeDelete.jpg"));
		
		driver.findElement(By.id("delete-record-2")).click();
		Thread.sleep(2000);
		File file2=((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file2,new File("Screenshot\\AfterDelete.jpg"));
		
		
		Thread.sleep(2000);
		driver.close();
		
		
		
	}

}
