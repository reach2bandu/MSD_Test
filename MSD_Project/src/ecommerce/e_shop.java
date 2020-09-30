package ecommerce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

// Due to Constraints I could not able to do with proper Frameworks. If I have been given the few days of time I would able to achieve the
//programme with proper frameworks

public class e_shop {

	private WebDriver driver = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Test(priority = 0)
	public void browserlaunch() {

		
		System.setProperty("webdriver.gecko.driver",
		"C:\\Users\\Shashi Bandu\\Eclipse-projects\\MDS\\Webdrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demostore.x-cart.com");

		String pageTitle = driver.getTitle();
		String pageTitleExpected = "X-Cart Demo store company > Catalog";

		Assert.assertEquals(pageTitle, pageTitleExpected);

	}

	@Test(priority = 1)
	public void NewArrivals() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'New!')]"))
				.click();
		Thread.sleep(5000);

		WebElement ele = driver.findElement(By.xpath("//span[@class='sort-by-value']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Price High - Low')]")).click();

		Thread.sleep(5000);

		WebElement Element = driver.findElement(By.xpath(
				"//div[contains(@class,'content')]//h4[contains(@class,'cloud-filters-filter__title')][contains(text(),'Manufacturer')]"));
		// js.executeScript("window.scrollBy(0,500)");
		js.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(By.xpath(
				"//button[contains(@class,'regular-button add-to-cart product-add2cart productid-31')]//span[contains(text(),'Add to cart')]"))
				.click();
		driver.findElement(By.xpath("//button[contains(@class,'ui-dialog-titlebar-close')]")).click();
		driver.findElement(By.xpath(
				"//button[contains(@class,'regular-button add-to-cart product-add2cart productid-32')]//span[contains(text(),'Add to cart')]"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='8a1fda3a8a8eb2bcc7d7752a04d08512']//span[contains(text(),'View cart')]")).click();

		driver.quit();
	}

}
