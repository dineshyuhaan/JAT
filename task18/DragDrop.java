package mavenproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	@Test
	public void test1() throws InterruptedException{
		//enter the url
		ChromeDriver chromeDriver=new ChromeDriver();
		chromeDriver.get("https://jqueryui.com/droppable/");
		
		//frame switchto()
		chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		// drag and target
		WebElement source = chromeDriver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = chromeDriver.findElement(By.xpath("//div[@id='droppable']"));
		
		//perform a drap and drop
		Actions action = new Actions(chromeDriver);
		action.dragAndDrop(source, target).perform();
		
		//verify the background color
       		String backGround = target.getCssValue("background-color");
        	System.out.println("Background color after drag and drop: " + backGround);
		Thread.sleep(2000);
        	//Verify the element change target
        	String targetText = target.getText();
        	if(targetText.equals("Dropped!")) {
            		System.out.println("Drag and drop perform was successful.");
        	}
        	else {
            		System.out.println("Drag and drop perform was failed.");

        	}
	}
}
