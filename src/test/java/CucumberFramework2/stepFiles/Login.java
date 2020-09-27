package CucumberFramework2.stepFiles;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import org.junit.Assert;

public class Login {
	
	WebDriver driver;
	
	//Running on Chrome
	/*@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/DesktopW7/Documents/Libs/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
	}*/
	
	//running on Firefox
	@Before
	public void setup_firefox() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setCapability("marionette", true);
		System.setProperty("webdriver.gecko.driver", "/Users/DesktopW7/Documents/Libs/geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	}
			
	@Given("^User navigates to stackoverflow website$")
	public void user_navigates_to_stackoverflow_website() throws Throwable {
	    driver.get("https://stackoverflow.com/");
		System.out.println("Opening the website");
	}

	@And("^User clicks on the login button on homepage$")
	public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Log In']")).click();
		System.out.println("Clicking on Login button");
	}

	@And("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("autotestudemy@mail.com");
		System.out.println("Inserting user");
	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Password321!");
		System.out.println("Inserting password");
	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='submit-button']")).click();
		System.out.println("Clicking on Login button");
	}

	@Then("^User should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
		Thread.sleep(3000);
		WebElement askQuestionButton = driver.findElement(By.xpath("//a[contains(text(), 'Ask Question')]"));
		Assert.assertEquals(true, askQuestionButton.isDisplayed());
		System.out.println("Clicking on ask question button");
	}

}
