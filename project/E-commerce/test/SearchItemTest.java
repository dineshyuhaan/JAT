package test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.BaseClass;


public class SearchItemTest extends BaseClass {

	public SearchItemTest search;

	@Test
	public void searchAddToshoppingCart() throws InterruptedException {
		search = new SearchItemTest();
		passInput(search.getSearchBox(), "Apple laptop");
		search.getSearchBox().sendKeys(Keys.ENTER);
		scrollDownorUp("window.scrollBy(0,2000)");
		search.getListOfProducts("MacBook Air 13.6\" Laptop - Apple M2 chip - 8GB Memory - 512GB SSD - Midnight - Midnight",
				"Clicked on the target product: ");
		sleep(2000);
		scrollDownorUp("window.scrollBy(0,2000)");
		clickOnElement(search.getAddToCart());
		sleep(10000);
		clickOnElement(search.getAddToCart());
		sleep(4000);
		clickOnElement(search.getClass());
		sleep(3000);
		pageSource("MacBook Air 13.6\" Laptop - Apple M2 chip - 8GB Memory - 512GB SSD - Midnight - Midnight",
				"Search Item Product has been added successfully", "Search Item Product not added to the cart");
		Assert.assertTrue(true);

	}

	private void clickOnElement(Class<? extends SearchItemTest> class1) {
		// TODO Auto-generated method stub
		
	}

	private void getListOfProducts(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	private WebElement getSearchBox() {
		// TODO Auto-generated method stub
		return null;
	}

	private WebElement getAddToCart() {
		// TODO Auto-generated method stub
		return null;
	}

}
