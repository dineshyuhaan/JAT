package mavenproject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumScript {

		@Test
		public void test1() throws IOException, InterruptedException {

			//enter on the  url
			ChromeDriver chromeDriver=new ChromeDriver();
			chromeDriver.get("https://phptravels.com/demo/");

			// xpath fields and send keys
			WebElement firstName = chromeDriver.findElement(By.xpath("//input[@name='first_name']"));
			WebElement lastName = chromeDriver.findElement(By.xpath("//input[@name='last_name']"));
			WebElement business = chromeDriver.findElement(By.xpath("//input[@name='business_name']"));
			WebElement email = chromeDriver.findElement(By.xpath("//input[@name='email']"));
			firstName.sendKeys("dinesh");
			lastName.sendKeys("yuhaan");
			business.sendKeys("business");
			email.sendKeys("dnyu@gmail.com");

			//sum verification
			WebElement number1 =chromeDriver.findElement(By.xpath("//span[@id='numb1']"));
			WebElement number2 =chromeDriver.findElement(By.xpath("//span[@id='numb2']"));
			int num1 = Integer.parseInt(number1.getText());
			int num2 = Integer.parseInt(number2.getText());
			int sum = num1 + num2;

			WebElement input = chromeDriver.findElement(By.xpath("//input[@id='number']"));
			input.sendKeys(String.valueOf(sum));
             Thread.sleep(1000);

			// locate submit xpath
			WebElement submit = chromeDriver.findElement(By.xpath("//button[@id='demo']"));
			submit.click();

			//verify the page submission 
	        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(15));
	        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Thank you!')]")));
	        if(success.getText().equals("Thanking you!")) {
	        	System.out.println(" submitted successfully ");
	        }
	        else {
	        	System.out.println(" Not submitted");
	        }

	        //take screenshot after page submission
	        TakesScreenshot ss = ((TakesScreenshot) chromeDriver);
	        File srcFile = ss.getScreenshotAs(OutputType.FILE);
	        File destFile = new File("S shot.png");
	        ImageIO.write(ImageIO.read(srcFile), "png", destFile);
	        System.out.println("Screenshot was taken and stored in this path: " +destFile.getAbsolutePath());

		}
}
