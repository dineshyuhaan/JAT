package mavenproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuviRegister {
	@Test
	public void id() {
		//enter the url
		ChromeDriver chromeDriver=new ChromeDriver();
		
		chromeDriver.get("https://www.guvi.in/register");
		
		// ID
		WebElement username = chromeDriver.findElement(By.id("name"));
        WebElement email = chromeDriver.findElement(By.id("email"));
         username.sendKeys("dinesh");
        email.sendKeys("t456@test.com");
	}
	@Test
	public void className() {
		
		//enter the url
		ChromeDriver chromeDriver=new ChromeDriver();
		
		chromeDriver.get("https://www.guvi.in/register");
        
        // class
        WebElement signup =chromeDriver.findElement(By.className("signup-btn"));
        
	}
	@Test
	public void css() {
		
		//enter the url
		ChromeDriver chromeDriver=new ChromeDriver();
		
		chromeDriver.get("https://www.guvi.in/register");
		
		// Css selecter
		WebElement password = chromeDriver.findElement(By.cssSelector("#password"));
		WebElement mobile = chromeDriver.findElement(By.cssSelector("#mobileNumber"));
		WebElement signup = chromeDriver.findElement(By.cssSelector("#signup-btn"));
        password.sendKeys("T@564");
        mobile.sendKeys("9876543210");
	}
	@Test
	public void xpath() {
		
		//enter the url
		ChromeDriver chromeDriver=new ChromeDriver();
		
		chromeDriver.get("https://www.guvi.in/register");
		
		// Xpath
		WebElement username = chromeDriver.findElement(By.xpath("//input[@id='name']"));
		WebElement email = chromeDriver.findElement(By.xpath("//input[@id='email']"));
		WebElement password = chromeDriver.findElement(By.xpath("//input[@id='password']"));
		WebElement mobile = chromeDriver.findElement(By.xpath("//input[@id='mobileNumber']"));
		WebElement signup = chromeDriver.findElement(By.xpath("//a[@id='signup-btn']"));
		username.sendKeys("dinesh");
        email.sendKeys("t456@test.com");
        password.sendKeys("T@564");
        mobile.sendKeys("9876543210");
        signup.click();

		


		
	}
	
	@Test
	public void Tag() {
		
		//enter the url
		ChromeDriver chromeDriver=new ChromeDriver();
		
		chromeDriver.get("https://www.guvi.in/register");
		//tag
		//username and email,password,mobile,signup all are same tagname
		
	}
}