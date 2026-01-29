package mini_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_010_ADD_WISHLIST extends BaseClass {

	@Test
	public void wishlist() {
		String expTitle="Apparel & Shoes";
		
		driver.findElement(By.partialLinkText("Apparel & Shoes")).click();
		 String actTitle = driver.findElement(By.xpath("//h1[text()='Apparel & Shoes']")).getText();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("The title is "+actTitle,true);
		driver.findElement(By.linkText("Blue and green Sneaker")).click();
		
		//DROPDOWN SELECTION
		WebElement size = driver.findElement(By.id("product_attribute_28_7_10"));
		Select select=new Select(size);
		select.selectByVisibleText("10");
		driver.findElement(By.id("add-to-wishlist-button-28")).click();
		
		//SELECT WISHLIST
		driver.findElement(By.xpath("//a[@href='/wishlist']//span[@class='cart-label']")).click();
		
		
	}
}
