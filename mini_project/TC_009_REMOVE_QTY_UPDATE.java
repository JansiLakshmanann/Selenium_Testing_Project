package mini_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_009_REMOVE_QTY_UPDATE extends BaseClass {

	String expTitle="Shopping cart";
	@Test
	public void removeCart() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		
		//VALIDATION BEFORE ADDING THE QTY
		
		WebElement price = driver.findElement(By.xpath("//span[@class='product-subtotal']"));
		String priceVal = price.getText();
		Reporter.log("Total amount - Before Deletion: Rs. "+priceVal,true);
		
		String actTitle = driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]")).getText();
		 	Assert.assertEquals(actTitle, expTitle);
			Reporter.log("successfully navigate to Cart",true);
			
			//ADD THE QTY
			WebElement qtyText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class,'qty-input')]")));					
			qtyText.clear();
			qtyText.sendKeys("5");
			driver.findElement(By.name("updatecart")).click();
			
			//VALIDATION - UPDATED QTY
			qtyText = wait.until(
				    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'qty-input')]"))
				);
			String updateQty=qtyText.getAttribute("value");
			Reporter.log("Updated qty: "+updateQty,true);
			
			//VALIDATION AFTER ADDING THE QTY (UPDATED PRICE)
			WebElement price1 = driver.findElement(By.xpath("//span[@class='product-subtotal']"));
			String priceVal1 = price1.getText();
			Reporter.log("Total amount - After Deletion: Rs. "+priceVal1,true);
			
			
			Thread.sleep(2000);
			
	}
}
