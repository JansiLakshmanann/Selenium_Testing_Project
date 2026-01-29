package mini_project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_014_Footer_Contact extends BaseClass{

	@Test
	public void contactus() {
		String expTitle="Contact Us";
		driver.findElement(By.linkText("Contact us")).click();
		String actTitle = driver.findElement(By.xpath("//h1[text()='Contact Us']")).getText();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log(actTitle,true);
		driver.findElement(By.id("Enquiry")).sendKeys("Happy to use this app");
		driver.findElement(By.name("send-email")).click();
		String confirmation = driver.findElement(By.xpath("//div[@class='result']")).getText();
		Reporter.log(confirmation,true);
	}
}
