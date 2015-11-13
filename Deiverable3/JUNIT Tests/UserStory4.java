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

import org.junit.Test;

public class UserStory4 {

	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://stackoverflow.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  /*
	   Given that I have an account and I am currently logged into the website 
		When I view the homepage
		Then there is an option to ask a question
	   */
	  @Test
	  public void testScenerio1() throws Exception {
	    driver.get(baseUrl + "/");
	    assertEquals("Ask Question", driver.findElement(By.id("nav-askquestion")).getText());
	  }
	  
	  /*
	    Given that I have an account and I am currently logged into the website and I am 
			on the homepage
		When I go to ask a question
		Then there are some tips and external links about asking good questions

	   */
	  @Test
	  public void testScenerio2() throws Exception {
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
	    driver.findElement(By.id("nav-askquestion")).click();
	    driver.findElement(By.id("nav-askquestion")).click();
	    assertEquals("thoroughly searched for an answer", driver.findElement(By.linkText("thoroughly searched for an answer")).getText());
	    assertEquals("avoid asking for opinions or open-ended discussion", driver.findElement(By.linkText("avoid asking for opinions or open-ended discussion")).getText());
	    assertEquals("How to Ask", driver.findElement(By.cssSelector("h1")).getText());
	  }
	  
	  /*
	   Given that I have an account and I am currently logged into the website and I am 
			on the ‘tips for asking questions page’
		When I proceed to the ask question page
		Then a form will appear that allows me to type in a question I have
	   */
	  @Test
	  public void testScenerio3() throws Exception {
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
	    driver.findElement(By.id("nav-askquestion")).click();
	    driver.findElement(By.id("nav-askquestion")).click();
	    driver.findElement(By.id("theForm")).click();
	    driver.findElement(By.id("advised")).click();
	    driver.findElement(By.linkText("proceed »")).click();
	    driver.findElement(By.linkText("proceed »")).click();
	    // Warning: assertTextPresent may require manual changes
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
	    assertTrue(isElementPresent(By.id("title")));
	    assertTrue(isElementPresent(By.id("wmd-input")));
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
	   Given that I have an account and have previously posted a question that has not been closed
		When I navigate to my profile and click on an asked question
		Then I should be able to edit the content of a question I have asked
	   */
	  @Test
	  public void testScenerio4() throws Exception {
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
	    driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
	    driver.findElement(By.cssSelector("img.avatar-me.js-avatar-me")).click();
	    driver.findElement(By.linkText("In Selenium IDE how do I assert that there is a button on a webpage containing a specific string?")).click();
	    driver.findElement(By.linkText("In Selenium IDE how do I assert that there is a button on a webpage containing a specific string?")).click();
	    driver.findElement(By.linkText("In Selenium IDE how do I assert that there is a button on a webpage containing a specific string?")).click();
	    driver.findElement(By.linkText("In Selenium IDE how do I assert that there is a button on a webpage containing a specific string?")).click();
	    assertEquals("edit", driver.findElement(By.cssSelector("a.edit-post")).getText());
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
