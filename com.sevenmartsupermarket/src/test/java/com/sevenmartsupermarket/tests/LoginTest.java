package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.constants.DataProviderClass;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test
	public void verifyAdminLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login("Akhil", "User123");
		String expectedProfileName = "Akhil";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(expectedProfileName, actualProfileName);
	}
	
	@Test(dataProvider = "login",dataProviderClass = DataProviderClass.class)
	public void verifyDataProviderLogin(String userName, String passWord)
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
	}
}
