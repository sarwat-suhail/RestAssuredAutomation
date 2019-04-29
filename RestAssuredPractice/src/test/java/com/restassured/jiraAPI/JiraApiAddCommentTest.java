package com.restassured.jiraAPI;

import org.testng.annotations.Test;

import com.restassured.Base;
import com.restassured.Resources;
import com.restassured.ReusableMethods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class JiraApiAddCommentTest extends Base {

	
	
	@Test
	public void addComment() {
		
		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		
	Response res=given().
		header("Content-Type","application/json").	
		header("Cookie","JSESSIONID="+ReusableMethods.getSessionKey()).
		body(Resources.addComment()).
		when().
		post(Resources.addCommentResource(ReusableMethods.getIssueId())).
		then().statusCode(201).
		extract().response();
	
	JsonPath jp=ReusableMethods.rawToJson(res);
	String commentid=jp.get("id");
	
	}
	
	
	
	
}
