package mini_project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_008_SEARCH extends BaseClass{
	String expTitle="Simple Computer";
	@Test
	public void Search() {
		driver.findElement(By.id("small-searchterms")).sendKeys("Computer",Keys.ENTER);
		driver.findElement(By.partialLinkText("Simple Computer")).click();
		WebElement radioProcess = driver.findElement(By.xpath("//label[text()='Slow ']"));
		radioProcess.click();
		driver.findElement(By.id("add-to-cart-button-75")).click();
		
		String actTitle = driver.findElement(By.xpath("//h1[contains(text(),'Simple Computer')]")).getText();
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log(actTitle,true);
		Reporter.log(expTitle,true);
		
	}
}
