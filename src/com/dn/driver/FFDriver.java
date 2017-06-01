package com.dn.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FFDriver {

	public static void main(String[] args) {

		//配置设置
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
		//建立浏览器对象
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com");

		System.out.println("Page title is: " + driver.getTitle());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}