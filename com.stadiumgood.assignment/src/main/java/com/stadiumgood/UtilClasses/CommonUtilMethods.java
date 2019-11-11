//package com.stadiumgood.UtilClasses;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
//
//import com.stadiumgood.Driver.Driver;
//
//public class CommonUtilMethods extends Driver {
//	
//	public void assetionText(String actual, String expected, String message) {
//		Assert.assertEquals(actual, expected, message);
//		System.out.println(message);
//	
//	}
//	
//	public void mouseHoverOver(WebElement element) {
//		Actions builder = new Actions(driver);
//		//builder.moveToElement(element).build().perform();
//		builder.moveToElement(element).click().build().perform();
//		
//	}
//	
//	public void onClickFilter(String text) {
//		//driver.findElement(By.xpath(xpathExpression))
//	}
//
//}
