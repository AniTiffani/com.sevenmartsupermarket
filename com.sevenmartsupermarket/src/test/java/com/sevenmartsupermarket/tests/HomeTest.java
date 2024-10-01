package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.ExcelReader;

public class HomeTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();
	
	@Test
	public void verifyExcelDataRead()
		{
		excelreader.setExcelFile("Login", "AdminData"); 
		String excelUserName = excelreader.getCellData(1, 0);   
		System.out.println("Print Excel Data: "+excelUserName);
		}
	
	@Test
	public void verifyAdminClick()
	{
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage.clickOnAdminUser();
	}
	
	@Test(retryAnalyzer = com.sevenmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyProfileName()
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login("Akhil", "User123");
		System.out.println("print: "+homepage.getProfileName());
		//String profileName = homepage.getProfileName();
		//System.out.println(profileName);	
	}
	
	@Test
	public void verifyCategoryMenu()
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		homepage.clickOnCategoryMenu();
	}
	
	@Test
	public void verifySubCategoryMenu()
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		homepage.clickOnSubCategoryMenu();
	}
}
