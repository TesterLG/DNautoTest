package com.dn.autoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Run {

	public static void main(String[] args) {
		//新建一个Firefox浏览器对象
		
		     
//		System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
//		        WebDriver driver = new FirefoxDriver();
		        
		System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
//		System.setProperty("webdriver.ie.driver","lib/IEDriver.exe");
//		WebDriver driver=new InternetExplorerDriver();
		        driver.get("http://www.baidu.com");
		
		        /*
		       
		        WebElement element = driver.findElement(By.name("su"));

		        // Enter something to search for
		        element.sendKeys("Cheese!");

		        // Now submit the form. WebDriver will find the form for us from the element
		        element.submit();
*/
		        // Check the title of the page
		        System.out.println("Page title is: " + driver.getTitle());
		        
		        
		        /*
		        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
		            public Boolean apply(WebDriver d) {
		                return d.getTitle().toLowerCase().startsWith("cheese!");
		            }
		        });

		        // Should see: "cheese! - Google Search"
		        System.out.println("Page title is: " + driver.getTitle());
		         */
		        
		        //Close the browser
		        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("动脑学院");;
		        driver.findElement(By.xpath("//*[@id=\"su\"]")).click();
		        try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        driver.quit();
		    }

}
