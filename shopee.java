package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageFactory.shopeeCloseAd;
import PageFactory.shopeeHomePage;
import PageFactory.shopeeSearchResultPage;
import PageFactory.shopeeTypeSize;
import PageFactory.shopeeUsernamePass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class shopee {
	WebDriver driver;
	shopeeCloseAd se;
	shopeeUsernamePass up;
	shopeeHomePage hp;
	shopeeSearchResultPage rp;
	shopeeTypeSize ts;
	
	@Before
	public void open_browser() {
		System.getProperty("webdriver.gecko.driver","C:/Users/Gin/eclipse-workspace/CucumberJava/src/test/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://shopee.vn/");
	}
	
	@Given("tat pop-up quang cao")
	public void tat_pop_up_quang_cao() {
		se = new shopeeCloseAd(driver);
		se.dongquangcao();
	}

	@When("^user nhap (.*) va (.*)$")
	public void user_nhap_username_password(String username, String password) {
	    up = new shopeeUsernamePass(driver);
	    up.enter_username_pass(username, password);
	}

	@Then("user navigated to homepage")
	public void user_navigated_to_homepage() {
        String expectedUrl = "https://shopee.vn/buyer/login?next=https%3A%2F%2Fshopee.vn%2F";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
	}
	@When("^user fill (.*) and click search$")
	public void user_enter_item_name(String productname) {
		hp = new shopeeHomePage(driver);
		hp.enter_prodName(productname);
	}
	@And("user choose first item from search result")
	public void user_choose_first_item_from_search_result() throws Exception {
		rp = new shopeeSearchResultPage(driver);
		Thread.sleep(3000);
	    rp.pick_first_item();
	}

	@And("user choose type and size, click add to cart")
	public void user_choose_type_and_size_click_add_to_cart() {
		ts = new shopeeTypeSize(driver);
		ts.pickcolorsize();
	}

	@Then("product will be added to cart")
	public void product_will_be_added_to_cart() {
		System.out.println(ts.addtocart());
	}
	
//	@After
//	public void teardown() {
//		driver.close();
//	} 
}	
