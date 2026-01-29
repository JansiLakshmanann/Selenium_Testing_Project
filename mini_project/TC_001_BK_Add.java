package mini_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_001_BK_Add extends BaseClass {
	String ectABtitle="Books";
	@Test
	public void ToAddBook() {
	
	driver.findElement(By.partialLinkText("Books")).click();
	String actABtitle = driver.findElement(By.xpath("//h1[text()='Books'] ")).getText();
	
	if(actABtitle.equals(ectABtitle)) {
		Reporter.log("Navigated successful to book",true);
	}
	else {
		Reporter.log("Failed to Navigate book",true);
	}
	//HARD ASSERT
	Assert.assertEquals(actABtitle, ectABtitle);
	Reporter.log("Navigated successful to book page",true);
	
	//SORT - USING SELECT CLASS
	WebElement sortBy = driver.findElement(By.id("products-orderby"));
	Select selectSort=new Select(sortBy);
	selectSort.selectByIndex(3);
	Reporter.log("Sort by Low to High",true);
	
	//SELECT A PRODUCT
	driver.findElement(By.linkText("Computing and Internet")).click();
	Reporter.log("Successfully select the book ",true);
	
	driver.findElement(By.id("add-to-cart-button-13")).click();
	Reporter.log("Successfully book is added",true);

	}
	
	


}
