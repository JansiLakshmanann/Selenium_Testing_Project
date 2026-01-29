package mini_project;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TC_013_Ordersummary extends BaseClass{

	String expTitle="Demo Web Shop";
	@Test
	public void ordersummary() throws IOException {
		driver.findElement(By.linkText("Orders")).click();
		
		//SCREEN SHOT
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File src=new File("./errorShots/ordersummary.jpeg");
		FileHandler.copy(temp, src);
		
		
	}
	
}
