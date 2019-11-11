package com.stadiumgood.api;

import org.json.JSONObject;
import org.testng.asserts.SoftAssert;

import com.stadiumgood.UtilClasses.ReadPropertyFile;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeeAPI{
	
	private String name;
	private String salary;
	private String age;
	
	public EmployeeAPI(String name, String salary, String age){
		try{
			  RestAssured.baseURI = ReadPropertyFile.get("employeeurl");
		      RequestSpecification httpRequest = RestAssured.given();
		      JSONObject requestParams = new JSONObject();
			  requestParams.put("name", name);
			  requestParams.put("salary", salary);
			  requestParams.put("age", age);
			  httpRequest.header("Content-Type", "application/json");
			  httpRequest.body(requestParams.toString());
			  String requestBody = requestParams.toString();
			  Response createResponse = httpRequest.post("/create");
			  String createResponseBody = createResponse.getBody().asString();
			  String employee_name = "\"employee_name\":\"" + name + "\"";
			  String employee_salary = "\"employee_salary\":\"" + salary + "\"";
			  String employee_age = "\"employee_age\":\"" + age + "\"";

				// Validation for created Entity
			  int statusCode = createResponse.getStatusCode();
			  String statusCodeConverted = String.valueOf(statusCode);
			  boolean isCodeMatching = statusCodeConverted.equals("200");
			  boolean isPresent = createResponseBody.indexOf("\"id\":\"") != -1 ? true : false;
		      
			  if (isCodeMatching) {
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("Status code validation is successful - " + statusCodeConverted + " OK");
				if (isPresent) {
					// Read Entity using GET request
					System.out.println("Request posted to create record => " + requestBody);
					String fetchID = createResponseBody.substring(createResponseBody.indexOf("id"),
					createResponseBody.length());
					String[] parts = fetchID.split("\"");
					String idValueToPass = parts[2];
					System.out.println("Entity Record Created Successfully and ID is " + idValueToPass);
					
					RestAssured.baseURI = ReadPropertyFile.get("employeeurl")+"/employee";
					RequestSpecification httpRequest1 = RestAssured.given();
					Response response = httpRequest1.request(Method.GET, "/" + idValueToPass);
					String responseBody = response.getBody().asString();
					System.out.println("Response Body is =>  " + responseBody);
					System.out.println(
							"Does Employee name match against posted data : " + responseBody.contains(employee_name)
									+ " | Value posted : " + name + " & Value from API ::" + name);
					if(responseBody.contains(employee_name)){
						this.name = name;
					}
					System.out.println("Does Employee salary match: against posted data : "
							+ responseBody.contains(employee_salary) + " | Value posted : " + salary
							+ " & Value from API ::" + salary);
					if(responseBody.contains(employee_salary)){
						this.salary = salary;
					}
					System.out.println(
							"Does Employee age match against posted data : " + responseBody.contains(employee_age)
									+ " | Value posted : " + age + " & Value from API ::" + age);
					if(responseBody.contains(employee_age)){
						this.age = age;
					}
				} else {
					System.out
							.println("Entity not created and the error response received is => " + createResponseBody);
					SoftAssert softAssertion = new SoftAssert();
					softAssertion.assertEquals(0, 1, "test failed");
					}
				} else {
				System.err.println("Status Code is not 200");
				SoftAssert softAssertion = new SoftAssert();
				softAssertion.assertEquals(0, 1, "test failed");
				softAssertion.assertAll();
				}
		      
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
	}

	public String getName() {
		return name;
	}

	public String getSalary() {
		return salary;
	}

	public String getAge() {
		return age;
	}

}
