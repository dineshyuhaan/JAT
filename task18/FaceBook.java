package mavenproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook {
	@Test
	public void test1() throws InterruptedException {
		//navigate firefox page
		ChromeDriver chromeDriver=new ChromeDriver();
		chromeDriver.get("http://www.facebook.com");
	Thread.sleep(1000);
	
		//click on the create a button
		WebElement element=chromeDriver.findElement(By.xpath("//a[text()='Create new account']"));
		element.click();
		Thread.sleep(1000);
		//verify the correct page
		if (!chromeDriver.getTitle().contains("Facebook")) {
    		System.out.println("Failed to open facebook page.");
    		return;}
		//create a account 
		WebElement firstname=chromeDriver.findElement(By.name("firstname"));
		firstname.sendKeys("Dinesh");
	WebElement lastname=chromeDriver.findElement(By.name("lastname"));
	lastname.sendKeys("Rajavel");
	WebElement email=chromeDriver.findElement(By.name("reg_email__"));
	email.sendKeys("dhinumaha29@gmail.com");
	WebElement confirmemail=chromeDriver.findElement(By.name("reg_email_confirmation__"));
	confirmemail.sendKeys("dhinumaha29@gmail.com");
	WebElement password=chromeDriver.findElement(By.name("reg_passwd__"));
	password.sendKeys("12345@6");	
	//enter the date, month, year
	WebElement date=chromeDriver.findElement(By.name("birthday_day"));
	date.sendKeys("20");
	WebElement month=chromeDriver.findElement(By.name("birthday_month"));
	month.sendKeys("august");
	WebElement year=chromeDriver.findElement(By.name("birthday_year"));
	year.sendKeys("2015");
	
	//Select gender button
	WebElement gender = chromeDriver.findElement(By.xpath("//input[@value='1']"));
    	gender.click();

    	//click submit button
    	WebElement submit = chromeDriver.findElement(By.xpath("//button[@name='websubmit']"));
	submit.click();
	
		Thread.sleep(1000);
		
		
		//showing error message
		
	
	}
}
