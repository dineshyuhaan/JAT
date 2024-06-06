package mavenproject;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HerokuappWindow {
	public void test() throws InterruptedException {
		
		//enter on the url
		ChromeDriver chromeDriver=new ChromeDriver();
		chromeDriver.get("https://the-internet.herokuapp.com/windows");
		
		//click it page
		WebElement clickit = chromeDriver.findElement(By.xpath("//a[@href='/windows/new']"));
		clickit.click();
		
		//switch to new window
		String Window = chromeDriver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		//get handle to new window
		Set<String> windows = chromeDriver.getWindowHandles();
		String newWindow = windows.stream().filter(handle -> !handle.equals(Window)).findFirst().orElseThrow();
		
		//switch to new window
		chromeDriver.switchTo().window(newWindow);
		
		// xpath for new window
		WebElement newText = chromeDriver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
		Thread.sleep(3000);
		//verify we landed to new window
		if(newText.getText().equals("New Window")) {
			System.out.println("'New window' text is present");
		} else {
			System.out.println("'New window' text is not present");
		}
		
		//close window
		chromeDriver.close();
		
		//navigate window
		chromeDriver.switchTo().window(oldWindow);
		
		//verify  window is active
		if(chromeDriver.getWindowHandle().equals(oldWindow)) {
			System.out.println("Back to the window");
		} else {
			System.out.println(" window was not in active");
		}
		
		
	}

}
