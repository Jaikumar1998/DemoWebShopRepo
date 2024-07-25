package demowebshop.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WishListPage {
	
	WebDriver driver = null;
	public WishListPage(WebDriver driver) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "$100 Physical Gift Card")
	private WebElement textLink;
	
	@FindBy(id = "giftcard_4_RecipientName")
	private WebElement reciptionNameEdit;
	
	@FindBy(id = "add-to-wishlist-button-4")
	private WebElement addTOWishListBtn;
	
	@FindBy(xpath ="//span[text() ='Wishlist']")
	private WebElement wishListLink;
	
	@FindBy(xpath = "//a[text() = '$100 Physical Gift Card']")
	private WebElement actwishListText;
	
	
	


	public WebElement getTextLink() {
		return textLink;
	}

	public WebElement getReciptionNameEdit() {
		return reciptionNameEdit;
	}

	public WebElement getAddTOWishListBtn() {
		return addTOWishListBtn;
	}

	public WebElement getWishListLink() {
		return wishListLink;
	}
	

	public WebElement getWishListText() {
		return actwishListText;
	}
	
	
	public void wishListPage(String RecipitName) {
		textLink.click();
		reciptionNameEdit.click();
		reciptionNameEdit.sendKeys(RecipitName);
		addTOWishListBtn.click();
		wishListLink.click();
			
	}
	
	public void verifyProductisinWishList() {
		Assert.assertEquals(actwishListText, textLink);
		System.out.println("Poduct is Sucessfully added to the WishList");
		
	}

}
