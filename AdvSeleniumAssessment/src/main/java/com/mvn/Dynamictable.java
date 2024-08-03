package com.mvn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamictable {
	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
	        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
	        
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 1200)");
			
			List<WebElement> th=driver.findElements(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table/thead/tr/th"));
			System.out.println("Total no of column:- "+(th.size()-1));
			
			List<WebElement> tr=driver.findElements(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table/tbody/tr"));
			System.out.println("Total no of Row:- "+tr.size());

			for (int i = 2; i <=th.size(); i++) {
				
				String thname=driver.findElement(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table/thead/tr/th["+i+"]")).getText();
				System.out.print("      |      "+thname);
			}
			System.out.println();
			for (int i = 1; i <=tr.size(); i++) {
				
				for (int j = 1; j <=th.size()-1; j++) {
//					String hdata=driver.findElement(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table/tbody/tr[1]/th["+j+"]")).getText();

					String data=driver.findElement(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
//					System.out.print("    |    "+hdata);
					System.out.print("      |      "+data);
				}
				System.out.println();
				Thread.sleep(1000);
			}
			
			
			
			
			
			
			
			System.out.println("============================== TASK-1 ===========================");
			
			for (int i = 1; i <=4; i++)
			{
		    String rowcount = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div[1]/div[5]/table/tbody/tr["+i+"]/th")).getText();
			System.out.println(rowcount);
		    }
		    System.out.println();
		    
		    
		    
		    System.out.println("============================== TASK-2 ===========================");
		    int last= driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div[1]/div[5]/table/tfoot/tr/th")).size();
		    System.out.println(last + " Heading ");
		    int ast= driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div[1]/div[5]/table/tfoot/tr/td")).size();
		    System.out.println(ast + " Coloumn ");
		    System.out.println(" Hence verified !!!  1 heading & 1 coloumn = Total 2 coloumns having data ");

		    	for (int i = 0; i < 1; i++) {
		    	String g=driver.findElement(By.xpath("//table[@summary='Sample Table']/tfoot/tr")).getText();	
				System.out.println(g);
		    	}
		    	
		    	
		    	
		    System.out.println("============================== TASK-3 ===========================");	
		    List<WebElement> data = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/td[3]"));
			int max = 0;
			for(WebElement dElement : data)
			{
				String str = dElement.getText();
			
				String k = str.substring(0,str.length()-1);
				int i = Integer.parseInt(k);
				System.out.println(i);
				if(i>max)
				{
					max= i;
				}
			}
			System.out.println("Max is : "+max);	
		    
	        // Close the browser
	        driver.close();
	}

}
