package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.PageUtility;

public class SubCategoryPage {
	WebDriver driver;
	PageUtility pageutility;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement selectDropDownButton;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subCategoryField;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFile;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement addSubCategory;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement selectDropDown;
	@FindBy(xpath = "//input[@placeholder='Sub Category']")
	private WebElement subCategorySearchField;
	@FindBy (xpath = "//button[@name='Search']")
	private WebElement searchSubmitButton;
	@FindBy (xpath = "//h1[@class='m-0 text-dark']")
	private WebElement listSubCategory;
	
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss']//i)[1]")
	private WebElement deleteButton;
	
	@FindBy (xpath = "(//i[@class='fas fa-edit'])[2]")
	private WebElement editButton;
	@FindBy (xpath = "//h1[@class='m-0 text-dark']")
	private WebElement editCategory;
	
	public SubCategoryPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	public SubCategoryPage clickNewButton()
	{
		newButton.click();
		return this;
	}
	
	public SubCategoryPage selectDropDown()
	{
		Select select = new Select(selectDropDownButton);
		select.selectByIndex(3);
		return this;
	}
	
	public SubCategoryPage enterTheSubCategory(String subCategory)
	{
		subCategoryField.sendKeys(subCategory);
		return this;
	}
	
	/*public SubCategoryPage uploadFile()
	{
		chooseFile.sendKeys(Constants.IMAGE_FILE_PATH);
		return this;
	}*/
	
	public SubCategoryPage clickSaveButton()
	{
		pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(saveButton);
		return this;
	}
	
	public SubCategoryPage getAddSubCategory()
	{
		System.out.println(addSubCategory.getText());
		return this;
	}
	
	public SubCategoryPage createNewSubCategory(String subCategory)
	{
		return this.clickNewButton()
		.selectDropDown()
		.enterTheSubCategory(subCategory)
		//.uploadFile()
		.clickSaveButton();
	}
	
	public void clickSearchButton()
	{
		searchButton.click();
	}
	
	public void selectSearchDropDown()
	{
		Select select = new Select(selectDropDown);
		select.selectByIndex(2);
	}
	
	public void enterSubCategory(String subCategory)
	{
		subCategorySearchField.sendKeys(subCategory);
	}
	
	public void submitSearchButton()
	{
		searchSubmitButton.click();
	}
	
	public String getListSubCategory()
	{
		return listSubCategory.getText();
	}
	
	public void createSearchListSubCategories(String subCategory)
	{
		clickSearchButton();
		selectSearchDropDown();
		enterSubCategory(subCategory);
		submitSearchButton();
	}
	
	public void clickDeleteButton()
	{
		pageutility =new PageUtility(driver);
		deleteButton.click();
		pageutility.acceptAlert();
	}
	
	public void clickEditButton()
	{
		editButton.click();
	}
	
	public String getEditCategory()
	{
		return editCategory.getText();
	}

}
