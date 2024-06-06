package mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuviSelenium {
	//signIn page
	public void signIn(){
	//enter and navigate url
	ChromeDriver chromeDriver=new ChromeDriver();
	WebElement signIn = chromeDriver.findElement(By.xpath("//a[@href=\"/register/\"]"));	
	//signIn page
	WebElement name = chromeDriver.findElement(By.xpath("//input[@id='name']"));
	WebElement email = chromeDriver.findElement(By.xpath("//input[@id='email']"));
	WebElement password = chromeDriver.findElement(By.xpath("//input[@id='password']"));
	WebElement number = chromeDriver.findElement(By.xpath("//input[@id='mobileNumber']"));
	WebElement signup = chromeDriver.findElement(By.xpath("//a[@id='signup-btn']"));
	    name.sendKeys("dinesh");
    	email.sendKeys("din12@gmail.com");
        password.sendKeys("dn@14");
        number.sendKeys("8796541230");
        signup.click();
        
        String title = "GUVI | Sign Up";
        //verify the page
        if(chromeDriver.getTitle().equals(title)) {
            System.out.println(" register successfully");
        }
        else {
            System.out.println(" register is failed");
        }
	
	}
	//login
	public void login() {
		
		//enter and navigate  url
		ChromeDriver chromeDriver=new ChromeDriver();
		chromeDriver.get("https://www.guvi.in");
		
		//login page
		WebElement login = chromeDriver.findElement(By.xpath("//a[@href=\"/sign-in/\"]"));
		login.click();
		
		//login Xpath
		WebElement email = chromeDriver.findElement(By.xpath("//input[@id='email']"));
		WebElement password = chromeDriver.findElement(By.xpath("//input[@id='password']"));
		WebElement submit = chromeDriver.findElement(By.xpath("//a[@id='login-btn']"));
		email.sendKeys("din12@gmail.com");
        password.sendKeys("dn@14");
        submit.click();
        
        String titleLogin = "GUVI | Login";
        //verify the page
        if(chromeDriver.getTitle().equals(titleLogin)) {
            System.out.println("login page successfully");
        }
        else {
            System.out.println("login page failed");
        }
	}
}
