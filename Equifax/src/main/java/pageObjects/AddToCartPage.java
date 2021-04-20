package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {
	private WebDriver drv;
	By price = By.id("newBuyBoxPrice");
	By cart_button = By.id("add-to-cart-button");

	public AddToCartPage(WebDriver driver) {
		this.drv = driver;
	}

	public WebElement getCartPrice() {
		return this.drv.findElement(price);
	}

	public WebElement getCartButton() {
		return this.drv.findElement(cart_button);
	}
}
