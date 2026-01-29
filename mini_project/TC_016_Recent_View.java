package mini_project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_016_Recent_View extends BaseClass{

	@Test
	public void recentlyview() {
		
		String expTitle="Recently viewed products";
		//VIEW SOME PRODUCTS
		driver.findElement(By.partialLinkText("Digital ")).click();
		driver.findElement(By.partialLinkText("3rd Album")).click();
		driver.findElement(By.partialLinkText("Jewelry")).click();
		driver.findElement(By.linkText("Black & White Diamond Heart")).click();
		
		
		driver.findElement(By.linkText("Recently viewed products")).click();
		String actTitle = driver.findElement(By.xpath("//h1[text()='Recently viewed products']")).getText();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log(actTitle,true);
		
}
}
