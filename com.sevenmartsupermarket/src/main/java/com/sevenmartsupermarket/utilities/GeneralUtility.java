package com.sevenmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	
	public String get_Attributes(WebElement element,String attribute)
	{
		return element.getAttribute(attribute);
	}
	
	public String get_CssValue(WebElement element,String cssproperty)
	{
		return element.getCssValue(cssproperty);
	}
	
	public List<String> get_Text_Of_Elements(List<WebElement> elementsList)   //adding to string list
	{
		List<String> data=new ArrayList<String>();
		for(WebElement element :elementsList)
		{
			data.add(element.getText());
		}
		return data;
	}
	
	public static String getRandomName()
	{
		Faker faker=new Faker();
		return faker.name().firstName();
	}

}
