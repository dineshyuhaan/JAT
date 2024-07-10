package test;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.BaseClass;


public class MenuValidationTest extends BaseClass {

	public  page.MenuValidation menu;

	@Test(priority = 0)
	public void topLinkVerification() {
		menu = new page.MenuValidation(driver);
		menu.getTopLinksVerification("Top menu item title for: ");
		Assert.assertTrue(true);
	}

	@Test(priority = 1)
	public void bottomLinkVerification() {
		menu = new page.MenuValidation(driver);
		menu.getBottomLinksVerification("Bottom menu items: ");
		Assert.assertTrue(true);
	}


}
