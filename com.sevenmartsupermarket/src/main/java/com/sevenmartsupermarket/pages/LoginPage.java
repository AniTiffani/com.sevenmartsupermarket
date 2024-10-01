package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	WaitUtility wait = new WaitUtility();
	Properties properties = new Properties();

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWordField;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement signInButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try 
		{
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		} 
		catch (Exception e)
		{
		 e.printStackTrace();   
		}
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String passWord) {
		passWordField.sendKeys(passWord);
	}

	public void clickOnSignInButton() {
		wait.waitForClickableWebDriver(driver, signInButton, 10);  
		signInButton.click();
	}

	public HomePage login(String userName, String passWord) {
		enterUserName(userName);
		enterPassword(passWord);
		clickOnSignInButton();
		return new HomePage(driver);
	}
	public HomePage login()
	{
		String userName = properties.getProperty("username");
		String passWord = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(passWord);
		clickOnSignInButton();
		return new HomePage(driver);
	}
}
