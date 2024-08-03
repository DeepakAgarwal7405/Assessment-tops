package com.mvn;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//to open a website
		driver.get("https://www.demo.guru99.com/V4/index.php");
		
		
		driver.findElement(By.name("uid")).sendKeys("mngr583554");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("enedYj");//enedYjy
		Thread.sleep(2000);
		
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(2000);
		try {
			Alert a2=driver.switchTo().alert();
			System.out.println(a2.getText());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		System.out.println("Before screenshot");
		try {
			File file3=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
//		Files.copy(file3,new File("Screenshot\\FailLogin.jpg"));
		
		System.out.println("After screenshot");
//		a1.dismiss();
		Thread.sleep(2000);
//		a2.accept();
		
		Thread.sleep(2000);
//		driver.close();
	}

}
