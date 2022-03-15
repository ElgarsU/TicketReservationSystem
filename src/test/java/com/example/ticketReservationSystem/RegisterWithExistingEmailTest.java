package com.example.ticketReservationSystem;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class RegisterWithExistingEmailTest {

  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver","D:\\ticketReservationSystem\\chromedriver.exe");
    driver = new ChromeDriver();
    String baseUrl = "http://127.0.0.1:8080/login";
    driver.get(baseUrl);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();


  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void registerWithExistingEmail() throws InterruptedException {
    // Test name: RegisterWithExistingEmail
    // Step # | name | target | value
    // 1 | open | /login | 
    driver.get("http://127.0.0.1:8080/login");
    // 2 | setWindowSize | 1196x941 | 
    driver.manage().window().setSize(new Dimension(1196, 941));
    // 3 | click | linkText=Register here |
    driver.findElement(By.linkText("Register here")).click();
    Thread.sleep(1000);
    // 4 | click | id=name | 
    driver.findElement(By.id("name")).click();
    Thread.sleep(1000);
    // 5 | type | id=name | zhenyang
    driver.findElement(By.id("name")).sendKeys("zhenyang");
    Thread.sleep(1000);
    // 6 | click | id=surname | 
    driver.findElement(By.id("surname")).click();
    Thread.sleep(1000);
    // 7 | type | id=surname | zhenyang
    driver.findElement(By.id("surname")).sendKeys("zhenyang");
    Thread.sleep(1000);
    // 8 | click | id=email |
    driver.findElement(By.id("email")).click();
    Thread.sleep(1000);
    // 9 | type | id=email | zhenyang@gmail.com
    driver.findElement(By.id("email")).sendKeys("zhenyang@gmail.com");
    Thread.sleep(1000);
    // 10 | click | id=password | 
    driver.findElement(By.id("password")).click();
    Thread.sleep(1000);
    // 11 | type | id=password | zhen
    driver.findElement(By.id("password")).sendKeys("zhen");
    Thread.sleep(1000);
    // 12 | click | css=.btn |
    driver.findElement(By.cssSelector(".btn")).click();
  }
  @Test
  public void registerWithGoodDetails() {
    driver.get("http://localhost:8080/login");
    driver.manage().window().setSize(new Dimension(1196, 941));
    driver.findElement(By.linkText("Register here")).click();
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys("test");
    driver.findElement(By.id("surname")).click();
    driver.findElement(By.id("surname")).sendKeys("test");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("test@gmail.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("test");
    driver.findElement(By.cssSelector(".btn")).click();
  }
  @Test
  public void loginWithExistingUser() {
    driver.get("http://localhost:8080/login");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("zhenyang@gmail.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("zhenyang");
    driver.findElement(By.id("login-submit")).click();

  }
  @Test
  public void loginWithWrongCredentials() {
    driver.get("http://localhost:8080/login");
    driver.findElement(By.id("username")).sendKeys("test123@gmail.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("test");
    driver.findElement(By.id("login-submit")).click();
  }




}
