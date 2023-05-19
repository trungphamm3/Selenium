package PageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shopeeTypeSize {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[2]/div[2]/div[3]/div/div[4]/div/div[4]/div/div[1]/div/button[1]")
	WebElement color;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[2]/div[2]/div[3]/div/div[4]/div/div[4]/div/div[2]/div/button[2]")
	WebElement size;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[2]/div[2]/div[3]/div/div[5]/div/div/button[1]")
	WebElement addcart;
	
	@FindBy(xpath = "//div[@class='shopee-cart-number-badge']")
	WebElement cartbt;
	
	public shopeeTypeSize(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void pickcolorsize() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(color)).click();
		size.click();
		//addcart.click();
	}
	public boolean addtocart() {
		int cartCountBefore = Integer.parseInt(cartbt.getText().replaceAll("[^0-9]+", ""));
		addcart.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.textToBePresentInElement(cartbt,String.valueOf(cartCountBefore+1)));
		
		int cartCountAfter = Integer.parseInt(cartbt.getText().replaceAll("[^0-9]+", ""));
		if(cartCountBefore<cartCountAfter) {
			return true;
		}
		else{
			return false;
		}
	}
	
	
}
