package mini_project;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_002_BK_DELETE extends BaseClass{

	String expTitle="Shopping cart";
	@Test
	public void delete() {
	driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
	String actTitle = driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]")).getText();
	
		if(actTitle.equals(expTitle)) {
		Reporter.log("Successfully navigate to Cart",true);
		}
		else {
			Reporter.log("Failed to navigate to Cart",true);
		}
		
		driver.findElement(By.name("removefromcart")).click();
		Reporter.log("Check box selected",true);
		
		driver.findElement(By.name("updatecart")).click();
		
	}
}
	
