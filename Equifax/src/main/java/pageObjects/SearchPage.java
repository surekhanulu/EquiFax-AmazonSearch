package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	private WebDriver drv;
	By search = By.cssSelector("input[id=twotabsearchtextbox]");
	By search_button = By.cssSelector("input[type=submit]");
	By matching_results = By.xpath("//div[contains(@class,'sg-col-4-of-12')]");
	By price = By.className("a-price");

	public SearchPage(WebDriver driver) {
		this.drv = driver;
	}

	public WebElement getSearch() {
		return this.drv.findElement(search);
	}

	public WebElement getSearchButton() {
		return this.drv.findElement(search_button);

	}

	public List<WebElement> getSearchResults() {
		return this.drv.findElements(matching_results);

	}

	public WebElement getPrice(WebElement element) {
		return element.findElement(price);

	}
}
