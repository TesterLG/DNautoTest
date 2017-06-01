package com.dn.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sun.glass.ui.View.Capability;


public class ChromeDriverTest {
public static void main(String[] args) {
	
	
	//配置设置
	System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
	DesiredCapabilities capabilites=new DesiredCapabilities();
	ChromeOptions option=new ChromeOptions();
	//<span style="color:#ff0000;">去除Chrome浏览器上的黄色警告</span>
	
//	document.write("<p><span style=\"color: #ff0000\">abc</span></p>");
	option.addArguments("--disable-infobars");
//	option.addArguments("-test-type");
	//最大化浏览器
//	option.addArguments("-start-maximized");
	//关掉地域警告
	option.addArguments("--whitelisted-ips=\"\"");
//	option.addArguments("--whitelisted-ips=comma-separated-ips");
	
	capabilites.setCapability(ChromeOptions.CAPABILITY, option);
	capabilites.setCapability(CapabilityType.BROWSER_NAME, "chrome");
	capabilites.setCapability(CapabilityType.VERSION, "");
	capabilites.setCapability(CapabilityType.PLATFORM,"windows");
	//建立浏览器对象
	
//	WebDriver driver = new ChromeDriver(option);
	WebDriver driver = new ChromeDriver(capabilites);
	driver.get("http://www.baidu.com");

	System.out.println("Page title is: " + driver.getTitle());
    System.out.println("log:info:浏览器打开成功!");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	driver.quit();
}

}
