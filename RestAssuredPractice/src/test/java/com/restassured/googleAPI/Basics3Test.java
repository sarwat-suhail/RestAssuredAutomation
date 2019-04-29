package com.restassured.googleAPI;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics3Test {

	@Test
	public void AddandDeletePlace() {
		
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String b="{"+ 
				" \"location\":{"+	
				
				"\"lat\" : -38.383494,"+
					
				" \"lng\" : 33.427362 "+
					
			 " },"+
				 "\"accuracy\":50,"+		
					
				 "\"name\":\"Frontline house\","+	
					
				" \"phone_number\":\"(+91) 983 893 3937\","+
				 "\"address\" : \"29, side layout, cohen 09\","+
				 
				"\"types\": [\"shoe park\",\"shop\"],"+
				 
				 "\"website\" : \"http://google.com\","+
				 
				"\"language\" : \"French-IN\""+
				 
		"}";
		
		Response res=given().
		
		queryParam("key","qaclick123").
		
		body(b).
		
		when().
		
		post("/maps/api/place/add/json").
		
		then().assertThat().and().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK")).
		extract().response();
		
		// getting response in json 
		
		String responseString=res.asString();
		System.out.println(responseString);
		
		JsonPath js=new JsonPath(responseString);
		
	String PlaceID=	js.get("place_id");
	System.out.println(PlaceID);
		
		
		// delete the place 
	
	String ba="{" + 
			"\"place_id\":\""+PlaceID+"\"" + 
			"}";

	given().
	queryParam("key","qaclick123").
	body(ba).
when().
post("/maps/api/place/delete/json").
then().assertThat().and().statusCode(200).and().contentType(ContentType.JSON).and().
body("status",equalTo("OK"));
		
		
		
		
	}
	
	
	
	
	
}
