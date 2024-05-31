package mavenproject;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {

	@Test
	public void test() {
		// navigate to chrome browser page
		ChromeDriver chromeDriver = new ChromeDriver();
//enter the web site
		chromeDriver.get("https://www.demoblaze.com");

		String results = chromeDriver.getTitle();
//correct or not correct website use if and else stastement
		if (results.equals("STORE")) {
			System.out.println("page landed on correct website");
		} else {
			System.out.println("page not landed on correct website");
		}
//maximize page
		chromeDriver.manage().window().maximize();
//quit page
		chromeDriver.quit();

	}
}
