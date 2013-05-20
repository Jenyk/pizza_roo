package cz.bcp.roo.pizza.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PizzaSeleniumTest {
	
	WebDriver driver;

	@Test
	public void createTest() throws Exception {

		driver = new FirefoxDriver();

		// open http://localhost:8080/pizza_roo/bases?form&lang=cs_CZ
		driver.navigate().to("http://localhost:8080/pizza_roo/pizzas?form&lang=cs_CZ");

		// type _name_id someName1
		WebElement textBox = driver.findElement(By.id("_name_id"));
		String pizzaName = "TestPizza";
		textBox.sendKeys(pizzaName);
		
		// type _price_id 1.0
		textBox = driver.findElement(By.id("_price_id"));
		String pizzaPrice = "1.0";
		textBox.sendKeys(pizzaPrice);
		
		// input[@id = 'proceed']
		driver.findElement(By.id("proceed")).click();
	    
		long end = System.currentTimeMillis() + 5000;
		while (System.currentTimeMillis() < end) {
			// verifyText _s_cz_bcp_roo_pizza_domain_Pizza_name_name_id TestPizza
			WebElement resultsDivName = driver.findElement(By.id("_s_cz_bcp_roo_pizza_domain_Pizza_name_name_id"));			
			if (resultsDivName.isDisplayed()) {
				String text = resultsDivName.getText();
				Assert.assertEquals(pizzaName, text);				
			}
			// verifyText _s_cz_bcp_roo_pizza_domain_Pizza_price_price_id 1.0
			WebElement resultsDivPrice = driver.findElement(By.id("_s_cz_bcp_roo_pizza_domain_Pizza_price_price_id"));
			if (resultsDivPrice.isDisplayed()) {
				String text = resultsDivPrice.getText();
				Assert.assertEquals(pizzaPrice, text);	
				break;
			}
		}
		
		driver.quit();
	}
}
