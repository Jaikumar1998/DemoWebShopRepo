package demoWebShopAppEndtoEnd;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import demowebshop.BaseClass.BassClass;
import demowebshop.ObjectRepository.ProductCheckOutPage;
import demowebshop.ObjectRepository.ShoppingCartPage;
import demowebshop.ObjectRepository.WishListPage;
import demowebshop.generic.fileutility.ExcelUtility;
import demowebshop.generic.webdriverutility.UtilityClassObject;

@Listeners(demowebshop.listenertuility.ListenerImpClass.class)
public class ProductCheckOut extends BassClass{
	ShoppingCartPage scp = new ShoppingCartPage(driver);
	ExcelUtility eu = new ExcelUtility();
	public ExtentTest test;
	@Test
	public void shoppingCart() throws EncryptedDocumentException, IOException {
		String ProductName = eu.getDataFromExcel("DWS", 1, 0);
		driver.findElement(By.id("small-searchterms")).sendKeys(ProductName);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();//path,each test one class//assertion.reprter/log
		UtilityClassObject.getTest().log(Status.INFO,"navigate to the Shopping Cart");
		scp.shoppingCartPage();
		
		//Verifying Product add to Cart
		scp.verifyProductisAdd();
		}
	
	@Test
	public void wishListTest() throws EncryptedDocumentException, IOException {
		String ProductName = eu.getDataFromExcel("DWS", 4, 0);
		driver.findElement(By.id("small-searchterms")).sendKeys(ProductName);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the WishList");
		WishListPage wlp = new WishListPage(driver);
		String RecipitName = eu.getDataFromExcel("DWS", 5, 1);
		wlp.wishListPage(RecipitName);
		
		//Verifying Product add to wishList
		wlp.verifyProductisinWishList();
	}
	
	@Test
	public void productcheckOutEndTOEndTest() throws EncryptedDocumentException, IOException {
		 String ProductName = eu.getDataFromExcel("DWS", 1, 0);
		driver.findElement(By.id("small-searchterms")).sendKeys(ProductName);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		scp.getShoppingCartLink().click();
		UtilityClassObject.getTest().log(Status.INFO,"Navigation of Product CheckOut");
		ProductCheckOutPage pcop = new ProductCheckOutPage(driver);
		pcop.productCheckOutPage();
		
	}

}
