package mavenproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SnapDeal {
	@Test
	public void test() throws InterruptedException {

//create a object for ChromeDriver	
		ChromeDriver chromeDriver = new ChromeDriver();
//maximize page
		chromeDriver.manage().window().maximize();
//enter the URL
		chromeDriver.get("http://www.snapdeal.com");
//click on the signin button
		WebElement signin = chromeDriver.findElement(By.className("accountInner"));
		signin.click();
//click on the login button
		WebElement logIn = chromeDriver.findElement(By.xpath("//span[@class='accountBtn btn rippleWhite']"));
		logIn.click();
		Thread.sleep(1000);
		WebElement logInframe = chromeDriver.findElement(By.xpath("//iframe[@id='loginIframe']"));
		chromeDriver.switchTo().frame(logInframe);
//navigate login page
		WebElement email = chromeDriver.findElement(By.id("userName"));
		email.sendKeys("dineshr1725@gmail.com");
		WebElement continuebtn = chromeDriver.findElement(By.id("checkUser"));
		continuebtn.click();

//Steps 7,8 and 9 is not possible to do right now , because it is asking OTP verification after doing step 6.

	}
}