package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	private WebDriver drv;
	By price = By.xpath("//span[@class='a-color-price hlb-price a-inline-block a-text-bold']");
	By proceed_to_button = By.id("hlb-ptc-btn-native");

	public CheckoutPage(WebDriver driver) {
		this.drv = driver;
	}

	public WebElement getPrice() {
		return this.drv.findElement(price);
	}

	public WebElement getProceedToButton() {
		return this.drv.findElement(proceed_to_button);
	}
}
