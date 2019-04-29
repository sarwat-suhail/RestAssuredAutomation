package com.restassured;

import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ReusableMethods {
	
	public static Properties prop;
	
	
	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public static JsonPath rawToJson(Response r) {
		
		String resp=r.asString();
		JsonPath js=new JsonPath(resp);
		return js;
	}

	public static Object rawToXmlJson(Response r,String s) {
		if(s.equals("xml"))
		{
	String res=	r.asString();
    XmlPath x=new XmlPath(res);

    return x;
    }else {
    	    	
    	String resp=r.asString();
		JsonPath j=new JsonPath(resp);
	    

	    return j;
	    
    }
   		
		
	}
	
	public static String getSessionKey() {
		
		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		
	Response res=given().
		header("Content-Type","application/json").
		body("{ \"username\": \"suhqtp\", \"password\": \"suhail@123\" }").
		when().
		post("rest/auth/1/session").
		then().statusCode(200).
		extract().response();
	
       JsonPath jp=rawToJson(res);
       String sessionid=jp.get("session.value");
//System.out.println(sessionid);
       return sessionid;
	}
	
	
	public static String getIssueId() {
		
		
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
		
		return issueid;
		
	}
	
	
	
	
	
}
