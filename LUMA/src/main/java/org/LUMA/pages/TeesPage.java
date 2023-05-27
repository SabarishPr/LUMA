package org.LUMA.pages;

import java.util.List;

import org.LUMA.base.LUMABase;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeesPage extends LUMABase {
	public TeesPage(RemoteWebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait =wait;
	}
	public void size() {
		driver.findElementByXPath("//div[normalize-space()='Size']").click();
		driver.findElementByXPath("//a[@aria-label='L']//div[contains(@class,'swatch-option text')][normalize-space()='L']").click();
		List<WebElement> allimages = driver.findElementsByXPath("//img[@class='product-image-photo']");
		wait.until(ExpectedConditions.visibilityOfAllElements(allimages));
	}
	public void material() {
		driver.findElementByXPath("//div[text()='Material']").click();
		driver.findElementByXPath("//div[@class='filter-options-item allow active']//ol//li[2]//a").click();		
	}

	public void colour() {
		driver.findElementById("option-label-color-93-item-52").click();
		WebElement img = driver.findElementByXPath("//img[@src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/m/s/ms02-gray_main_1.jpg']");
		wait.until(ExpectedConditions.visibilityOf(img));
		driver.findElementByXPath("(//span[contains(text(),'Add to Cart')])[2]").click();
		WebElement success = driver.findElementByXPath("//div[@class='message-success success message']");
		wait.until(ExpectedConditions.visibilityOf(success));
	}
	
	public void movetoEqui() {
		WebElement gear = driver.findElementByXPath("//span[text()='Gear']");
		WebElement equipments = driver.findElementById("ui-id-26");
		Actions builder = new Actions(driver);
		builder.moveToElement(gear).perform();
		builder.moveToElement(equipments).perform();
		equipments.click();
	}

	

}
