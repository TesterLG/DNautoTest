package com.dn.UI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyWords {
	private WebDriver driver=null;
	private String path="lib/";

	public WebDriver getDriver(){
		return this.driver;
	}
	
	//打开浏览器
	public void openBrowser(String type){
		if(type.equals("cc")||type.trim().toLowerCase().equals("chrome")){
			System.setProperty("webdriver.chrome.driver", path+"chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			
			option.addArguments("--disable-infobars");
			driver = new ChromeDriver(option);			
		}
		if(type.equals("ff")||type.trim().toLowerCase().equals("firefox")){
			System.setProperty("webdriver.chrome.driver", "lib/geckodriver64.exe");
			driver = new FirefoxDriver();	
		}
		if(type.equals("ie")||type.trim().toLowerCase().equals("internetexplorer")){
			// 配置设置
			System.setProperty("webdriver.ie.driver", "lib/IEDriver.exe");
			// 建立浏览器对象
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			// IE默认启动保护模式，要么手动在浏览器的设置中关闭保护模式，要么在代码中加上这一句，即可
			dc.setCapability("ignoreProtectedModeSettings", true);
			driver = new InternetExplorerDriver();			
		}
		
		if(driver==null){
			System.out.println("log:err:浏览器未打开!");
		}else{
			System.out.println("log:info:浏览器打开成功!");
		}
	}

	public void closeBrowser(){
		if(driver==null){
			System.out.println("浏览器未打开!");
		}else{
			driver.quit();
		}
	}

	public void openUrl(String url){
		try {
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickElement(String xpath){
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void wait(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//智能等待
	public WebElement wait4Element(String xpath,int time){
		By by=By.xpath(xpath);
		WebElement element = null;
	try {
		element =new WebDriverWait(driver,time).until(new ExpectedCondition<WebElement>() {

			@Override
			public WebElement apply(WebDriver dr) {
				return dr.findElement(by);
			}
		});
		System.out.println("找到元素.");
	} catch (Exception e) {
		System.out.println("等待"+time+"s后元素未出现.");
		e.printStackTrace();
	}
	return element;
	}
	
	//保留旧的win测试难度几何式增加,最好只保留2个窗口.
	public void closeNewWin(){
		List<String> handles =new ArrayList<String>();
		Set<String> s= driver.getWindowHandles();
		//循环句柄保存在list数组handles中.
		for (Iterator<String> it=s.iterator();it.hasNext();) {
			handles.add(it.next().toString());
		}
		//选定新页面
		driver.switchTo().window(handles.get(1));
		//关闭页面
		driver.close();
		//选定旧窗口
		driver.switchTo().window(handles.get(0));
	}
	
	public void closeOldWin(){
		List<String> handles =new ArrayList<String>();
		Set<String> s= driver.getWindowHandles();
		//循环句柄保存在list数组handles中.
		for (Iterator<String> it=s.iterator();it.hasNext();) {
			handles.add(it.next().toString());
		}
		//关闭旧页面
		driver.close();
		//选定新窗口
		driver.switchTo().window(handles.get(1));
	}

	//选定iframe
	public void selectFrame(String name) {
		try {
			driver.switchTo().frame(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inputText(String xpath,String txt){
		try {
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(txt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getText(String xpath) {
		try {
			return driver.findElement(By.xpath(xpath)).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "null";
	}

	//在form上copy xpath
	public void formSubmit(String xpath) {
		//加try-catch保证报错后,后面的仍然可以执行.
		try {
			driver.findElement(By.xpath(xpath)).submit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void jsOpElement(String input){
		try {
			String jsstring = "document.getElementsByTagName(\"iframe\")[0].contentWindow.document.getElementsByClassName"
					+ "(\"ke-content\")[0].innerHTML=\""+input+"\"";
			((JavascriptExecutor)driver).executeScript(jsstring);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//通过xpath选定iframe
	public void selectxPathFrame(String xpath){
		try {
			driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
	public void disSelectiFrame(){
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param xpath
	 * @param value
	 */
	public void selectElement(String xpath,String value){
		try {
			Select select=new Select(driver.findElement(By.xpath(xpath)));
			select.selectByVisibleText(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		select.selectByIndex(1);
	}
	
	public void hoverElement(String xpath){
		Actions action=new Actions(driver);
		WebElement nav=driver.findElement(By.xpath(xpath));
		action.moveToElement(nav).build().perform();
		
	}
}
