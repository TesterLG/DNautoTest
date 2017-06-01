package com.dn.UI;

import org.openqa.selenium.WebElement;

public class TestbyWait4Ele {
	public static void main(String[] args) {
		KeyWords obj = new KeyWords();
		
		obj.openBrowser("cc");
		obj.openUrl("http://www.dongnaoedu.com/");
//		obj.clickElement("/html/body/section/div/div[3]/ul/li[4]/a");
//		obj.wait(3);
		//测试
//		obj.openUrl("https://www.baidu.com");
//		obj.wait4Element("//*[@id=\"u1\"]/a[7]",10).click();
//		WebElement e=obj.getDriver().findElement(By.xpath("//*[@id=\"u1\"]/a[7]"));
		//e.click();
//		obj.wait(2);
		obj.closeOldWin();
//		obj.clickElement("//*[@id=\"js_login\"]");
//		obj.wait(5);
//		obj.clickElement("/html/body/div[3]/div/div[2]/div[2]/a[1]");
//		obj.wait(5);
		

		obj.selectFrame("login_frame_qq");
//		obj.clickElement("//*[@id=\"qlogin_list\"]/a[1]");
//		obj.wait(5);
//		obj.clickElement("//*[@id=\"js_btn_bar\"]/span[1]");
//		obj.wait(2);
		obj.clickElement("//*[@id=\"js_btn_bar\"]/span[1]");
//		obj.clickElement("//*[@id=\"react-body\"]/div/div/div[2]/div[2]/div[2]/div[2]/div/span[2]");
		obj.wait(4);
		
		
		
		obj.closeOldWin();
		obj.inputText("/html/body/section/div/div[1]/form/div[2]/div/div[1]/textarea", "perlly 老师棒棒的!");

		System.out.println(obj.getText("/html/body/section/div/div[2]/section[1]/div/div/h3"));
		
		obj.closeBrowser();

	WebElement e=obj.wait4Element("/html/body/section/div/div[3]/ul/li[4]/a",20);
	obj.wait4Element("//*[@id=\"js_login\"]",10).click();
	obj.wait4Element(" /html/body/div[3]/div/div[2]/div[2]/a[1]/i",10).click();
	obj.wait4Element("//*[@id=\"qlogin_list\"]/a[1]",10).click();
//	obj.wait4Element("//*[@id=\"js_btn_bar\"]/span[1]",20).click();
	               
	obj.wait4Element("//*[@id=\"react-body\"]/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]",10).click();
	obj.wait4Element("//*[@id=\"react-body\"]/div/div/div[2]/div[2]/div[2]/div[2]/div/i",10).click();
	obj.wait4Element("/html/body/section/div/div[1]/form/div[3]/div/span",10);
}
}
