package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	protected WebDriver driver;
	protected Properties prop;

	public void initializeDriver() throws IOException {
		prop = new Properties();
		String fileName = "src\\main\\java\\resources\\data.properties";
	    FileInputStream inputStream = new FileInputStream(fileName);
		prop.load(inputStream);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome_drv_path"));
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {
			// Need to write firefox specfic driver code.
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
