package mavenproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikiPedia {

	@Test
	public void test() throws InterruptedException {
//create a object for ChromeDriver	
		ChromeDriver chromeDriver = new ChromeDriver();
//enter the URL
		chromeDriver.get("https://www.wikipedia.org/");

//maximize the window
		chromeDriver.manage().window().maximize();

//Enter the search id from the inspect element
		By by = By.id("searchInput");
		WebElement element = chromeDriver.findElement(by);
//enter the search keywords
		element.sendKeys("Artificial Intelligence");
		element.sendKeys(Keys.ENTER);

//click the history options
		By historyId = By.xpath("//a[@href=\"#History\"]");
		WebElement element2 = chromeDriver.findElement(historyId);
		element2.click();
		Thread.sleep(1000);
//print the title of the page
		System.out.println(chromeDriver.getTitle());

//automatic google browser quit

		chromeDriver.quit();

	}

}
