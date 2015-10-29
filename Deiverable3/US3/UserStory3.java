import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UserStory3 {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before//update to login
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://stackoverflow.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	/*
	Given that I am logged in and am on the front page
	When I click on the tags button
	Then I will have the ability to search based on various tags
	*/
	@Test
	public void testTagSort() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("nav-tags")).click();
		driver.findElement(By.id("nav-tags")).click();
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Type to find tags:[\\s\\S]*$"));
		assertTrue(isElementPresent(By.id("tagfilter")));
	}
	
	/*
	Given that I am logged in and am on the front page
	When I click on questions
	Then there is an option to sort by newest questions
	*/
	@Test
	public void testTimeSort() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("nav-questions")).click();
		driver.findElement(By.id("nav-questions")).click();
		assertTrue(isElementPresent(By.linkText("newest")));
	}
	
	/*
	Given that I am logged
	When I view the front page
	Then I should see a listing of the top questions with various ways of sorting them
	*/
	@Test
	public void testPopularitySorts() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.cssSelector("#hlogo > a")).click();
		driver.findElement(By.cssSelector("#hlogo > a")).click();
		assertTrue(isElementPresent(By.linkText("interesting")));
		assertTrue(isElementPresent(By.cssSelector("span.bounty-indicator-tab")));
		assertTrue(isElementPresent(By.linkText("hot")));
		assertTrue(isElementPresent(By.linkText("week")));
		assertTrue(isElementPresent(By.linkText("month")));
	}
	
	/*
	Given that I am logged in and I am on the search page
	When I type in a question I know exists on the website and search for it
	Then I should be able to post an answer to that question
	*/
	@Test
	public void testAnswerQuestion() throws Exception {
		driver.get(baseUrl + "/search");
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("elf62@pitt.edu");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Eliandtyler1");
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.cssSelector("td.col1 > input[name=\"q\"]")).click();
		driver.findElement(By.cssSelector("td.col1 > input[name=\"q\"]")).clear();
		driver.findElement(By.cssSelector("td.col1 > input[name=\"q\"]")).sendKeys("In Selenium IDE how do I assert that there is a button on a webpage containing a specific string?");
		driver.findElement(By.cssSelector("td.col1 > input[name=\"q\"]")).clear();
		driver.findElement(By.cssSelector("td.col1 > input[name=\"q\"]")).sendKeys("In Selenium IDE how do I assert that there is a button on a webpage containing a specific string?");
		driver.findElement(By.cssSelector("td.col2 > input[type=\"submit\"]")).click();
		driver.findElement(By.cssSelector("td.col2 > input[type=\"submit\"]")).click();
		driver.findElement(By.linkText("Q: In Selenium IDE how do I assert that there is a button on a webpage containing a specific st…")).click();
		driver.findElement(By.linkText("Q: In Selenium IDE how do I assert that there is a button on a webpage containing a specific st…")).click();
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
		assertTrue(isElementPresent(By.id("wmd-input")));
	}
	
	@After//update to logout
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
		  fail(verificationErrorString);
		}
	}
}