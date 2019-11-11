package com.stadiumgood.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.stadiumgoods.com.testrunner.RunCucumberTest;

public class jordanpage extends RunCucumberTest{
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='sort-by']")
	WebElement sort;
	
	public jordanpage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void selectPriceHightoLow(){
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(sort));
		sort.click();
		Select sel = new Select(sort);
		sel.selectByIndex(2);
	}

}
