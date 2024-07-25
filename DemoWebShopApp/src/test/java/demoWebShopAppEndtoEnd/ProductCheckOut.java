package demoWebShopAppEndtoEnd;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import demowebshop.BaseClass.BassClass;
import demowebshop.ObjectRepository.ProductCheckOutPage;
import demowebshop.ObjectRepository.ShoppingCartPage;
import demowebshop.ObjectRepository.WishListPage;
import demowebshop.generic.fileutility.ExcelUtility;

public class ProductCheckOut extends BassClass{
	
	ExcelUtility eu = new ExcelUtility();
	
	@Test
	public void shoppingCart() throws EncryptedDocumentException, IOException {
		String ProductName = eu.getDataFromExcel("DWS", 1, 0);
		driver.findElement(By.id("small-searchterms")).sendKeys(ProductName);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();//path,each test one class//assertion.reprter/log
		
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		scp.shoppingCartPage();
		
		//Verifying Product add to Cart
		scp.verifyProductisAdd();
		}
	
	@Test
	public void wishListTest() throws EncryptedDocumentException, IOException {
		String ProductName = eu.getDataFromExcel("DWS", 4, 0);
		driver.findElement(By.id("small-searchterms")).sendKeys(ProductName);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
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
		
		ProductCheckOutPage pcop = new ProductCheckOutPage(driver);
		pcop.productCheckOutPage();
		
	}

}
