import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataDiscoveryAutomation {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		Properties prop = new Properties();
		
		ConfigProperties configProp = new ConfigProperties();
		
		configProp.getProperties(prop);
		
		String dataDiscoveryUrl = "pelagos-symfony/dev/ppondicherry/data-discovery";

		driver.get(prop.getProperty("env") + dataDiscoveryUrl);
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.id("filter-input")).sendKeys("R1.x137.000:0024");
		driver.findElement(By.id("filter-button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement searchResults = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-tabs-anchor")));
		System.out.println(searchResults.getText());
		
		driver.quit();
	}

}
