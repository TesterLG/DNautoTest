package com.dn.autoTest;

import com.dn.UI.KeyWords;

public class Test3 {

	public static void main(String[] args) {
		KeyWords obj=new KeyWords();
		
		obj.openBrowser("cc");
		obj.openUrl("http://www.hsjcjwh.top/dn_biz/index.php/home/users/login.html");
		obj.wait(1000);
		obj.inputText("//*[@id=\"loginName\"]","perlly");
		obj.inputText("//*[@id=\"loginPwd\"]", "11111111");
		obj.inputText("//*[@id=\"verifyCode\"]", "11");
//		obj.formSubmit("/html/body/div[5]/div/div[2]/form");
		obj.clickElement("/html/body/div[5]/div/div[2]/form/table/tbody/tr[5]/td/div/a");
		obj.wait(1000);//刷新的太快,睡一下.
		obj.clickElement("/html/body/div[1]/div/ul[2]/li[11]/div[1]/a");
		obj.closeOldWin();
		obj.clickElement("/html/body/div[3]/div[3]/div[1]/ul[2]/li[2]");
		//上面的代码是打开添加商品页面
		
		obj.wait(1000);
		obj.inputText("//*[@id=\"goodsName\"]", "Vivo Xplay6");
		obj.inputText("//*[@id=\"marketPrice\"]", "4599.00");
		obj.inputText("//*[@id=\"shopPrice\"]", "4799.00");
		obj.inputText("//*[@id=\"goodsStock\"]", "1000");
		obj.inputText("//*[@id=\"warnStock\"]", "100");
		obj.inputText("//*[@id=\"goodsUnit\"]", "动脑学院lg01");
		obj.inputText("//*[@id=\"goodsSeoKeywords\"]", "test");
		obj.inputText("//*[@id=\"goodsTips\"]", "老高的测试商品.");
		obj.clickElement("//*[@id=\"editform\"]/div[1]/table/tbody/tr[12]/td/div/label[1]");
		obj.selectElement("//*[@id=\"cat_0\"]", "autoTest");
		obj.wait(500);
		obj.selectElement("//*[@id=\"cat_0_588\"]","test3");
		obj.wait(500);
		obj.selectElement("//*[@id=\"cat_0_588_591\"]","test31");
		obj.selectElement("//*[@id=\"shopCatId1\"]","AT");
		obj.wait(500);
		obj.selectElement("//*[@id=\"shopCatId2\"]","test01");
		obj.wait(500);
		obj.selectElement("//*[@id=\"brandId\"]","test");
//		obj.inputText(xpath, txt);
		obj.wait(2000);//脚本纳秒级别,页面是毫秒级别
		
		obj.inputText("//*[@id=\"goodsImgPicker\"]/div[2]/input", "D:/workspace/MyAutoTest/DN_autoTest/lib/xplay6curry.png");
		obj.wait(3000);
		obj.jsOpElement("perlly老师最最帅! vivo Xplay6磨砂黑，曲屏·专业级双摄，极致夜拍，定格精彩瞬间。");
		obj.selectxPathFrame("//*[@id=\"editform\"]/div[1]/table/tbody/tr[16]/td/div/div[2]/iframe");
		obj.clickElement("/html/body");
		obj.wait(1000);
		obj.disSelectiFrame();
		obj.clickElement("//*[@id=\"editform\"]/div[1]/table/tbody/tr[17]/td/button[1]");
		
		//提交,提示商品描述不能为空,[没想到]后面的 textarea标签id=goodsDesc中value是输入的内容,目的是用来提交.
		//1.能不能直接写这个元素的值?,试,报错,元素不能输入. 跑...观察,少了获取焦点和遗失焦点.
//		obj.inputText("//*[@id=\"goodsDesc\"]", "自动化就是坑爹的!");
		//到此为止,只剩下上传图片的坑. 在工作中,处理问题的能力.填坑的能力.
		
		//rt_rt_1bhf34eojhg6p37kl511v11hg1 这种是随机的,
//		obj.inputText("//*[@id=\"rt_rt_1bhf34eojhg6p37kl511v11hg1\"]/label", "/source/cat1.jpg");
		
		//上传图片
//		obj.inputText("//*[@id=\"goodsImgPicker\"]/div[2]/input", "‪C:\\Users\\GQ\\Pictures\\icon\\xplay6curry.png");
		obj.wait(5000);
		obj.closeBrowser();
		
	}
}
