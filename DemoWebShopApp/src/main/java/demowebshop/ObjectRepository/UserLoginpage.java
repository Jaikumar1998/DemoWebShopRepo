package demowebshop.ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demowebshop.generic.webdriverutility.WebDriverUtility;

public class UserLoginpage extends WebDriverUtility{
	
	WebDriver driver;
	public UserLoginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(id = "Email")
	private WebElement emailEdit;
	
	@FindBy(id = "Password")
	private WebElement passwordedit;
	
	@FindBy(xpath = "//input[@value = 'Log in']")
	private WebElement loginBtn;
	
	
	

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getEmailEdit() {
		return emailEdit;
	}

	public WebElement getPasswordedit() {
		return passwordedit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	} 
	
	public void loginPage(String email,String password) throws IOException {
		driver.manage().window().maximize();
		waitForPageToLoad(driver);
		
		loginLink.click();
		emailEdit.sendKeys(email);
		passwordedit.sendKeys(password);
		loginBtn.click();
		
	}
}