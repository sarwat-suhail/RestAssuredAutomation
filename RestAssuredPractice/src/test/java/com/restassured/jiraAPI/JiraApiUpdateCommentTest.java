package com.restassured.jiraAPI;

import org.testng.annotations.Test;

import com.restassured.Base;
import com.restassured.Resources;
import com.restassured.ReusableMethods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class JiraApiUpdateCommentTest extends Base {

	
	@Test
	public void updateComment() {
		
		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		
		String sessionkey=ReusableMethods.getSessionKey();
		String issueid=ReusableMethods.getIssueId();
		
		Response res=given().
			header("Content-Type","application/json").	
			header("Cookie","JSESSIONID="+sessionkey).
			body(Resources.addComment()).
			when().
			post(Resources.addCommentResource(issueid)).
			then().statusCode(201).
			extract().response();
		
		JsonPath jp=ReusableMethods.rawToJson(res);
		String commentid=jp.get("id");
		
		
		
		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		
		Response resp=given().
		header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+sessionkey).
		body(Resources.updateComment()).
		when().
		put("rest/api/2/issue/"+issueid+"/comment/"+commentid+"").
		then().
		extract().response();
		
	}
	
	
	
}
