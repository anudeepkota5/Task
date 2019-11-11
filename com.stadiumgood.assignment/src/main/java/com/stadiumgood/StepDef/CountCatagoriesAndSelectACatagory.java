package com.stadiumgood.StepDef;

import org.stadiumgoods.com.testrunner.RunCucumberTest;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.stadiumgood.Pages.homepage;
import com.stadiumgood.Pages.jordanpage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CountCatagoriesAndSelectACatagory extends RunCucumberTest {
	
	homepage home;
	jordanpage jordan;
	
	@Given("^User 'logins' into the application with propert credentials$")
	public void user_logins_into_the_application_with_propert_credentials() {
		logger = report.startTest("CountCatagoriesAndSelectACatagory");
		try{
			compare(getTitle(), "Air Jordans | Stadium Goods");
			logger.log(LogStatus.PASS, "User 'logins' into the application with propert credentials");
		}catch(Throwable t){
			  logger.log(LogStatus.FAIL, "User 'logins' into the application with propert credentials EXCEPTION :: "+t.getLocalizedMessage());
			}
		
	}

	@Then("^User 'Counts the number' of catagories in the header$")
	public void user_Counts_the_number_of_catagories_in_the_header() {
		try{
			home = new homepage();
			home.clickX();		
			System.out.println("Number of Catagories are present in the Header: " + home.getnotabs());
			Assert.assertEquals(home.getnotabs(), 10);
			logger.log(LogStatus.PASS, "User 'Counts the number' of catagories in the header");
		}catch(Throwable t){
			  logger.log(LogStatus.FAIL, "User 'Counts the number' of catagories in the header EXCEPTION :: "+t.getLocalizedMessage());
		}
	}

	@Given("^User Selects 'Jordan'$")
	public void user_Selects_Jordan() {
		try{
			jordan = home.navigatetoJordan();	
			logger.log(LogStatus.PASS, "User Selects 'Jordan'");
		}catch(Throwable t){
			  logger.log(LogStatus.FAIL, "User Selects 'Jordan' EXCEPTION :: "+t.getLocalizedMessage());
		}
	}

	@Then("^User 'Sort By' low to high$")
	public void user_Sort_By_low_to_high() {
		try{
			Thread.sleep(2000);
			Thread.sleep(2000);
			jordan.selectPriceHightoLow();
			logger.log(LogStatus.PASS, "User 'Sort By' low to high");
		}catch(Throwable t){
			  logger.log(LogStatus.FAIL, "User 'Sort By' low to high EXCEPTION :: "+t.getLocalizedMessage());
		}
	}
}
