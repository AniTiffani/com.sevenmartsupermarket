package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='col-sm-12']//a[1]")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passWordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeField;
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
	private WebElement saveButton;
	
	public AdminUserPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickNewButton()
	{
		newButton.click();
	}
	
	public void enterUserName(String userName)
	{
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String passWord) 
	{
		passWordField.sendKeys(passWord);
	}
	
	public void selectUserType(String usertype)
	{
		Select select = new Select(userTypeField);
		select.selectByIndex(2);
	}
	
	public void saveButton()
	{
		saveButton.click();
	}
	
	public void createAdmin(String userName, String passWord, String usertype)
	{
		clickNewButton();
		enterUserName(userName);
		enterPassword(passWord);
		selectUserType(usertype);
		saveButton();
	}
	
	public String getColorOfNewButton()
	{
		return newButton.getCssValue("color");
	}
	
	

}
