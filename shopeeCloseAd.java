package PageFactory;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shopeeCloseAd {
	
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "//*[@id=\"main\"]/div/header/div[1]/nav/ul/a[3]")
	WebElement lgbutton;
	public shopeeCloseAd(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void dongquangcao() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		WebElement closeBtn = (WebElement) ((JavascriptExecutor) driver).executeScript(
                "return document.querySelector(\"#main shopee-banner-popup-stateful\").shadowRoot.querySelector(\"div.home-popup__close-area div.shopee-popup__close-btn\")");
		wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
		lgbutton.click();
	}
}
