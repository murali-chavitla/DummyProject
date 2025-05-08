package GenaricUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaseConfig {
	
	
 public WebDriver driver;
	
	@BeforeClass
	public void browserSetup() {
		
		driver=new ChromeDriver();
		Reporter.log("step1 : Browser launched sucessfully...", true);
		
		driver.get("https://www.automationexercise.com/");
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();		
		Reporter.log("step2 : Navigated to application  sucessfully...", true);
		
		
	}
	
	
	@BeforeMethod
	public void login() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("dinga1@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("dinga1234");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
		Reporter.log("step3 : Login sucessfully...", true);
		
		
		driver.findElement(By.xpath("//a[text()=' Products']")).click();
		Reporter.log("clicked on the product");
		
	}
	
	
	@AfterMethod()
	public void logout() throws InterruptedException {
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.findElement(By.xpath("//a[text()=' Logout']")).click();
		 
		
		Reporter.log("step5 : Logout sucessfully...", true);
	}	
	
	@AfterClass()
	public void close() {
		driver.close();
		Reporter.log("step6 : closed browser sucessfully...", true);
	}
	
	@DataProvider
	public Object[][] dataProvider1() {
		
		Object [][] a=new Object[3][3];
		a[0][0]=100;
		a[0][1]="M11";
		a[0][2]=true;
		
		a[1][0]=200;
		a[1][1]="M12";
		a[1][2]=false;
		
		a[2][0]=300;
		a[2][1]="M13";
		a[2][2]=true;
		
		return a;
	}
	

}
