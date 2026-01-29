package mini_project;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_012_LIST_CARTITEM extends BaseClass {

	@Test
	public void itemlist() {
		String expTitle="Shopping cart";
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		String actTitle = driver.findElement(By.xpath("//h1[text()='Shopping cart']")).getText();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log(actTitle,true);
		
		//LIST THE PRODUCT
		List<WebElement> rowsCount = driver.findElements(By.xpath("//table[@class='cart']//tr[@class='cart-item-row']"));
		
		for(WebElement rows:rowsCount) {
			String prdName=rows.findElement(By.className("product-name")).getText();
			String quantity=rows.findElement(By.xpath(".//input[contains(@class,'qty-input')]")).getAttribute("value");
			String price=rows.findElement(By.xpath(".//span[@class='product-unit-price']")).getText();
			Reporter.log("Product Name: "+prdName,true);
			Reporter.log("Quantity: " +quantity,true);
			Reporter.log("Unit Price: "+price,true);
			
			String totalAmt = driver.findElement(By.xpath(".//span[@class='product-price order-total']")).getText();
			Reporter.log("Total Amount: " +totalAmt,true);
		}
	}
}
