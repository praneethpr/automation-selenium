import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnotherAutomationSample {
	
	public static void main(String[] args) {
		
		// Get configuration properties
		Properties prop = new Properties();
		ConfigProperties configProp = new ConfigProperties();
		configProp.getProperties(prop);
		
		// Get user credentials from properties
		String[] userCredentials = new String[3];
		userCredentials[0] = prop.getProperty("username");
		userCredentials[1] = prop.getProperty("password");
		userCredentials[2] = prop.getProperty("env");
		
		//Initialize web driver
		WebDriver driver = new ChromeDriver();
		
		//Login
		Login login = new Login();
		login.loginAs(userCredentials, driver);
		
		//Goto DIF form
		driver.findElement(By.cssSelector("a[href*='pelagos-symfony/dev/ppondicherry/dif'")).click();
		
		driver.quit();

	}
}
