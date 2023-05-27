package org.LUMA.pages;

import org.LUMA.base.LUMABase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EquipmentPage extends LUMABase {
	public EquipmentPage(RemoteWebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	
	public void clickcart() {
		WebElement grips = driver.findElementByXPath("//img[@alt=\"Go-Get'r Pushup Grips\"]");
		Actions builder = new Actions(driver);
		builder.moveToElement(grips).perform();
		WebElement addcart = driver.findElementByXPath("(//span[contains(text(),'Add to Cart')])[7]");
		wait.until(ExpectedConditions.visibilityOf(addcart));
		addcart.click();
		WebElement success = driver.findElementByXPath("//div[@class='message-success success message']");
		wait.until(ExpectedConditions.visibilityOf(success));
	}
	
	public void shoppinglist() {
		WebElement quantity = driver.findElementByXPath("//span[@class=\"counter qty\"]//span[@class='counter-number']");
		wait.until(ExpectedConditions.visibilityOf(quantity));
		driver.findElementByXPath("//a[@class='action showcart']").click();
	}
	
	
	
	
}
