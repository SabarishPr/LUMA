package org.LUMA.pages;

import java.util.List;

import org.LUMA.base.LUMABase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DeleteCart extends LUMABase{
	public DeleteCart(RemoteWebDriver driver, WebDriverWait wait) {
		this.driver=driver;
		this.wait =wait;
	}
	public void delete() {
		List<WebElement> list = driver.findElementsByXPath("//ol[@id='mini-cart']//li");
		for (WebElement Element : list) {
			try {
				Element.findElement(By.xpath("//a[@title='Remove item']")).click();
			} catch (StaleElementReferenceException e) {
				driver.findElementByXPath("//a[@title='Remove item']").click();
			}
			driver.getWindowHandle();
			WebElement ok = driver.findElementByCssSelector(".action-primary.action-accept");
			wait.until(ExpectedConditions.elementToBeClickable(ok));
			ok.click();
			wait.until(ExpectedConditions.invisibilityOf(Element));
		}
	}
	public String shoppinglistmsg() {
		WebElement message = driver.findElementByXPath("//strong[@class='subtitle empty']");
		wait.until(ExpectedConditions.visibilityOf(message));
		String msg = message.getText();
		driver.findElementById("btn-minicart-close").click();
		return msg;
	}
	
	public void logout() {
		driver.findElementByCssSelector("div[class='panel header'] button[type='button']").click();
		driver.findElementByXPath("(//a[normalize-space()='Sign Out'])[1]").click();
	}
	
	public String signout() {
		String expectedmsg ="You are signed out";
		WebElement msg = driver.findElementByXPath("//span[@data-ui-id='page-title-wrapper']");
		String actualmsg = msg.getText();
		Assert.assertEquals(actualmsg, expectedmsg);
		return actualmsg;
	}
}
