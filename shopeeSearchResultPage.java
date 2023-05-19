package PageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shopeeSearchResultPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/a/div/div")
	WebElement firstitem;
	
	public shopeeSearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void pick_first_item() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(firstitem)).click();
	}
}
