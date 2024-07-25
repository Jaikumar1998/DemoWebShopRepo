package demowebshop.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import demowebshop.generic.fileutility.ExcelUtility;

public class ShoppingCartPage extends ExcelUtility {
	
	WebDriver driver;
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText = "Build your own cheap computer")
	private WebElement textLink;
	
	@FindBy(id = "add-to-cart-button-72")
	private WebElement addToCartLink;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCartLink;
	
	
	@FindBy(xpath = "//a[@class='product-name']")
	private WebElement actTextLink;
	
	
	
	

	public WebElement getTextLink() {
		return textLink;
	}

	public WebElement getAddToCartLink() {
		return addToCartLink;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}
	
	public WebElement getActTextLink() {
		return actTextLink;
	}
	
	
	
	public void shoppingCartPage() throws EncryptedDocumentException, IOException {
		
		 textLink.click();
		 addToCartLink.click();
		 shoppingCartLink.click();
		
	}
	
	public void verifyProductisAdd() {
	
		Assert.assertEquals(actTextLink, textLink);
		System.out.println("Product is Sucessfully Add to Cart");
	}


}
