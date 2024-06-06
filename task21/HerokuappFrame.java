package mavenproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HerokuappFrame {
public void frame() {
		
		//enter on the url
	ChromeDriver chromeDriver=new ChromeDriver();
		chromeDriver.get("https://the-internet.herokuapp.com/iframe");
		
		//herokuapp frame xpath
		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));
		
		// frame inside tag "p"
		WebElement p = chromeDriver.findElement(By.id("tinymce"));
		
		//java script inside "p" tag send to "hello people"
		JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        	js.executeScript("arguments[0].innerText = 'Hello People';", p);
        
		//verify page
        	String name = p.getText();
        	System.out.println(name);	
        
		}


}
