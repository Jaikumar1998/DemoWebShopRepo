package demowebshop.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCheckOutPage {
	
	WebDriver driver =null;
	public ProductCheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(id = "termsofservice")
	private WebElement TandSCheckBox;
	
	@FindBy(id = "checkout")
	private WebElement checkOutLink;
	
	@FindBy(xpath ="(//input[@class='button-1 new-address-next-step-button'])[1]")
	private WebElement contBillingAddBtn;
	
	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	private WebElement contShippingAddBtn;
	
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	private WebElement contShippingMethBtn;
	
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	private WebElement contPaymentBtn;
	
	@FindBy(xpath ="////input[@onclick='PaymentInfo.save()']")
	private WebElement contPaymentInfoBtn;
	
	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
	private WebElement contConfirmOrderBtn;
	
	@FindBy(xpath = "//input[@class='button-2 order-completed-continue-button']")
	private WebElement contThankYouBtn;

	
	
	

	public WebElement getTandSCheckBox() {
		return TandSCheckBox;
	}

	public WebElement getCheckOutLink() {
		return checkOutLink;
	}

	public WebElement getContBillingAddBtn() {
		return contBillingAddBtn;
	}

	public WebElement getContShippingAddBtn() {
		return contShippingAddBtn;
	}

	public WebElement getContShippingMethBtn() {
		return contShippingMethBtn;
	}

	public WebElement getContPaymentBtn() {
		return contPaymentBtn;
	}

	public WebElement getContPaymentInfoBtn() {
		return contPaymentInfoBtn;
	}

	public WebElement getContConfirmOrderBtn() {
		return contConfirmOrderBtn;
	}
	
	public WebElement getContThankYouBtn() {
		return contThankYouBtn;
	}
	
	public void productCheckOutPage() {
		TandSCheckBox.click();
		checkOutLink.click();
		contBillingAddBtn.click();
		contShippingAddBtn.click();
		contShippingMethBtn.click();
		contPaymentBtn.click();
		contPaymentInfoBtn.click();
		contConfirmOrderBtn.click();
		contThankYouBtn.click();
	}

}
