package com.dn.autoTest;

import com.dn.UI.KeyWords;

//注册用户在动脑网城
public class Class3 {
public static void main(String[] args) {
	KeyWords obj=new KeyWords();
	
	obj.openBrowser("cc");
	obj.openUrl("http://www.hsjcjwh.top/dn_biz/index.php/home/users/regist.html");
	
	obj.inputText("//*[@id=\"loginName\"]","dn0002");
	obj.inputText("//*[@id=\"loginPwd\"]", "123456");
	obj.inputText("//*[@id=\"reUserPwd\"]", "123456");
	obj.inputText("//*[@id=\"verifyCode\"]", "1234");
	
//	obj.clickElement("//*[@id=\"protocol\"]");//报错,改用定位label,方框不能点,总有其他的地方能点,解决了问题就不用考虑别的,实际工作...不能点变点,想办法点,还很简单.
	obj.clickElement("//*[@id=\"reg_form\"]/table/tbody/tr[6]/td/label[1]");//勾选同意
	//思路1,换个元素试试,已经到大框上了.换个大一点的,试试.报错,观察结构,可以点td可能,不是这个button了.试试...成功,可以点但注册不了,只能input...
//	obj.clickElement("//*[@id=\"reg_form\"]/table/tbody/tr[7]/td");/
	//思路2,seleinum怎么递交form表单,百度没找到,到官网看看.搜form...
	obj.formSubmit("//*[@id=\"reg_form\"]");
	
	obj.wait(5);
	obj.closeBrowser();
}
}
