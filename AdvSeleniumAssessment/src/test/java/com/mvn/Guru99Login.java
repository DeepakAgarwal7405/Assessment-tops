package com.mvn;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Guru99Login {
	
	public String[][] readData() throws InvalidFormatException, IOException {
		String[][] data=null;
		
		//1.to select a particular file
		String filepath="data\\Guru99Login.xlsx";

//		String filepath="https://docs.google.com/spreadsheets/d/1Bl6-826IhBJKFCnazJDI8yum8YDopt3p/edit?usp=sharing&ouid=114993191943230335252&rtpof=true&sd=true";

		//2.to make file
		File file=new File(filepath);
		
		//3.to open this excel file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//4.to open a particular sheet
		Sheet sheet=workbook.getSheet("Sheet3");
		
		//5.to check total rows
		int nrow=sheet.getPhysicalNumberOfRows();
		System.out.println("total row is :"+nrow);
		
		data=new String[nrow][];		

		for (int i = 0; i < data.length; i++) {
			//6.to select a row
			Row row=sheet.getRow(i);
			//7.to check total cols
			int ncol=row.getPhysicalNumberOfCells();
			
			
			System.out.println("total no of cols :"+ncol);
			data[i]=new String[ncol];
			for (int j = 0; j < data[i].length; j++) {
				Cell cell=row.getCell(j);
				//8.to convert cell value into string
				cell.setCellType(CellType.STRING);
				//9.to get value from cell
				data[i][j]=cell.getStringCellValue();
				}

			}

				return data;

				
			}
	@Test
	public void test() throws Exception {
		String[][] data=readData();
		for (int i = 0; i < data.length; i++) {
		WebDriver driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//to open a website
		driver.get("https://www.demo.guru99.com/V4/index.php");
		
		
		driver.findElement(By.name("uid")).sendKeys(data[i][0]);
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(data[i][1]);
		Thread.sleep(2000);
		
		  try {
              driver.findElement(By.name("btnLogin")).click();
              Thread.sleep(2000);
          } catch (Exception e) {
              // TODO: handle exception
          }
		
		if(driver.getCurrentUrl().equals("https://www.demo.guru99.com/V4/manager/Managerhomepage.php"))
		{
			System.out.println(data[i][0]+" Username is Login SuccessFully ");
			File file3=((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(file3,new File("Screenshot\\PassLogin.jpg"));
			
			driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]")).click();
			
			Alert a1=driver.switchTo().alert();
			System.out.println(a1.getText());
			
//			a1.dismiss();
			Thread.sleep(2000);
			a1.accept();
			
			Thread.sleep(2000);
			driver.close();
		}
		else {
//			if (data[i][1]=="enedYjy") {
//				System.out.println(data[i][0]+" Password is incorrect ");
//			}
//			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
//            wait.until(ExpectedConditions.alertIsPresent());
      
			
			try {
	    		Alert a1=driver.switchTo().alert();
	            Thread.sleep(2000);
	            System.out.println(a1.getText());
	            try {
	              BufferedImage image = new Robot()
	                      .createScreenCapture
	                      (new Rectangle
	                              (Toolkit
	                                      .getDefaultToolkit()
	                                      .getScreenSize()));
	              ImageIO.write(image, "png", new File("Screenshot\\FailLogin.png"));
	          } catch (Exception e) {
	              // TODO: handle exception
	          }
	            Thread.sleep(2000);
	            a1.accept();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
				Thread.sleep(2000);
//				driver.close();
			
			
			
			
			

			
		}
		
		
		}
	
	}

}
