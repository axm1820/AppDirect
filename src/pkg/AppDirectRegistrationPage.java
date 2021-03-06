package pkg;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.*;
import org.testng.junit.*;
import org.openqa.*;


public class AppDirectRegistrationPage extends AppDirectHomePageTest {
	
	 @DataProvider
	 public Object[][] emailaddress() {
	     return new Object[][] {
	       new Object[] {"akshat111@gmail.com"},
	       new Object[] {"akshatpkg@somedomain.com"},
	       new Object[] { " "},
	       new Object[] { "xyz@gmail.com"},
	       new Object[] { "121223"},
	       new Object[] {"......xxx...."},
	     };
	   }	
	  /*
	   * Some basic setup is done in the previous class
	   * adding a few steps here for signup
	   * 
	   */
	  @BeforeTest
	  public void Setup() {
		    WebElement Signup= driver.findElement(By.linkText("Sign Up"));
			String url= driver.getCurrentUrl();
			System.out.println(url);
			Signup.click(); 
      }
	 /*
	  * 
	  * (non-Javadoc)
	  * @see pkg.AppDirectHomePageTest#signup(java.lang.String)
	  */
	 @Test(dataProvider = "emailaddress")
	 public void signup(String emailaddress) {
		     
		    String url=driver.getCurrentUrl();
		    WebElement email=driver.findElement(By.xpath(("//input[@name='emailAddress']")));
		    WebElement signupbtn=driver.findElement(By.xpath(("//button[@name='userSignupButton']")));
		    email.sendKeys(emailaddress);
		    signupbtn.click();
		    WebElement loginbtn=driver.findElement(By.linkText("Log In"));
		    loginbtn.click();
		    WebElement Signup= driver.findElement(By.linkText("Sign Up"));
		    Signup.click(); 
		   }
	 /*
	  * Teardown after running all the tests
	  * 
	  */

      @AfterTest
      public void teardown() {
    	  driver.close();
      }
}