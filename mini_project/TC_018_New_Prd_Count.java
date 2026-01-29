package mini_project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_018_New_Prd_Count extends BaseClass {

	@Test
	public void prdcount() {
		
		String expTitle="New products";	
		driver.findElement(By.partialLinkText("New products")).click();
		String actTitle = driver.findElement(By.xpath("//h1[text()='New products']")).getText();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log(actTitle,true);
		
		//COUNT THE ITEMS
		List<WebElement> count = driver.findElements(By.xpath("//div[@class='item-box']"));
		Reporter.log("Total number of new product: "+count.size(),true);
	}
}
