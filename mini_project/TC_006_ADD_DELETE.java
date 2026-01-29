package mini_project;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_006_ADD_DELETE extends BaseClass {

	@Test
	public void addDelete() throws InterruptedException {
	String exptTile="My account - Addresses";
		
		driver.findElement(By.linkText("Addresses")).click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String actTitle =driver.findElement(By.xpath("//h1[text()='My account - Addresses']")).getText();
		if(actTitle.equals(exptTile)) {
			Reporter.log("Navigation successfull on Edit address page",true);
		}
		else {
			Reporter.log("Navigation not successfull on Edit address page",true);
		}
		//POP UP HANDLE
		
		WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Delete']")));
		deleteBtn.click();
		
		Alert confirmation = wait.until(ExpectedConditions.alertIsPresent());

		Reporter.log(confirmation.getText(), true);
		confirmation.accept();
		 
		//driver.navigate().refresh();
	}
}
