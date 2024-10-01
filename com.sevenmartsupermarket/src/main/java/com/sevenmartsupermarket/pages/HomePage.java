package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='user-panel mt-3 pb-3 mb-3 d-flex']//div//a")
	private WebElement profileName;
	
	@FindBy(xpath = "(//div[@class='inner'])[1]//following-sibling::a")
	private WebElement adminUserMenu;
	@FindBy(xpath = "(//div[@class='inner'])[3]//following-sibling::a")
	private WebElement categoryMenu;
	@FindBy(xpath = "(//div[@class='inner'])[4]//following-sibling::a")
	private WebElement subCategoryMenu;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProfileName()
	{
		return profileName.getText();
	}
	
	public void clickOnAdminUser()
	{
		adminUserMenu.click();
	}
	
	public void clickOnCategoryMenu()
	{
		categoryMenu.click();
	}
	
	public SubCategoryPage clickOnSubCategoryMenu()
	{
		subCategoryMenu.click();
		return new SubCategoryPage(driver);
	}
	
}
