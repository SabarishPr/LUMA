package org.LUMA.pages;

import org.LUMA.base.LUMABase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage extends LUMABase  {

	public HomePage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	public boolean checkLogo() {
		WebElement logo = driver.findElementByXPath("//a[@aria-label='store logo']//img");
		boolean result = logo.isDisplayed();
		return result;
	}

	public String defaultmsg() {
		String msg = driver.findElementByXPath("//div[@class='panel header']//span[@class='not-logged-in'][normalize-space()='Default welcome msg!']").getText();
		return msg;
	}

	public void signin() {
		driver.findElementByXPath("//div[@class='panel header']//a[contains(text(),'Sign In')]").click();
	}





}
