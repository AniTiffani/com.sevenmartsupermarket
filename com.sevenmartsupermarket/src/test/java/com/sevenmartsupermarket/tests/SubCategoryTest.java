package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.SubCategoryPage;
import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class SubCategoryTest extends Base{
	
	LoginPage loginpage;
	HomePage homepage;
	SubCategoryPage subcategorypage;
	PageUtility pageutility;
	
	@Test(groups = "Sanity")
	public void verifyAddSubCategory()
	{
		loginpage = new LoginPage(driver);
		homepage=loginpage.login();
		subcategorypage = homepage.clickOnSubCategoryMenu();
		String subCategory = GeneralUtility.getRandomName();
		subcategorypage.createNewSubCategory(subCategory);
		Assert.assertEquals(subcategorypage.getAddSubCategory(), "Add Sub Category");
	}
	
	@Test(groups={"smoke","regression"})
	public void verifySearchListSubCategories()
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategoryMenu();
		subcategorypage.createSearchListSubCategories("Sharpner");
		Assert.assertEquals(subcategorypage.getListSubCategory(), "List Sub Categories");
	}
	
	@Test
	public void verifyDeleteButton()
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategoryMenu();
		subcategorypage.clickDeleteButton();
		Assert.assertEquals(subcategorypage.getListSubCategory(), "List Sub Categories");
		
	}
	
	@Test
	public void verifyEditButton()
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategoryMenu();
		subcategorypage.clickEditButton();
		Assert.assertEquals(subcategorypage.getEditCategory(), "Edit Category");
	}

}
