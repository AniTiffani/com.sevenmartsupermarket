package com.sevenmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenmartsupermarket.constants.Constants;

import com.sevenmartsupermarket.utilities.ScreenShotCapture;
import com.sevenmartsupermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	Properties properties = new Properties();
	ScreenShotCapture screenshotcapture = new ScreenShotCapture();

	public Base() {
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initialize(String browser, String url) {  
		if (browser.contains("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
	}
	
	@Parameters("browser") 
	@BeforeMethod(enabled = false, alwaysRun = true)
	public void initilizeBrowser(String browser) {
		
		String url = properties.getProperty("url");
		initialize(browser, url);
	} 
	
	@BeforeMethod(enabled = true, alwaysRun = true)
	public void initilizeBrowser() {
		String browser = properties.getProperty("browser"); 
		String url = properties.getProperty("url");
		initialize(browser, url);
	}
	
	@AfterMethod(alwaysRun = true)
	public void terminateBrowser(ITestResult itestresult)  
	{
		if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			
			screenshotcapture.takeScreenShot(driver, itestresult.getName());
		}
	
	}

}
