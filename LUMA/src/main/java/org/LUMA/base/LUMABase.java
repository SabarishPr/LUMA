package org.LUMA.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.utils.ReadExcelIntegration;

public class LUMABase {
	String url ="https://magento.softwaretestingboard.com/";
	protected RemoteWebDriver driver;
	protected WebDriverWait wait;

	@DataProvider (name = "Data")
	public String[][] getdata() throws IOException {
		String[][] getexceldata = ReadExcelIntegration.excel();
		return getexceldata;

	}

	@BeforeMethod
	public void LaunchBrowser() {
		System.getProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
