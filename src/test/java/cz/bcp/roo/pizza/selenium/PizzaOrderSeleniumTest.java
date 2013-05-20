package cz.bcp.roo.pizza.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PizzaOrderSeleniumTest {

	WebDriver driver;

	@Test
	public void createTest() throws Exception {

		driver = new FirefoxDriver();

		// open http://localhost:8080/pizza_roo/pizzaorders?form&lang=cs_CZ
		driver.navigate().to("http://localhost:8080/pizza_roo/pizzaorders?form&lang=cs_CZ");

		// type _name_id someName1
		WebElement nameTextBox = driver.findElement(By.id("_name_id"));
		String pizzaOrderName = "TestPizzaOrder";
		nameTextBox.sendKeys(pizzaOrderName);

		// type _address_id someAddress1
		WebElement addressTextBox = driver.findElement(By.id("_address_id"));
		String pizzaOrderAddress = "someAddress";
		addressTextBox.sendKeys(pizzaOrderAddress);

		// type _total_id 1.0
		WebElement totalTextBox = driver.findElement(By.id("_total_id"));
		String pizzaOrderTotal = "1.0";
		totalTextBox.sendKeys(pizzaOrderTotal);

		// type _deliveryDate_id 15.4.2013
		WebElement deliveryDateTextBox = driver.findElement(By.id("_deliveryDate_id"));
		String pizzaOrderDeliveryDate = "15.4.2013";
		deliveryDateTextBox.sendKeys(pizzaOrderDeliveryDate);
		
		// input[@id = 'proceed']
		driver.findElement(By.id("proceed")).click();

		long end = System.currentTimeMillis() + 5000;
		while (System.currentTimeMillis() < end) {
			// verifyText _s_cz_bcp_roo_pizza_domain_PizzaOrder_name_name_id someName1
			WebElement nameResultsDiv = driver.findElement(By.id("_s_cz_bcp_roo_pizza_domain_PizzaOrder_name_name_id"));
			if (nameResultsDiv.isDisplayed()) {
				String text = nameResultsDiv.getText();
				Assert.assertEquals(pizzaOrderName, text);

			}
			// verifyText _s_cz_bcp_roo_pizza_domain_PizzaOrder_address_address_id someAddress1
			WebElement addressResultsDiv = driver.findElement(By.id("_s_cz_bcp_roo_pizza_domain_PizzaOrder_address_address_id"));
			if (addressResultsDiv.isDisplayed()) {
				String text = addressResultsDiv.getText();
				Assert.assertEquals(pizzaOrderAddress, text);

			}
			// verifyText _s_cz_bcp_roo_pizza_domain_PizzaOrder_total_total_id 1.0
			WebElement totalResultsDiv = driver.findElement(By.id("_s_cz_bcp_roo_pizza_domain_PizzaOrder_total_total_id"));
			if (totalResultsDiv.isDisplayed()) {
				String text = totalResultsDiv.getText();
				Assert.assertEquals(pizzaOrderTotal, text);

			}
			// verifyText _s_cz_bcp_roo_pizza_domain_PizzaOrder_deliveryDate_deliveryDate_id 15.4.2013
			WebElement deliveryDateResultsDiv = driver.findElement(By.id("_s_cz_bcp_roo_pizza_domain_PizzaOrder_deliveryDate_deliveryDate_id"));
			if (deliveryDateResultsDiv.isDisplayed()) {
				String text = deliveryDateResultsDiv.getText();
				Assert.assertEquals(pizzaOrderDeliveryDate, text);
				break;
			}
		}

		driver.quit();
	}
}
