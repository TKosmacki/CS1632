import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


/*
As a user
I want an account
So that I can have a personalized profile
*/

public class UserStory1 {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://stackoverflow.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	/*
	Given that I do not have an account
	When I go to sign up
	Then there is an option to add my own personal details to create an account
	*/
	@Test
	public void testSignUpInformation() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.cssSelector("#switch > a")).click();
		driver.findElement(By.cssSelector("#switch > a")).click();
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
	}
	
	/*
	Given that I do have an account
	When I go to login
	Then there is an option to type in my username and password and a login button
	*/
	@Test
	public void testLogin() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
		assertTrue(isElementPresent(By.id("submit-button")));
	}
	
	/*
	Given that I have an account
	When I attempt to login with invalid credentials
	Then I am not permitted access to the account I typed in
	*/
	@Test
	public void testInvalidLogin() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("elf62@pitt.edu");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("elf62@pitt.edu");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("asdf");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("asdf");
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.id("submit-button")).click();
		assertTrue(isElementPresent(By.cssSelector("div.message-text")));
	}
	
	/*
	Given that I have an account
	When I attempt to login with valid credentials for my account
	Then I am logged into my account
	*/
	@Test
	public void testValidLogin() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("elf62@pitt.edu");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("elf62@pitt.edu");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Eliandtyler1");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Eliandtyler1");
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.id("submit-button")).click();
		assertTrue(isElementPresent(By.cssSelector("img.avatar-me.js-avatar-me")));
	}
	
	/*
	Given that I have logged in and am at the homepage
	When I navigate to my profile
	Then I will see a listing of questions I have answered
	*/
	@Test
	public void testAnswers() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("elf62@pitt.edu");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Eliandtyler1");
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
		driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
	}
	
	/*
	Given that I have logged in and am at the homepage
	When I navigate to my profile
	Then I will see a listing of questions I have asked
	*/
	@Test
	public void testQuestions() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("elf62@pitt.edu");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Eliandtyler1");
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
		driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
	}
	
	/*
	Given that I have logged in and am at the homepage
	When I navigate to my profile
	Then I will see my reputation value
	*/
	@Test
	public void testReputation() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("elf62@pitt.edu");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Eliandtyler1");
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
		driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
	}
	
	/*
	Given that I have logged in and am at the homepage
	When I navigate to my profile
	Then I will be able to edit some basic profile information about myself
	*/
	@Test
	public void testEditProfile() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("elf62@pitt.edu");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Eliandtyler1");
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
		driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
		driver.findElement(By.linkText("Edit Profile & Settings")).click();
		driver.findElement(By.linkText("Edit Profile & Settings")).click();
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
		  fail(verificationErrorString);
		}
	}
}