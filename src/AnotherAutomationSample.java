import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class AnotherAutomationSample {
	
	private static WebDriver driver;
	
	public AnotherAutomationSample(WebDriver driver) {
		this.driver = driver;
	}

	public static void main(String[] args) {
		
		AnotherAutomationSample really = new AnotherAutomationSample(new ChromeDriver());
		
		really.loginAs("ppondicherry", "password");
		driver.findElement(By.cssSelector("a[href*='pelagos-symfony/dev/ppondicherry/dif'")).click();
		
//		driver.get("https://proteus.tamucc.edu/pelagos-symfony/dev/ppondicherry/data-discovery");
//		
//		// System.out.println("title of page is: " + driver.getTitle());
//		// driver.manage().window().maximize();
//		try {
//			TimeUnit.SECONDS.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		driver.findElement(By.id("filter-input")).sendKeys("R1.x137.000:0024");
//		driver.findElement(By.id("filter-button")).click();
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		// By waitFor = By.className("ui-tabs-anchor");
//		WebElement searchResults = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-tabs-anchor")));
//		System.out.println(searchResults.getText());
//		driver.quit();

	}
	
	public void loginAs(String username, String password) {
		driver.get("https://proteus.tamucc.edu/pelagos/modules/auth/cas?dest=pelagos-symfony/dev/ppondicherry/%3Fq%3Dpelagos-symfony%252Fdev%252Fppondicherry");
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("btn-submit")).submit();
	}
}
