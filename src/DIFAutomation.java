import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DIFAutomation {
	
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
		
		WebDriverWait waitForDif = new WebDriverWait(driver, 2);
		
		waitForDif.until(ExpectedConditions.visibilityOfElementLocated(By.id("researchGroup")));
		
		selectOptions("researchGroup", driver);
		
		driver.findElement(By.id("title")).sendKeys("This is a sample dataset to test the DIF using Selenium");
		
		waitTimer(5);
		selectOptions("primaryPointOfContact", driver);
		
		waitTimer(3);
		selectOptions("secondaryPointOfContact", driver);
		
		driver.findElement(By.id("abstract")).sendKeys("This is an abstract for the dataset to test the DIF using Selenium");
		
		
		// Using Javascript Executor to click submit button because it is executed by Javascript in the code
		WebElement element = driver.findElement(By.id("btnSubmit"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		waitTimer(10);
//		String parentWindowHandler = driver.getWindowHandle();
//		String subWindowHandler = null;
//		
//		Set<String> handles = driver.getWindowHandles();
//		Iterator<String> iterator = handles.iterator();
//		
//		while (iterator.hasNext()) {
//			subWindowHandler = iterator.next();
//		}
//		
//		driver.switchTo().window(subWindowHandler);
		
		driver.quit();

	}
	
	public static void selectOptions(String id, WebDriver driver) {
		
		Select dropDown = new Select(driver.findElement(By.id(id)));
		List <WebElement> dropDownList = dropDown.getOptions();
		int listCnt1 = dropDownList.size();
		
		//Using Random class to generate random values
		 Random num = new Random();
		 int iSelect = num.nextInt(listCnt1);
		 
		 dropDown.selectByIndex(iSelect);
	}
	
	public static void waitTimer(int timer) {
		try {
			TimeUnit.SECONDS.sleep(timer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
