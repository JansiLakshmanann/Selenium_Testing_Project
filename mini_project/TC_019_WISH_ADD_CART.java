package mini_project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_019_WISH_ADD_CART extends BaseClass{

	@Test
	public void wistTOadd() {
		String expTitle="Wishlist";
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
		String actTitle = driver.findElement(By.xpath("//h1[contains(text(),'Wishlist')]")).getText();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log(actTitle,true);
		
		//ADD WISHLIST TOO CART
		driver.findElement(By.name("addtocart")).click();
		driver.findElement(By.name("addtocartbutton")).click();
		driver.findElement(By.xpath("//span[@class='cart-label' and text()='Shopping cart']")).click();
		
		String cartTitle="Shopping cart";
		String cart = driver.findElement(By.xpath("//h1[text()='Shopping cart']")).getText();
		Assert.assertEquals(cartTitle, cart);
		Reporter.log(cart,true);
		
	}
}
