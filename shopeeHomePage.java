package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shopeeHomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='Mua là có quà, Deal -50%']")
	WebElement searchbar;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/header/div[2]/div/div[1]/div[1]/button")
	WebElement searchbt;
	
	public shopeeHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enter_prodName(String productname) {
		searchbar.sendKeys(productname);
		searchbt.click();
	}
}
