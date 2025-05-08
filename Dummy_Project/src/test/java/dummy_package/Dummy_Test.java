package dummy_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dummy_Test {
	
WebDriver driver=new ChromeDriver();
	
	@BeforeClass
	public void browserSetup() {
		Reporter.log("step1 : Browser launched sucessfully...", true);
		driver.get("https://www.saucedemo.com/");
		Reporter.log("step2 : Navigated to application  sucessfully...", true);
		
		
	}
	
	
	@BeforeMethod
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Reporter.log("step3 : Login sucessfully...", true);
		
		
	}
	
	
	@Test
	public void addProduct() throws InterruptedException {
		Reporter.log("step 4 : product added to cart sucessfully...", true);
		driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']")).click();
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//button[@name='add-to-cart']")).click();
	}
	
	@Test
	public void removeProduct() throws InterruptedException {
		driver.navigate().to("https://www.saucedemo.com/cart.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='remove-sauce-labs-backpack']")).click();
		Reporter.log("step n : removed from cart sucessfully...", true);
		
		//driver.findElement(By.xpath("//button[@name='continue-shopping']")).click();
	}
	
	
	@AfterMethod()
	public void logout() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Open Menu')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
		Reporter.log("step5 : Logout sucessfully...", true);
	}	
	
	@AfterClass()
	public void close() {
		driver.close();
		Reporter.log("step6 : closed browser sucessfully...", true);
	}

}
