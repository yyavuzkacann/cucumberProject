package stepDefinitions;

	import org.junit.Assert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
	import cucumber.api.java.en.*;

	public class amazonLogin extends locators{

		WebDriver driver;
		
		@Given("^I am a user of amazon\\.com$")
		public void i_am_a_user_of_amazon_com() throws Exception {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}

		@When("^I log in using valid credentials$")
		public void i_log_in_using_valid_credentials() throws Exception {
			driver.findElement(By.cssSelector(loginButton)).click();
			driver.findElement(By.cssSelector(email)).sendKeys(username);
			driver.findElement(By.cssSelector(contunieButton)).click();
			driver.findElement(By.cssSelector(pass)).sendKeys(password);
			driver.findElement(By.cssSelector(submitButton)).click();
		}

		@Then("^I should be logged in$")
		public void i_should_be_logged_in() throws Exception {
			String getUsername = driver.findElement(By.cssSelector(usernameLabel)).getText();
			Assert.assertTrue(getUsername.contains("Yavuz"));
		}
		
		@After()
	    public void closeBrowser() {
	      driver.quit();
		}
		
		@When("^I log in using invalid credentials$")
		public void i_log_in_using_invalid_credentials() throws Exception {
			driver.findElement(By.cssSelector(loginButton)).click();
			driver.findElement(By.cssSelector(email)).sendKeys(username);
			driver.findElement(By.cssSelector(contunieButton)).click();
			driver.findElement(By.cssSelector(pass)).sendKeys(wrongPassword);
			driver.findElement(By.cssSelector(submitButton)).click();
		}

		@Then("^I should not be logged in$")
		public void i_should_not_be_logged_in() throws Exception {
			
			String errorMessage = driver.findElement(By.className(alertLabel)).getText();
			Assert.assertTrue(errorMessage.contains(alertMessage));
		}

	}

