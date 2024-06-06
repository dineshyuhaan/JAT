package mavenproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuappNestedFrame {
public void test1() throws InterruptedException {
		
		//enter on the url
	ChromeDriver chromeDriver=new ChromeDriver();
		chromeDriver.get("https://the-internet.herokuapp.com/nested_frames");
		
		//switch to top frame
		chromeDriver.switchTo().frame("frame-top");
		
		//verify there are three frames
		List<WebElement> frames = chromeDriver.findElements(By.xpath("//frame"));
	        if (frames.size() == 3) {
	            System.out.println("There are three frames on the page");
	        } else {
	            System.out.println("The number of frames is not three");
	        }
	        
	        // left frame
	        chromeDriver.switchTo().frame("frame-left");
	        
	        //left frame has a text "LEFT"
	        WebElement left = chromeDriver.findElement(By.xpath("//body[contains(text(), 'LEFT')]"));
	        if (left.getText().contains("LEFT")) {
	            System.out.println("Left frame has the text LEFT");
	        } else {
	            System.out.println("Left frame does not have the text LEFT");
	        }
	        
	        // top frame
	        chromeDriver.switchTo().parentFrame();
	        
	        // middle frame
	        chromeDriver.switchTo().frame("frame-middle");
	        
	        // middle frame has a text "MIDDLE"
	        WebElement middle = chromeDriver.findElement(By.xpath("//div[@id='content']"));
	        if (middle.getText().contains("MIDDLE")) {
	            System.out.println("Middle frame has the text MIDDLE");
	        } else {
	            System.out.println("Middle frame does not have the text MIDDLE");
	        }
	        
	        //top frame
	        chromeDriver.switchTo().parentFrame();
	        
	        // right frame
	        chromeDriver.switchTo().frame("frame-right");
	        
	        //  right frame has a text "MIDDLE"
	        WebElement right = chromeDriver.findElement(By.xpath("//body[contains(text(), 'RIGHT')]"));
	        if (right.getText().contains("RIGHT")) {
	            System.out.println("Right frame has the text RIGHT");
	        } else {
	            System.out.println("Right frame does not have the text Right");
	        }
	        
	        // top frame
	        chromeDriver.switchTo().parentFrame();
	        
	        // default frame
	        chromeDriver.switchTo().defaultContent();
	        
	        // right frame
	        chromeDriver.switchTo().frame("frame-bottom");
	        
	        //  bottom frame has a text "MIDDLE"
	        WebElement bottom = chromeDriver.findElement(By.xpath("//body[contains(text(), 'BOTTOM')]"));
	        if (bottom.getText().contains("BOTTOM")) {
	            System.out.println("Bottom frame has the text BOTTOM");
	        } else {
	            System.out.println("Bottom frame does not have the text BOTTOM");
	        }
	        
	        // top frame
	        chromeDriver.switchTo().parentFrame();
	        //default frame
	        chromeDriver.switchTo().defaultContent();
	      	        
	        //verify page is frame
	        String url = "https://the-internet.herokuapp.com/nested_frames";
	        String pageUrl = chromeDriver.getCurrentUrl();
	        Thread.sleep(2000);
	        if(pageUrl.equals(url)) {
	        	System.out.println("we landed on correct page");
	        }
	        else {
	        	System.out.println("we wrongly landed. It is: " +pageUrl);
	        }
	}


}
