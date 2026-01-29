package mini_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_003_DIGITAL_ADD extends BaseClass{

	String expTitle = "Digital downloads";

	@Test
	public void ToAddComputer() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.partialLinkText("Digital downloads")).click();

		String actTitle = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//h1[normalize-space()='Digital downloads']")))
				.getText();

		if (actTitle.equals(expTitle)) {
			Reporter.log("Navigated successfully to Digital downloads page", true);
		} else {
			Reporter.log("Failed to navigate to Digital downloads page", true);
		}

		WebElement gridView = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.id("products-viewmode")));
		//VIEW - CHANGE
		Select viewMode = new Select(gridView);
		viewMode.selectByVisibleText("List");
		WebElement drop = driver.findElement(By.id("products-viewmode"));
		Select dropSelect=new Select(drop);
		dropSelect.selectByVisibleText("List");
		
		//ADD TO CART
		driver.findElement(By.linkText("3rd Album")).click();
		driver.findElement(By.id("add-to-cart-button-53")).click();
	
		
		  driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		  
		//SELECT ONE PRODUCT 
		  WebElement country =driver.findElement(By.id("CountryId")); 
		  Select countryOption=new Select(country);
		  countryOption.selectByVisibleText("India");
		 
		  //SHOPPING CART
		  
		  driver.findElement(By.id("termsofservice")).click();
		  driver.findElement(By.id("checkout")).click();
		  
		  driver.findElement(By.
		  xpath("//input[@title='Continue' and @onclick='Billing.save()']")).click();
		  driver.findElement(By.
		  xpath("//input[@title='Continue' and @onclick='Shipping.save()']")).click();
		  driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).
		  click();
		  driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).
		  click();
		  driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click(
		  );
		  driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click
		  ();
		 
		//CONFIRMATION MSG
		  String confirmation = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']")).getText();
		  Reporter.log(confirmation,true);
		
	}

		
	}

