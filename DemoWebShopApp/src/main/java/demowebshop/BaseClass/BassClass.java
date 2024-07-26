package demowebshop.BaseClass;

import java.io.IOException;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import demowebshop.ObjectRepository.LogOutPage;
import demowebshop.ObjectRepository.UserLoginpage;
import demowebshop.generic.fileutility.PropertyFileUtility;
import demowebshop.generic.webdriverutility.UtilityClassObject;

public class BassClass {
	public WebDriver driver = null;
	public  static WebDriver sdriver = null;
	//user reporter.log in place of sysout
	PropertyFileUtility pfu = new PropertyFileUtility();
	
	
	
	@BeforeClass
	public void congBC() throws IOException {
		System.out.println("Execution of ConfBC");
		String Browser =pfu.getDataFromPropertyFile("browser");
		
		if(Browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
	    else if(Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
	    else if(Browser.equals("edge")) {
			driver = new EdgeDriver();
		}
	    else {
			driver = new  ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		
	}
	
	
	@BeforeMethod
	public void confBM() throws IOException {
		System.out.println("Execution of congAM");
		String Url = pfu.getDataFromPropertyFile("url");
		String Email = pfu.getDataFromPropertyFile("email");
		String Password = pfu.getDataFromPropertyFile("password");
		
		driver.get(Url);
		UserLoginpage ulp = new UserLoginpage(driver);		
		ulp.loginPage(Email, Password);
	}
	
	@AfterMethod
	public void congAM() {
		System.out.println("Execution of congAM");
		LogOutPage lop = new LogOutPage(driver);
		lop.logoutPage();
	}

	@AfterClass
	public void confAC() {
		System.out.println("Execution of ConfAC");
		driver.close();
	}
}
