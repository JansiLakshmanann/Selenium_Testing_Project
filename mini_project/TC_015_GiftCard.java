package mini_project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_015_GiftCard extends BaseClass{

	@Test
	public void giftcard() {
		String expTitle="Gift Cards";
		driver.findElement(By.partialLinkText("Gift Cards")).click();
		String actTitle = driver.findElement(By.xpath("//h1[text()='Gift Cards']")).getText();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log(actTitle,true);
		
		driver.findElement(By.partialLinkText("Virtual ")).click();
		driver.findElement(By.id("giftcard_1_RecipientName")).sendKeys("Anu");
		driver.findElement(By.id("giftcard_1_RecipientEmail")).sendKeys("Anu123@gmail.com");
		driver.findElement(By.id("giftcard_1_Message")).sendKeys("Happy purchase");
		driver.findElement(By.id("add-to-cart-button-1")).click();
		driver.findElement(By.xpath("//span[@class='cart-label' and text()='Shopping cart']")).click();
		
		
	}
}
