package com.stadiumgood.StepDef;

import org.stadiumgoods.com.testrunner.RunCucumberTest;

import com.relevantcodes.extentreports.LogStatus;
import com.stadiumgood.UtilClasses.ExcelSheetUtil;
import com.stadiumgood.api.EmployeeAPI;
import com.stadiumgood.api.pokemonAPI;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class APIValidation extends RunCucumberTest{
	
	@Given("^Excel Data Pull$")
	public void Excel_Data_Pull(){
		logger = report.startTest("API Validation");
		try{		  
		  ExcelSheetUtil excel = new ExcelSheetUtil();
		  data = excel.getsheetData("pokeapi");	
		  logger.log(LogStatus.PASS, "Excel Data Pull");
		}catch(Throwable t){
		  logger.log(LogStatus.FAIL, "Excel Data Pull EXCEPTION :: "+t.getLocalizedMessage());
		}
	  }

	@When("^Pokemon API data Pull and Validate API$")
	public void Pokemon_API_data_Pull_and_Validate_API() {
		try{
			pokemonAPI pokemon;
			for(int index = 0; index<data.size(); index++){
				pokemon = new pokemonAPI(data.get(index).get("pokemon_name"));
				compare(data.get(index).get("abilities.ability.name") , pokemon.getnameValue());
				compare(data.get(index).get("abilities.ability.url"), pokemon.geturlValue());
				compare(data.get(index).get("abilities.is_hidden"), pokemon.gethiddenValueVariable());
				compare(data.get(index).get("abilities.slot"), pokemon.getslotValueVariable()); 
			}
			data.remove(data);	
			logger.log(LogStatus.PASS, "Pokemon API data Pull and Validate API");
		}catch(Throwable t){
			logger.log(LogStatus.FAIL, "Pokemon API data Pull and Validate API EXCEPTION :: "+t.getLocalizedMessage());
		}
	}

	@Given("^Excel Data is Pulled as input for employee creation$")
	public void Excel_Data_is_Pulled_as_input_for_employee_creation() {
		try{
			ExcelSheetUtil excel = new ExcelSheetUtil();
			data = excel.getsheetData("Users");
			logger.log(LogStatus.PASS, "Excel Data is Pulled as input for employee creation");
		}catch(Throwable t){
			logger.log(LogStatus.FAIL, "Excel Data is Pulled as input for employee creation EXCEPTION :: "+t.getLocalizedMessage());
		}
	}

	@When("^Employee data is created using entity creation API and validated against GET API$")
	public void Employee_data_is_created_using_entity_creation_API_and_validated_against_GET_API(){
		try{
			EmployeeAPI emp;
			for(int i = 0; i<data.size(); i++){
				emp = new EmployeeAPI(data.get(i).get("name"), data.get(i).get("salary"), data.get(i).get("age"));
				compare(data.get(i).get("name"), emp.getName());
				compare(data.get(i).get("salary"), emp.getSalary());
				compare(data.get(i).get("age"), emp.getAge());			
			}
			data.remove(data);
			logger.log(LogStatus.PASS, "Employee data is created using entity creation API and validated against GET API");
		}catch(Throwable t){
			logger.log(LogStatus.FAIL, "Employee data is created using entity creation API and validated against GET API EXCEPTION :: "+t.getLocalizedMessage());
		}
		
	}
		
		
}
