package mavenproject;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumJavaScript {
	@Test
	public void date() {
		
		//navigate ChromeDriver
		ChromeDriver chromeDriver=new ChromeDriver();	
		//enter on the url
		chromeDriver.get("https://jqueryui.com/datepicker/");
		//window maximize
		chromeDriver.manage().window().maximize();
		//frame switchTo
		chromeDriver.switchTo().frame(chromeDriver.findElement(By.className("demo-frame")));
		
		//date input
		WebElement dateInput = chromeDriver.findElement(By.xpath("//input[@id='datepicker']"));
		dateInput.click();
		
		// next month option click
		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(8));
		WebElement nextMonth = wait.until(ExpectedConditions.elementToBeClickable(chromeDriver.findElement(By.xpath("//a[@title='Next']"))));
		nextMonth.click();
		
		//22th date 
		WebElement date = wait.until(ExpectedConditions.elementToBeClickable(chromeDriver.findElement(By.xpath("//a[@data-date='22']"))));
		date.click();
		

		//selected date print
		String Date =date.getText();
		System.out.println("Selected Date: " +Date);
		
	}

}
