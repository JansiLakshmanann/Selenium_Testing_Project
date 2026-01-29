package mini_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_020_Google extends BaseClass {

	@Test
	public void google() {
		
		driver.findElement(By.linkText("Google+")).click();
		
		String parentwindow=driver.getWindowHandle();
		for(String childwindow:driver.getWindowHandles()) {
			if(!childwindow.equals(parentwindow)) {
				driver.switchTo().window(childwindow);
				break;
			}
		}
		String url = driver.getCurrentUrl();
		Reporter.log("Current URL: " + url, true);
		
		driver.findElement(By.xpath("//a[contains(text(),'Release Calendar')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//a[contains(text(),'Release Calendar')]")
			    )
			);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'})",element);


	}
}
