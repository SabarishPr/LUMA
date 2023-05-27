package org.LUMA.pages;

import org.LUMA.base.LUMABase;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class LoginPage extends LUMABase{

	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public void Loginheader() {
		String expectedtitle ="Customer Login";
		String actualtitle = driver.findElementByXPath("//span[text()=\"Customer Login\"]").getText();
		Assert.assertEquals(actualtitle, expectedtitle);
	}
	
	public void enterCred(String usname, String pswd) {
		driver.findElementById("email").sendKeys(usname);
		driver.findElementByCssSelector("#pass").sendKeys(pswd);
	}
	
	public void clickLogin() {
		driver.findElementByXPath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]").click();
	}
	
	
}
