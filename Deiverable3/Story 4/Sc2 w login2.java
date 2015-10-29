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
