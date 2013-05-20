package cz.bcp.roo.pizza.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSeleniumTest {

	WebDriver driver;

	@Test
	public void createTest() throws Exception {

		driver = new FirefoxDriver();

		// open http://localhost:8080/pizza_roo/bases?form&lang=cs_CZ
		driver.navigate().to("http://localhost:8080/pizza_roo/bases?form&lang=cs_CZ");

		// type _name_id someName1
		WebElement textBox = driver.findElement(By.id("_name_id"));
		String baseName = "TestBase2";
		textBox.sendKeys(baseName);

		// clickAndWait //input[@id = 'proceed']
		driver.findElement(By.id("proceed")).click();

		// verifyText _s_cz_bcp_roo_pizza_domain_Base_name_name_id someName1
		long end = System.currentTimeMillis() + 5000;
		while (System.currentTimeMillis() < end) {
			WebElement resultsDiv = driver.findElement(By.id("_s_cz_bcp_roo_pizza_domain_Base_name_name_id"));
			if (resultsDiv.isDisplayed()) {
				String text = resultsDiv.getText();
				Assert.assertEquals(baseName, text);
				break;
			}
		}

		driver.quit();
	}
}
