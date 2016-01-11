package pkg;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.*;
import org.testng.junit.*;
import org.openqa.selenium.Alert;
/*
 * This class sets up the webdriver and launches the browser
 * 
 * 
 */
public class AppDirectHomePageTest {
	
public WebDriver driver;
	
/**
 * Dataprovider for email addresses.
 * 
 * @return
 */
  @DataProvider
public Object[][] dp() {
    return new Object[][] {
      new Object[] { " "},
      new Object[] { "xyz@gmail.com"},
    };
  }
  /*
   * Pre-configuration for launching the tests
   * 
   */
  @BeforeTest
  public void beforeTest() {	
	  String url="https://www.appdirect.com/";
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, java.util.concurrent.TimeUnit.SECONDS);
	  driver.get(url);
	  org.testng.Assert.assertEquals(url, "https://www.appdirect.com/");
	  driver.manage().window().maximize();
	  WebElement loginbtn=driver.findElement(By.className("login"));
      loginbtn.click();
    }
   
   /*
    * Checking the string on login page.
    * 
    */
  @Test
  public void LoginPage() {
	  String url=driver.getCurrentUrl();
	  System.out.println(url);
      WebElement accountlogin=driver.findElement(By.xpath("//div[@class='round-white-cont']/h2"));
      org.testng.Assert.assertEquals("Log in to your account", accountlogin.getText());
  } 
  /*
   * Return the webdriver
   * 
   */
  
  public WebDriver getDriver() {
	  return driver;
  }
  /*
   * 
   * Entering the userinfo in the sign up page.
   * 
   */
  
  @Test (dataProvider = "dp")
  public void signup(String emailaddress) {
	WebElement  Signup=driver.findElement(By.linkText("Sign Up"));
	String url= driver.getCurrentUrl();
	System.out.println(url);
	Signup.click();
	WebElement email=driver.findElement(By.xpath(("//input[@name='emailAddress']")));
	email.sendKeys(emailaddress);
	/**
	 * Send an email
	 */
	WebElement btn=driver.findElement(By.id("id12"));
    btn.click();
   }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
}
