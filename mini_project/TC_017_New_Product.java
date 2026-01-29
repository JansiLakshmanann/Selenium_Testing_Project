package mini_project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_017_New_Product extends BaseClass {

	@Test
	public void newproduct() {
	String expTitle="New products";	
	driver.findElement(By.partialLinkText("New products")).click();
	String actTitle = driver.findElement(By.xpath("//h1[text()='New products']")).getText();
	Assert.assertEquals(expTitle, actTitle);
	Reporter.log(actTitle,true);
	
	}
}
