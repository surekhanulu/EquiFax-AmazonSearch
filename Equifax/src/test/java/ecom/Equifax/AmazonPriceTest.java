package ecom.Equifax;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.CheckoutPage;
import pageObjects.SearchPage;
import resources.Base;

@Test
public class AmazonPriceTest extends Base {
	private String expected_price;

	@BeforeTest
	public void initialize() throws IOException {
		initializeDriver();
	}

	@Test(priority = 1)
	public void basePageNavigation() throws IOException {
		// creating object to the class and invoke methods of it
		SearchPage lp = new SearchPage(driver);
		lp.getSearch().sendKeys(prop.getProperty("search_str"));
		lp.getSearchButton().click();
		List<WebElement> list = lp.getSearchResults();
		WebElement firstElement = list.get(0);
		String[] price_split = lp.getPrice(firstElement).getText().split("\n");
		expected_price = price_split[0] + "." + price_split[1];
		firstElement.click();
	}

	@Test(priority = 2)
	public void addToCart() throws InterruptedException {
		AddToCartPage ac = new AddToCartPage(driver);
		String cart_price = ac.getCartPrice().getText();
		Assert.assertEquals(cart_price, expected_price);
		ac.getCartButton().click();

	}

	@Test(priority = 3)
	public void proceedToCheckout() throws InterruptedException {
		CheckoutPage cp = new CheckoutPage(driver);
		String checkout_price = cp.getPrice().getText();
		Assert.assertEquals(checkout_price, expected_price);
		cp.getProceedToButton().click();
	}

	// For actual checkout, we need to sign-in with credentials.
	// We can come up with similar method as above and can do required tests

	@AfterTest
	public void teardown() {

		driver.close();

	}
}
