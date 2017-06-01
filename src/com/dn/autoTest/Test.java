package com.dn.autoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dn.UI.KeyWords;

public class Test {

	public static void main(String[] args) {
		KeyWords obj = new KeyWords();
		obj.openBrowser("cc");
		
		obj.openUrl("http://www.dongnaoedu.com/");
		obj.wait(3);
		obj.clickElement("/html/body/section/div/div[3]/ul/li[4]/a");
		obj.wait(3);
		obj.closeOldWin();
		
		//关掉小黄条, /html/body/div[3]/div[2]/div/p 第一个div[3]不对,
		obj.clickElement("/html/body/div/div/span/i");
		obj.hoverElement("//*[@id=\"js_btn_bar\"]/span[3]/span[1]");
		obj.clickElement("//*[@id=\"js_btn_bar\"]/span[3]/span[2]");
		obj.wait(1);
		System.out.println(obj.getText("/html/body/div[2]/div[2]/div/p"));
		
		/*//登录
		obj.clickElement("//*[@id=\"js_login\"]");
		obj.wait(2);
		obj.clickElement("/html/body/div[3]/div/div[2]/div[2]/a[1]/i");
		obj.wait(2);
		obj.selectFrame("login_frame_qq");
		obj.clickElement("//*[@id=\"qlogin_list\"]/a[1]");
		
		obj.wait(3);
		obj.clickElement("/html/body/div/div/span/i");
		obj.wait(3);
		//点击个人中心下面的'课程表',不是点立即学习,
		obj.clickElement("//*[@id=\"js_logout_outer\"]/p/a");
		obj.wait(3);
		*/
		/*点击评论并输入,打印评论成功
		obj.clickElement("//*[@id=\"react-body\"]/div/div/div[2]/div[2]/div[2]/div[2]/div/i");
		//*[@id="react-body"]/div/div/div[2]/div[1]
		obj.closeOldWin();
		obj.wait(2);
		obj.inputText("/html/body/section/div/div[1]/form/div[2]/div/div[1]/textarea", "听那首哲理的哥吗? 老师棒棒的!");
		obj.wait(2);
		obj.clickElement("/html/body/section/div/div[1]/form/div[3]/div/span");
		obj.wait(2);
		System.out.println(obj.getText("/html/body/section/div/div[2]/section[1]/div/div/h3"));
		*/
		
		
		obj.closeBrowser();

	}

}
