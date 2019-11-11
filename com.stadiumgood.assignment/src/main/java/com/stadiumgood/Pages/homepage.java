package com.stadiumgood.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.stadiumgoods.com.testrunner.RunCucumberTest;

public class homepage extends RunCucumberTest{
	
	@FindBy(xpath = "//*[@id='x-mark-icon']")
	WebElement x;
	
	@FindBy(xpath = "//div[@class='header-row-secondary']/.//li[starts-with(@class,'level0')]")    
	List<WebElement> allElements;
	
	@FindBy(xpath = "//a[text()='Jordan']")
	WebElement Jordan;
	
	public homepage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickX(){
		x.click();
	}
	
	public int getnotabs(){
		return allElements.size();
	}
	
	public jordanpage navigatetoJordan(){
		Jordan.click();
		return new jordanpage(driver);
	}

}
