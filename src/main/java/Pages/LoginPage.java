package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Helper;

public class LoginPage extends Helper{
	
	// web element
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	// constructor
	// equalize driver instances --> base class driver and pom class driver
	public LoginPage(WebDriver driver){ // driver --> base class
		this.driver = driver; // pom class driver = base class driver
		PageFactory.initElements(driver,this);
	}
	
	public void Login(String username, String password) {
		emailTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		submit.click();
	}
	

}
