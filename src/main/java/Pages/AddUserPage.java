package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Helper;

public class AddUserPage extends Helper{
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameTextBox;
	
	@FindBy(xpath = "//input[@id='mobile']")
	private WebElement mobileTextBox;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath = "//input[@id='Male']")
	private WebElement genderRadioButton;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement dropdownCountry;
	
	@FindBy(xpath = "//button[@id='submit']")
	private WebElement submitButton;

	public AddUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillForm(String username, String mobile, String email, String password, String country) {
		usernameTextBox.sendKeys(username);
		mobileTextBox.sendKeys(mobile);
		emailTextBox.sendKeys(email);
		genderRadioButton.click();
		selectByVisibleTextFromDropdown(dropdownCountry, country);
		passwordTextBox.sendKeys(password);
		submitButton.click();
		acceptAlert();
	}

}
