package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AnswerQuestion {
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

  @Test
  public void testAnswerQuestion() throws Exception {
    driver.get(baseUrl + "/search");
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

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
