package com.dn.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriver {
	public static void main(String[] args) {

		// 配置设置
		System.setProperty("webdriver.ie.driver", "lib/IEDriver.exe");
		// 建立浏览器对象
	
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		// IE默认启动保护模式，要么手动在浏览器的设置中关闭保护模式，要么在代码中加上这一句，即可
		dc.setCapability("ignoreProtectedModeSettings", true);
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://www.baidu.com");
		// 要求ie设置中安全设置4个选项完全一致.才能刷出.
		System.out.println("Page title is: " + driver.getTitle());
 
		driver.findElement(By.id("//*[@id=\"kw\"]")).sendKeys("sss");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
