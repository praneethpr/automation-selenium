import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnotherAutomationSample {
	
	private static WebDriver driver;
	
	public AnotherAutomationSample(WebDriver driver) {
		this.driver = driver;
	}

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		ConfigProperties configProp = new ConfigProperties();
		
		configProp.getProperties(prop);
		
		
		AnotherAutomationSample sampleUsage = new AnotherAutomationSample(new ChromeDriver());
		
		//Login
		sampleUsage.loginAs(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("env"));
		
		//Goto DIF form
		driver.findElement(By.cssSelector("a[href*='pelagos-symfony/dev/ppondicherry/dif'")).click();
		
		driver.quit();

	}
	
	public void loginAs(String username, String password, String env) {
		
		String loginUrl = "CAS/login?service=https://proteus.tamucc.edu/cas?destination=pelagos-symfony/dev/ppondicherry";
		
		//Login with credentials 
		driver.get(env + loginUrl);
		
		//enter user name and password in the fields
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		//submit the form
		driver.findElement(By.className("btn-submit")).submit();
	}
}
