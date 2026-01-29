package mini_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	String exphometitle="Demo Web Shop";
		
	 @BeforeClass
	public void tolaunchwebpage()
	{
			driver=new ChromeDriver();
			Reporter.log("Browser got launched",true);
			driver.manage().window().maximize();
			Reporter.log("Browser got maximized",true);
			driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
	}
	 
	 @BeforeMethod
	 public void login()
	 {
		 driver.get("https://demowebshop.tricentis.com/");
		 Reporter.log("Website got opened",true);
		 String acthometitle=driver.getTitle();
		 if(acthometitle.equals(exphometitle))
		 {
			 Reporter.log("Successfully navigated to Demo Web Shop",true);
		 }
		 else
		 {
			 Reporter.log("Failed to navigated to Demo Web Shop",true);
		 }
		 driver.findElement(By.linkText("Log in")).click();
		 Reporter.log("Successfully clicked login",true);
		 driver.findElement(By.id("Email")).sendKeys("jankarthikeyan123@gmail.com");
		 Reporter.log("User name filled",true);
		 driver.findElement(By.id("Password")).sendKeys("Jansi@123");
		 Reporter.log("Password filled",true);
		 driver.findElement(By.xpath("//input[@value='Log in']")).click();
		 Reporter.log("Login Successfull",true);
	 }
	 
	 @AfterMethod
	 public void tologout() {
		 driver.findElement(By.linkText("Log out")).click();
		 Reporter.log("Logoutyutu	 successfull",true);
	 }
	 
	 @AfterClass
	 public void toquitweb() {
		 Reporter.log("Browser succefully closed",true);
		 driver.quit();
	 }
}
