package mini_project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_005_ADD_EDIT extends BaseClass{

	@Test
	public void AddEdit() throws InterruptedException {
		//EDIT ADDRESS
		String exptTile="My account - Edit address";
		
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("//input[@value='Edit']")).click();
		String actTitle = driver.findElement(By.xpath("//h1[text()='My account - Edit address']")).getText();
	
		if(actTitle.equals(exptTile)) {
			Reporter.log("Successfully navigate to Edit Address page",true);
		}
		else {
			Reporter.log("Navigation failed",true);
		}
		
		WebElement nameText = driver.findElement(By.id("Address_FirstName"));
		nameText.sendKeys(Keys.CONTROL,"a");
		nameText.sendKeys(Keys.DELETE);
		nameText.sendKeys("Janskarthik");
		
		WebElement phoneNumber = driver.findElement(By.id("Address_PhoneNumber"));
		phoneNumber.sendKeys(Keys.CONTROL,"a");
		phoneNumber.sendKeys(Keys.DELETE);
		phoneNumber.sendKeys("9875896487");
			
		Assert.assertEquals(nameText.getAttribute("value"), "Janskarthik");
		Assert.assertEquals(phoneNumber.getAttribute("value"), "9875896487");
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(3000);
		
	}
}
