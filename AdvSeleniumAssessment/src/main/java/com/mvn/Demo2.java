package com.mvn;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo2 {
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
		
		try {
            driver.findElement(By.name("btnLogin")).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
            wait.until(ExpectedConditions.alertIsPresent());
        Alert a1=driver.switchTo().alert();
        Thread.sleep(2000);
//        try {
//            BufferedImage image = new Robot()
//                    .createScreenCapture
//                    (new Rectangle
//                            (Toolkit
//                                    .getDefaultToolkit()
//                                    .getScreenSize()));
//            ImageIO.write(image, "png", new File("Screenshot\\Test.png"));
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
        

        
        
        //File file3=((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
//		Files.copy(file3,new File("Screenshot\\FailLogin.jpg"));
		
		
		
		
        System.out.println(a1.getText());
        Thread.sleep(2000);
//        
        
        a1.accept();
		
	
	}
}
