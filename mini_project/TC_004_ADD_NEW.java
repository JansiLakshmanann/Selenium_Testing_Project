package mini_project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_004_ADD_NEW extends BaseClass {

	String exptTitle="My account - Addresses";
	
	@Test
	public void Address() {
		
		driver.findElement(By.linkText("Addresses")).click();
		String actTitle = driver.findElement(By.xpath("//h1[text()='My account - Addresses']")).getText();
		
		if(exptTitle.equals(actTitle)) {
			Reporter.log("Navigate to Address - Successful",true);
		}
		else {
			Reporter.log("Failed to Navigate - Address",true);
		}
		
		driver.findElement(By.xpath("//input[@value='Add new']")).click();
		Reporter.log("Successfully clicked add new address button",true);
			
		driver.findElement(By.id("Address_FirstName")).sendKeys("Jansi");
		driver.findElement(By.id("Address_LastName")).sendKeys("Lakshmanan");
		driver.findElement(By.id("Address_Email")).sendKeys("jankarthikeyan123@gmail.com");
		
		driver.findElement(By.id("Address_Company")).sendKeys("AAA");
		WebElement countrySelect = driver.findElement(By.id("Address_CountryId"));
		Select countryName= new Select(countrySelect);
		countryName.selectByVisibleText("India");
		
		driver.findElement(By.id("Address_City")).sendKeys("Tiruppur");
		driver.findElement(By.id("Address_Address1")).sendKeys("Palladam");
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys("645895");
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys("8956478954");
		Reporter.log("All datas are entered properly",true);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
	
		  Alert confirmation=driver.switchTo().alert();
		  Reporter.log("Address saved successfully confirmation msg accured",true);
		  confirmation.accept();
		 
	
	}
}
