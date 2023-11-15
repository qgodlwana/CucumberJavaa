package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class BackGroundDemoSteps {
	WebDriver driver = null;
	
	@Before
	public void Setup()
	{
		System.out.println("I am inside browser setup");
		System.setProperty("Webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		
		driver.manage().window().maximize();
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000);
	}
	@When("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		Thread.sleep(1000);
	}
	@And("click on login button")
	public void click_on_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(1000);
	}

	@Then("user is navigated to the homepage")
	public void user_is_navigated_to_the_homepage() {
		driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
	}
	@Given("user is logged in")
	public void user_is_logged_in() {
		driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
	}
	@When("user clicks on welcome link")
	public void user_clicks_on_welcome_link() throws InterruptedException {
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(1000);
	}

	@Then("logout link is displayed")
	public void logout_link_is_displayed() {
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).isDisplayed();
	}

	@When("user clicks on dashboard link")
	public void user_clicks_on_dashboard_link() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']")).click();
		Thread.sleep(1000);
	}

	@Then("quick launch toolbar is displayed")
	public void quick_launch_toolbar_is_displayed() {
		driver.findElement(By.xpath("//p[normalize-space()='Quick Launch']")).isDisplayed();
	}
	@After
	public void TearDown()
	{
		driver.close();
		driver.quit();
	}
}
