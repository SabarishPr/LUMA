package org.LUMA.pages;

import org.LUMA.base.LUMABase;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends LUMABase{
	public MyAccountPage(RemoteWebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public String getusername() {
		String text;
		WebElement log = driver.findElementByXPath("//header//span[@class='not-logged-in']");
		wait.until(ExpectedConditions.invisibilityOf(log));
		WebElement usname = driver.findElementByCssSelector("div[class='panel header'] span[class='logged-in']");
		try {
			wait.until(ExpectedConditions.visibilityOf(usname));
			text = usname.getText();
		} catch (StaleElementReferenceException e) {
			usname = driver.findElementByCssSelector("div[class='panel header'] span[class='logged-in']");
			wait.until(ExpectedConditions.visibilityOf(usname));
			text = usname.getText();
		}
		return text;
	}

	public void clickTees() {
		WebElement mens = driver.findElementById("ui-id-5");
		WebElement tops = driver.findElementById("ui-id-17");
		WebElement tees = driver.findElementById("ui-id-21");
		wait.until(ExpectedConditions.elementToBeClickable(mens));
		Actions builder = new Actions(driver);
		builder.moveToElement(mens).perform();
		builder.moveToElement(tops).perform();
		builder.moveToElement(tees).perform();
		tees.click();
	}

}
