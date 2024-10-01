package com.sevenmartsupermarket.constants;

import org.testng.annotations.DataProvider;

import com.sevenmartsupermarket.utilities.ExcelReader;

public class DataProviderClass {
	ExcelReader excelreader = new ExcelReader();
	
	@DataProvider(name = "login")
	public Object[][] verifyLogin()
	{
		excelreader.setExcelFile("Login", "Sheet1");
		return excelreader.getMultidimentionalData(1,2);  
	}
	
	@DataProvider(name= "adminUser")
	public Object [][] verifyAdminUser()
	{
		excelreader.setExcelFile("Login", "Sheet1");
		return excelreader.getMultidimentionalData(1, 3);
	}

}
