package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.constants.DataProviderClass;
import com.sevenmartsupermarket.pages.AdminUserPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.GeneralUtility;



public class AdminUserTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	AdminUserPage adminuserpage;
	ExcelReader excelreader = new ExcelReader();
	
	@Test
	public void verifyCreateAdmin()
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		loginpage.login();
		homepage.clickOnAdminUser();
		adminuserpage.createAdmin("AngelTiff", "ang321", "Admin");
		String adminuser = GeneralUtility.getRandomName();
		adminuserpage.createAdmin(adminuser, adminuser, adminuser);
		System.out.println("print :"+adminuser);
	
	}
	
	@Test
	public void verifyColorOfNewButton()
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminuserpage =new AdminUserPage(driver);
		loginpage.login();
		homepage.clickOnAdminUser();
		String color = adminuserpage.getColorOfNewButton();
		System.out.println("print:"+color);
		Assert.assertEquals(color, "rgba(255, 255, 255, 1)");	
	}
	
	@Test(dataProvider = "adminUser", dataProviderClass = DataProviderClass.class)
	public void verifydataProviderAdminUser(String username, String password, String usertype)
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		loginpage.login();
		homepage.clickOnAdminUser();
		String admin = username+""+GeneralUtility.getRandomName();
		adminuserpage.createAdmin(admin, password, usertype);
		
	}
	
}
