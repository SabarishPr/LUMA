package org.LUMA.test;

import org.LUMA.base.LUMABase;
import org.LUMA.pages.DeleteCart;
import org.LUMA.pages.EquipmentPage;
import org.LUMA.pages.HomePage;
import org.LUMA.pages.LoginPage;
import org.LUMA.pages.MyAccountPage;
import org.LUMA.pages.TeesPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 extends LUMABase{
	
	@Test(dataProvider = "Data", dataProviderClass = LUMABase.class)
	public void test(String data[]) {
		HomePage Home = new HomePage(driver);
		boolean checkLogo = Home.checkLogo();
		System.out.println("Logo availability: "+checkLogo);
		String defaultmsg = Home.defaultmsg();
		System.out.println("Before Login msg: "+defaultmsg);
		Home.signin();
		LoginPage Login = new LoginPage(driver);
		Login.Loginheader();
		Login.enterCred(data[0], data[1]);
		Login.clickLogin();
		MyAccountPage Acct = new MyAccountPage(driver, wait);
		String getusername = Acct.getusername();
		System.out.println("After Login msg: "+getusername);
		Acct.clickTees();
		TeesPage tee = new TeesPage(driver, wait);
		tee.size();
		tee.material();
		tee.colour();
		tee.movetoEqui();
		EquipmentPage equ = new EquipmentPage(driver,wait);
		equ.clickcart();
		equ.shoppinglist();
		DeleteCart del = new DeleteCart(driver,wait);
		del.delete();
		String finalmsg = del.shoppinglistmsg();
		System.out.println(finalmsg);
		del.logout();
		String signoutmsg = del.signout();
		System.out.println(signoutmsg);
	}
}
