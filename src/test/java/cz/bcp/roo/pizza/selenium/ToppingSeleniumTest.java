package cz.bcp.roo.pizza.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToppingSeleniumTest {

	WebDriver driver;

	@Test
	public void createTest() throws Exception {

		driver = new FirefoxDriver();

		// open http://localhost:8080/pizza_roo/toppings?form&lang=cs_CZ
		driver.navigate().to("http://localhost:8080/pizza_roo/toppings?form&lang=cs_CZ");

		// type _name_id someName1
		WebElement textBox = driver.findElement(By.id("_name_id"));
		String toppingName = "TestTopping";
		textBox.sendKeys(toppingName);

		// clickAndWait //input[@id = 'proceed']
		driver.findElement(By.id("proceed")).click();

		// verifyText _s_cz_bcp_roo_pizza_domain_Topping_name_name_id someName1
		long end = System.currentTimeMillis() + 5000;
		while (System.currentTimeMillis() < end) {
			WebElement resultsDiv = driver.findElement(By.id("_s_cz_bcp_roo_pizza_domain_Topping_name_name_id"));
			if (resultsDiv.isDisplayed()) {
				String text = resultsDiv.getText();
				Assert.assertEquals(toppingName, text);
				break;
			}
		}

		driver.quit();
	}
}
