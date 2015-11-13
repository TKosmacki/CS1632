package stackoverflowTest;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import junit.framework.TestSuite;

public class UserStory2 {


	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://stackoverflow.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  /*
	  Given that I am on the home page
		When I look at the page
		Then I should see a search box to input my question
	  */
	  @Test
	  public void testScenerio1() throws Exception {
	    driver.get(baseUrl + "/");
	    // Warning: assertTextPresent may require manual changes
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*search[\\s\\S]*$"));
	  }
	  
	  /*
	   Given that I am on the search page after entering a question in the search box
		When I view the search results page
		Then I should see questions with similar keywords to mine
	   */
	  @Test
	  public void testScenerio2() throws Exception {
	    driver.get(baseUrl + "/search?q=is+java+pass+by+reference");
	    assertTrue(isElementPresent(By.linkText("Q: Is Java “pass-by-reference” or “pass-by-value”?")));
	    assertTrue(isElementPresent(By.linkText("Q: Java is Pass-By-Value and Pass-By-Reference Both [duplicate]")));
	    assertTrue(isElementPresent(By.linkText("Q: Is Java pass by value Or pass by reference Or both? [duplicate]")));
	    assertTrue(isElementPresent(By.linkText("A: Is Java “pass-by-reference” or “pass-by-value”?")));
	  }
	  
	  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

	  /*
	    Given that I entered a question in the search box
		When I look at the results page
		Then I should see options for sorting the results
      */
	  @Test
	  public void testScenerio3() throws Exception {
	    driver.get(baseUrl + "/search?q=is+java+pass+by+reference");
	    assertEquals("relevance", driver.findElement(By.linkText("relevance")).getText());
	    assertEquals("newest", driver.findElement(By.linkText("newest")).getText());
	    assertEquals("votes", driver.findElement(By.linkText("votes")).getText());
	    assertEquals("active", driver.findElement(By.linkText("active")).getText());
	  }
	  
	  /*
	   Given that I entered a question in the search box
		When I look at the results page
		Then I should see tags near each question showing the categories each question
                      pertains to
      */
	  @Test
	  public void testScenerio4() throws Exception {
	    driver.get(baseUrl + "/search?q=is+java+pass+by+reference");
	    assertEquals("java", driver.findElement(By.linkText("java")).getText());
	    assertEquals("parameter-passing", driver.findElement(By.linkText("parameter-passing")).getText());
	    assertEquals("terminology", driver.findElement(By.linkText("terminology")).getText());
	    assertEquals("pass-by-reference", driver.findElement(By.linkText("pass-by-reference")).getText());
	    assertEquals("pass-by-value", driver.findElement(By.linkText("pass-by-value")).getText());
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
