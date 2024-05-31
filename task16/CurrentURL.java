package mavenproject;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CurrentURL {
	@Test
	public void test1() {
		//navigate firefox page
		FirefoxDriver firefoxDriver=new FirefoxDriver();
		firefoxDriver.get("https://www.google.com");
		//current url page
		String url=firefoxDriver.getCurrentUrl();
		
		//reload page 
		firefoxDriver.navigate().to("https://www.gooogle.com");
		//maximize window page
		
		firefoxDriver.manage().window().maximize();
		
	//quit page
		
		firefoxDriver.quit();
	//print page	
		System.out.println(url);
	
	}
}
