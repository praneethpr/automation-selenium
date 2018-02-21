import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	public void loginAs(String[] userCredentials, WebDriver driver) {
		
		String loginUrl = "CAS/login?service=https://proteus.tamucc.edu/cas?destination=pelagos-symfony/dev/ppondicherry";
		
		//Login with credentials 
		driver.get(userCredentials[2] + loginUrl);
		
		//enter user name and password in the fields
		driver.findElement(By.id("username")).sendKeys(userCredentials[0]);
		driver.findElement(By.id("password")).sendKeys(userCredentials[1]);
		
		//submit the form
		driver.findElement(By.className("btn-submit")).submit();
	}
}
