package mini_project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_011_COMPARE extends BaseClass{

	String expTitle="Apparel & Shoes";
	@Test
	public void compare() {
		driver.findElement(By.partialLinkText("Apparel & Shoes")).click();
		String actTitle=driver.findElement(By.xpath("//h1[text()='Apparel & Shoes']")).getText();
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log(actTitle,true);
		driver.findElement(By.linkText("Green and blue Sneaker")).click();
		
		String expCompare="Compare products";
		driver.findElement(By.xpath("//input[@value='Add to compare list']")).click();
		String actCompare = driver.findElement(By.xpath("//h1[text()='Compare products']")).getText();
		Assert.assertEquals(expCompare, actCompare);
		Reporter.log(actCompare,true);
		
	}
}
