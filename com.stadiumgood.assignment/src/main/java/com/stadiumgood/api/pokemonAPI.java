package com.stadiumgood.api;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import com.stadiumgood.UtilClasses.ReadPropertyFile;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class pokemonAPI{
	
	private List<String> nameValue = new ArrayList<String>();
	private List<String> urlValue = new ArrayList<String>();
	private List<String> hiddenValueVariable = new ArrayList<String>();
	private List<String> slotValueVariable = new ArrayList<String>();
	
	public pokemonAPI(String data) throws Exception{		
		RestAssured.baseURI = ReadPropertyFile.get("pokemonurl");
	    RequestSpecification httpRequest = RestAssured.given();
	    System.out.println(data);
	    Response response = httpRequest.request(Method.GET, "/"+data);
	    String responseBody = response.getBody().asString();
	    System.out.println(responseBody);
	    ObjectMapper mapper = new ObjectMapper();
		Object json = mapper.readValue(responseBody, Object.class);		
        String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);          
        JSONObject jsr = new JSONObject(indented); // JSON object with above data
        JSONArray content = jsr.getJSONArray("abilities");// get CONTENT which is Json array inside Demo
	    for (int j = 0; j < content.length(); j++) { // iterate over array to get inner JSON objects and extract values inside
	          JSONObject record = content.getJSONObject(j); // each item of Array is a JSON object
	          boolean hiddenValue = record.getBoolean("is_hidden");
	          int slotValue = record.getInt("slot");
	          nameValue.add(record.getJSONObject("ability").getString("name"));
	          urlValue.add(record.getJSONObject("ability").getString("url"));
	          hiddenValueVariable.add(String.valueOf(hiddenValue).toUpperCase());
	          slotValueVariable.add(String.valueOf(slotValue));        
	      }
	}
	
	
	public List<String> getnameValue(){
		return nameValue;
	}
	
	public List<String> geturlValue(){
		return urlValue;
	}
	
	public List<String> gethiddenValueVariable(){
		return hiddenValueVariable;
	}
	
	public List<String> getslotValueVariable(){
		return slotValueVariable;
	}
}
