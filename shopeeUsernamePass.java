package PageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shopeeUsernamePass {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(name="loginKey")
	private WebElement user;
	
	@FindBy(name="password")
	private WebElement pass;

	@FindBy(xpath="//button[contains(@class,'wyhvVD _1EApiB hq6WM5 L-VL8Q cepDQ1 _7w24N1')]")
	WebElement login;
	
	public shopeeUsernamePass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enter_username_pass(String username, String password) {
		user.sendKeys(username);
		pass.sendKeys(password);
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(login)).click();
	}
}
