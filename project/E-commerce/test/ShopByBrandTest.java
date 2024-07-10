package test;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.ShopByBradns;
import utils.BaseClass;


public class ShopByBrandTest extends BaseClass {

	public  ShopByBradns shopBrands;

	@Test
	public void shopByBrands() throws InterruptedException {
		shopBrands = new ShopByBradns(driver);
		shopBrands.getMenuButtonBrands();
		clickOnElement(shopBrands.getMenuButtonBrands());
		shopBrands.getShopByBrands("Brands");
		shopBrands.getShopByBrandName("Sony");
		explicitlyWait(10, shopBrands.getCameraButton());
		clickOnElement(shopBrands.getCameraButton());
		shopBrands.getCameraAccessories();
		sleep(2000);
		clickOnElement(shopBrands.getCameraAccessories());
		shopBrands.getCameraMinimumRange();
		passInput(shopBrands.getCameraMinimumRange(), "1500");
		shopBrands.getCameramaximumRange();
		passInput(shopBrands.getCameramaximumRange(), "3000");
		shopBrands.getSelectCameraRangeButton();
		clickOnElement(shopBrands.getSelectCameraRangeButton());
		shopBrands.getSelectCameraColor();
		clickOnElement(shopBrands.getSelectCameraColor());
		shopBrands.getSelectCameraFocus();
		clickOnElement(shopBrands.getSelectCameraFocus());
//		shopBrands.getSelectCameraCondition();
//		implicitlyWait(5);
//		clickOnElement(shopBrands.getSelectCameraCondition());
		shopBrands.getSelectCameraModelFamily();
		sleep(2000);
		implicitlyWait(5);
		clickOnElement(shopBrands.getSelectCameraModelFamily());
		shopBrands.getSelectCustomerRatings();
		clickOnElement(shopBrands.getSelectCustomerRatings());
		shopBrands.getSelectCamera();
		clickOnElement(shopBrands.getSelectCamera());
		scrollDownorUp("window.scrollBy(0,600)");
		explicitlyWait(10, shopBrands.getSelectCameraAddToCart());
		clickOnElement(shopBrands.getSelectCameraAddToCart());
		explicitlyWait(10, shopBrands.getCameraGoToCart());
		clickOnElement(shopBrands.getCameraGoToCart());
		sleep(3000);
		pageSource("Sony - Alpha a7 III Mirrorless [Video]", "Shop by brand Product has been added successfully",
				"Shop by brand Product not added to the cart");
		Assert.assertTrue(true);
	}


}
