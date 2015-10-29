package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenerio2 {
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

  @Test
  public void testScenerio2() throws Exception {
    driver.get(baseUrl + "/search?q=is+java+pass+by+reference");
    assertEquals("Q: Java is Pass-By-Value and Pass-By-Reference Both [duplicate]", driver.findElement(By.linkText("Q: Java is Pass-By-Value and Pass-By-Reference Both [duplicate]")).getText());
    assertTrue(driver.findElement(By.linkText("A: Is Java “pass-by-reference” or “pass-by-value”?")).getText().matches("^exact:A: Is Java “pass-by-reference” or “pass-by-value”[\\s\\S]$"));
    assertTrue(driver.findElement(By.linkText("Q: Is Java pass by value Or pass by reference Or both? [duplicate]")).getText().matches("^exact:Q: Is Java pass by value Or pass by reference Or both[\\s\\S] \\[duplicate\\]$"));
    assertTrue(driver.findElement(By.linkText("A: Is Java “pass-by-reference” or “pass-by-value”?")).getText().matches("^exact:A: Is Java “pass-by-reference” or “pass-by-value”[\\s\\S]$"));
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
