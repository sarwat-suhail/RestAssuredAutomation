package com.restassured.jiraAPI;


import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.restassured.commonfiles.Resources;
import com.restassured.commonfiles.ReusableMethods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JiraApiTest extends com.restassured.base.Base{

	
	@Test
	public void createBug() {
		
		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		String session=ReusableMethods.getSessionKey();
		//System.out.println(session);
		//System.out.println(Resources.addBug());
		//System.out.println(Resources.addBugResource());
		
	Response res=given().
		header("Content-Type","application/json").	
		header("Cookie","JSESSIONID="+session).
		body(Resources.addBug()).
		when().
		post(Resources.addBugResource()).
		then().statusCode(201).
		extract().response();
		
		JsonPath jp=ReusableMethods.rawToJson(res);
		String issueid=jp.get("id");
		System.out.println(issueid);
		
	}
	
	
	
}
