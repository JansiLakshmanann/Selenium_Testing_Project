package mini_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_007_JEW_SORT extends BaseClass {

	String expTitle="Jewelry";
	
	@Test
	public void JewSort() {
		driver.findElement(By.partialLinkText("Jewelry")).click();
		String actTitle = driver.findElement(By.xpath("//h1[text()='Jewelry']")).getText();
		
		if(actTitle.equals(expTitle)) {
			Reporter.log("Navigate successfull to jewelery page",true);
		}
		else {
			Reporter.log("Fail to Navigate jewelery page",true);
		}
		//SORT BY
		WebElement sortBy = driver.findElement(By.id("products-orderby"));
		Select sortSelect=  new Select(sortBy);
		sortSelect.selectByVisibleText("Price: Low to High");
		
		//DISPLAY
		WebElement sortByPage = driver.findElement(By.id("products-pagesize"));
		Select sortPage=new Select(sortByPage);
		sortPage.selectByIndex(0);
	}
}
