package test;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.BaseClass;
import utils.ExcelUtils;


public class CheckoutAndPaymentProcessTest extends BaseClass {

	public  page.CheckoutAndPaymentProcess checkoutandpayment;
    ExcelUtils obj = new ExcelUtils();


	@Test
	public void checkoutLoginProcess() throws IOException{
		checkoutandpayment = new page.CheckoutAndPaymentProcess(driver);
		clickOnElement(checkoutandpayment.getCheckoutButton());
		explicitlyWait(10, checkoutandpayment.getCheckoutEmail());
		passInput(checkoutandpayment.getCheckoutEmail(), obj.excelUtils("Sheet1", 13, 0));
		passInput(checkoutandpayment.getCheckoutPassword(), obj.excelUtils("Sheet1", 13, 1));
		explicitlyWait(20, checkoutandpayment.getCheckoutSignin());
		clickOnElement(checkoutandpayment.getCheckoutSignin());
		implicitlyWait(15);
		Assert.assertTrue(true);
	}

	@Test
	public void paymentInformation() throws InterruptedException, IOException {
		checkoutandpayment = new page.CheckoutAndPaymentProcess(driver);
		sleep(10000);
		clickOnElement(checkoutandpayment.getContinueToGuest());
		explicitlyWait(10, checkoutandpayment.getSwitchToPickUp());
		sleep(4000);
		clickOnElement(checkoutandpayment.getSwitchToPickUp());
		passInput(checkoutandpayment.getPaymentFirstName(), obj.excelUtils("Sheet1", 17, 0));
		passInput(checkoutandpayment.getPaymentLastName(), obj.excelUtils("Sheet1", 17, 1));
		passInput(checkoutandpayment.getAddressLine(), obj.excelUtils("Sheet1", 17, 2));
		passInput(checkoutandpayment.getCity(), obj.excelUtils("Sheet1", 17, 3));
		selectOperation(checkoutandpayment.getState(), "RI");
		passInput(checkoutandpayment.getPostalCode(), "02842");
		clickOnElement(checkoutandpayment.getApply());
		Assert.assertTrue(true);
		sleep(3000);
	}

}
